package com.anthonyangatia;

public class Protocol {
    private static final int WAITING = 0;
    private static final int SENT_ENTER_ADMIN_NO = 1;
    private static final int SENT_ENTER_LAST_NAME = 3;
    private static final int SENT_ENTER_FACULTY= 4;
    private static final int SENT_ENTER_PERSONAL_CODE= 5;
    private static final int SENT_ALL_IN_ONE= 6;
    private static final int END= 7;
    private int state = WAITING;
/**
This method maintains the current state of
 communication between the server and the client.
 It sends a response to the client based on the input given.
**/
    String processInput(String theInput){
        String theOutput = null;
        if(state == WAITING){
            theOutput = "Enter Admission No.";
            state = SENT_ENTER_ADMIN_NO;
        }else if (state == SENT_ENTER_ADMIN_NO){
            theOutput = "Enter First and Surname";
            state = SENT_ENTER_LAST_NAME;
        }else if(state == SENT_ENTER_LAST_NAME){
            theOutput = "Enter Faculty and Course";
            state = SENT_ENTER_FACULTY;
        }else if(state == SENT_ENTER_FACULTY){
            theOutput = "Enter Personal Code";
            state = SENT_ENTER_PERSONAL_CODE;
        }else if(state == SENT_ENTER_PERSONAL_CODE){
            theOutput = "Enter All of the details";
            state = SENT_ALL_IN_ONE;
        }else if(state == SENT_ALL_IN_ONE) {
            theOutput = "Thank you that is all!";
            state = END;
        }
        return theOutput;
    }


}
