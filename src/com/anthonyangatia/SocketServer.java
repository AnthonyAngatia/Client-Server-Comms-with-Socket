package com.anthonyangatia;

import java.io.*;
import java.net.*;
public class SocketServer {
    public static int portNumber = 4444;
    public static void main(String[] args){
        try{
            ServerSocket serverSocket=new ServerSocket(portNumber);
            Socket clientSocket=serverSocket.accept();//establishes connection
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter os =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            String inputLine, outputLine;
            Protocol kkp = new Protocol();
            outputLine = kkp.processInput(null);
            os.println(outputLine);
            os.flush();

            while ((inputLine = is.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                os.println(outputLine);
                os.flush();
                if (outputLine.equals("Bye"))
                    break;
            }
            os.close();
            is.close();
            clientSocket.close();
            serverSocket.close();

        }catch(Exception e){
            System.out.println("Could not listen on port: " + portNumber + ", "+e);
        }


    }
}
