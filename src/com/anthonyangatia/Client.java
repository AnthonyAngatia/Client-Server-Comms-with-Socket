package com.anthonyangatia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Objects;

public class Client implements ActionListener {

    private static  JLabel label;
    private static  JTextField userText = new JTextField(20);
    private static  JTextField faculty = new JTextField(20);
    private static  JTextField school = new JTextField(20);
    private static  JTextField admissionNo = new JTextField(20);
    private static  JTextField fName = new JTextField(20);
    private static  JTextField surname = new JTextField(20);
    private static  JTextField personalCode = new JTextField(20);
    private static Boolean all = false;
    private static JButton button;
    private static String response;
    private static Boolean buttonClicked = false;
    private static JFrame frame;
    public static void main(String[] args) {


        try {
            Socket kkSocket = new Socket("localhost", 4444);
            PrintStream outputStream = new PrintStream(kkSocket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(kkSocket.getInputStream());
            StringBuffer buf = new StringBuffer(50);

            int c;
            String fromServer;

            while ((fromServer = dataInputStream.readLine()) != null) {
                createUI(fromServer);
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye"))
                    break;
//                while ((c = System.in.read()) != '\n') {
//                    buf.append((char)c);
//                }
                cleanTextFields();
                while(buttonClicked == false){
                    System.out.print("");
                    if(buttonClicked == true) {
                        outputStream.println(response);
//                        cleanTextFields();
                        break;
                    }
                }
                buttonClicked = false;

//                System.out.println("Client: " + buf);
//                outputStream.println(buf.toString());
                outputStream.flush();//Sending it to the server
                buf.setLength(0);
            }

            outputStream.close();
            dataInputStream.close();
            kkSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (Exception e) {
            System.err.println("Exception:  " + e);
        }
    }

    private static void cleanTextFields() {
        userText.setText(" ");
        school.setText(" ");
        faculty.setText(" ");
        admissionNo.setText(" ");
        fName.setText(" ");
        personalCode.setText(" ");
    }

    private static void createUI(String fromServer) {
        userText = new JTextField(20);
        if(fromServer.equalsIgnoreCase("Enter Faculty and Course")){
            facultyCourseGUI();

        }else if(fromServer.equalsIgnoreCase("Enter All of the details")){
            allGUI();
            all = true;
        }else if(fromServer.equalsIgnoreCase("Enter Admission No.")){
            admissionGUI();
        }else if(fromServer.equalsIgnoreCase("Enter First and Surname")){
            nameGUI();
        }else if(fromServer.equalsIgnoreCase("Enter Personal Code")){
            personalCodeGUI();
        }
        else {
            frame = new JFrame();

            label = new JLabel( fromServer);
            label.setBounds(90,20,200,25);
            label.setFont(new Font("Serif", Font.PLAIN, 18));
            frame.add(label);

//            userText = new JTextField(20);
//            userText.setBounds(100,50,200,25);
//            frame.add(userText);

//            button = new JButton("SEND");
//            button.setBounds(120,80,100,25);
//            frame.add(button);
//            button.addActionListener(new Client());

        }
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    private static void facultyCourseGUI() {
        frame = new JFrame();

        label = new JLabel("Enter Faculty");
        label.setBounds(120,20,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        faculty = new JTextField(20);
        faculty.setBounds(100,50,200,25);
        frame.add(faculty);

        label = new JLabel("Enter Degree");
        label.setBounds(120,70,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        school = new JTextField(20);
        school.setBounds(100,90,200,25);
        frame.add(school);

        button = new JButton("SEND");
        button.setBounds(120,120,100,25);
        frame.add(button);
        button.addActionListener(new Client());
    }
    private static void allGUI() {
        all = true;
        frame = new JFrame();

        label = new JLabel("Enter Admission Number");
        label.setBounds(120,20,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

//        admissionNo = new JTextField(20);
        admissionNo.setBounds(100,50,200,25);
        frame.add(admissionNo);

        label = new JLabel("Enter First and Last Name");
        label.setBounds(120,80,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        fName = new JTextField(20);
        fName.setBounds(100,110,200,25);
        frame.add(fName);

        label = new JLabel("Enter Faculty");
        label.setBounds(120,140,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

//        faculty = new JTextField(20);
        faculty.setBounds(100,170,200,25);
        frame.add(faculty);

        label = new JLabel("Enter Course");
        label.setBounds(120,200,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

//        school = new JTextField(20);
        school.setBounds(100,230,200,25);
        frame.add(school);

        label = new JLabel("Enter Personal Code");
        label.setBounds(120,260,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

//        personalCode = new JTextField(20);
        personalCode.setBounds(100,290,200,25);
        frame.add(personalCode);

        button = new JButton("SEND");
        button.setBounds(120,310,100,25);
        frame.add(button);
        button.addActionListener(new Client());
    }
    private static void admissionGUI(){
        frame = new JFrame();

        label = new JLabel("Enter Admission Number");
        label.setBounds(120,20,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

//        admissionNo = new JTextField(20);
        admissionNo.setBounds(100,50,200,25);
        frame.add(admissionNo);

        button = new JButton("SEND");
        button.setBounds(120,80,100,25);
        frame.add(button);
        button.addActionListener(new Client());
    }
    private static void nameGUI(){
        frame = new JFrame();

        label = new JLabel("Enter First Name");
        label.setBounds(120,20,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        fName.setBounds(100,50,200,25);
        frame.add(fName);

        label = new JLabel("Enter Surname");
        label.setBounds(120,80,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        surname = new JTextField(20);
        surname.setBounds(100,110,200,25);
        frame.add(surname);

        button = new JButton("SEND");
        button.setBounds(120,140,100,25);
        frame.add(button);
        button.addActionListener(new Client());
    }
    private static void personalCodeGUI(){
        frame = new JFrame();

        label = new JLabel("Enter Personal Code");
        label.setBounds(120,20,200,25);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        frame.add(label);

        personalCode.setBounds(100,50,200,25);
        frame.add(personalCode);

        button = new JButton("SEND");
        button.setBounds(120,80,100,25);
        frame.add(button);
        button.addActionListener(new Client());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Clicked");
        if(all){
            response = admissionNo.getText()+ " " +fName.getText() + " " + surname.getText() + " "
                    + faculty.getText() + " " + school.getText() +
                    personalCode.getText();
        }
        if(!Objects.equals(faculty.getText(), " ")){
            response = faculty.getText() + " " + school.getText();
            System.out.println("Faculty:"+ response);
        }else if(!Objects.equals(admissionNo.getText(), " ")){
            response = admissionNo.getText();
            System.out.println("Admission:"+ response);
        }else if(!Objects.equals(fName.getText(), " ")){
            response = fName.getText() + " " + surname.getText() ;
            System.out.println("NAMES: "+ response);
        }else if(!Objects.equals(personalCode.getText(), " ")){
            response = personalCode.getText();
            System.out.println("Personal code:"+ personalCode.getText());
        }
        buttonClicked = true;
        System.out.println(response);
        frame.dispose();

    }
}
