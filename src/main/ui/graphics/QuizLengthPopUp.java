package ui.graphics;

import model.QuestionMaster;
import model.QuizEntry;

import javax.swing.*;
import java.awt.*;

// Controls the pop-up window that asks the user how many quiz questions they want. Sends userInputNum to QuestionMaster
// for further interpretation by the quiz classes.
public class QuizLengthPopUp {

    private JFrame popUp;
    private int userInputNum;
    private QuestionMaster newQuiz;


    // constructor
    public QuizLengthPopUp() {
        initiatePopUp();
        String userInputString = JOptionPane.showInputDialog(popUp,
                "Enter the number of questions you want in your quiz");
        userInputNum = Integer.parseInt(userInputString);
        setUserInputNum(userInputNum);


        // HERE IS WHERE WE INSTANTIATE THE NEW QUIZ
        newQuiz = new QuestionMaster(userInputNum, 10, 1);
        newQuiz.setQuizLength(userInputNum);

        new JScrollablePanelTest(userInputNum);
    }

    public void initiatePopUp() {
        popUp = new JFrame();
        popUp.setForeground(Color.pink);
    }



    // getters & setters


    public int getUserInputNum() {
        return userInputNum;
    }

    public void setUserInputNum(int userInputNum) {
        this.userInputNum = userInputNum;
    }
}
