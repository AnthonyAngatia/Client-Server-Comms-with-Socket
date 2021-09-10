package com.anthonyangatia;

public class Protocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENT_ENTER_ADMIN_NO = 1;
    private static final int SENT_ENTER_FIRST_NAME = 2;
    private static final int SENT_ENTER_LAST_NAME = 3;
    private static final int SENT_ENTER_FACULTY= 4;
    private static final int SENT_ENTER_PERSONAL_CODE= 5;
    private static final int SENT_ALL_IN_ONE= 6;
    private static final int END= 7;




    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String clues[] = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String answers[] = { "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?" };
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

//    String processInput(String theInput) {
//        String theOutput = null;
//
//        if (state == WAITING) {
//            theOutput = "Knock Knock!";
//            state = SENTKNOCKKNOCK;
//        } else if (state == SENTKNOCKKNOCK) {
//            if (theInput.equalsIgnoreCase("Who's There?")) {
//                theOutput = clues[currentJoke];
//                state = SENTCLUE;
//            } else {
//                theOutput = "You're supposed to say \"Who's There?\"! Try again. Knock Knock!";
//            }
//        } else if (state == SENTCLUE) {
//            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
//                theOutput = answers[currentJoke] + " Want another? (y/n)";
//                state = ANOTHER;
//            } else {
//                theOutput = "You're supposed to say \"" + clues[currentJoke] + " who?\"" + "! Try again. Knock Knock!";
//                state = SENTKNOCKKNOCK;
//            }
//        } else if (state == ANOTHER) {
//            if (theInput.equalsIgnoreCase("y")) {
//                theOutput = "Knock Knock!";
//                if (currentJoke == (NUMJOKES - 1))
//                    currentJoke = 0;
//                else
//                    currentJoke++;
//                state = SENTKNOCKKNOCK;
//            } else {
//                theOutput = "Bye";
//                state = WAITING;
//            }
//        }
//        return theOutput;
//    }
}
