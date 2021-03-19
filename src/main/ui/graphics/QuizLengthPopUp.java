package ui.graphics;

import javax.swing.*;
import java.awt.*;

// Controls the pop-up window that asks the user how many quiz questions they want. Sends userInputNum to QuestionMaster
// for further interpretation by the quiz classes.
public class QuizLengthPopUp {
    private JFrame popUp;
    private int userInputNum;


    // constructor
    public QuizLengthPopUp() {
        initiatePopUp();
        String userInputString = JOptionPane.showInputDialog(popUp,"Enter the number of questions you want in your quiz");
        userInputNum = Integer.parseInt(userInputString);
    }

    public void initiatePopUp() {
        popUp = new JFrame();
        popUp.setForeground(Color.pink);
    }





    // getters & setters


    public int getUserInputNum() {
        return userInputNum;
    }


}
