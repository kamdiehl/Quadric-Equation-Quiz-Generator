package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class handles the making of the questions that are presented to user. It also handles the user input.
public class QuestionMaster {

    // These provide the range of what the coefficients a,b,c can exist between
    private int maxValue = 10;
    private int minValue = 1; //WHY ARENT THESE BEING USED NOW

    // These keep track of what question user is on, number of correct answers, and quiz length
    private int currentQuestion;
    private int correctAnswers;
    private String answer;
    private String question;

    private ArrayList<QuizEntry> questionList;

    private int quizLength;

    private Scanner input; //get rid of this and make the ui package deal wth it


    // Constructor
    public QuestionMaster(int ql, int maxVal, int minVal) {
        maxValue = maxVal;
        minValue = minVal;
        quizLength = ql;
        questionList = new ArrayList<>();

    }

    public List<QuizEntry> createNewQuestionList(int numOfQuestions) {  // IS THIS THE RIGHT RETURN TYPE
        quizLength = numOfQuestions; // yes no?
        QuestionMaster newQu = new QuestionMaster(getQuizLength(), getMaxValue(), getMinValue());

        for (int i = 0; i < numOfQuestions; i++) {
            QuizEntry newQuestion = new QuizEntry(newQu.question, newQu.answer); // its probably null cuz of

            questionList.add(newQuestion);
        }
        return questionList;
    }








    // EFFECTS: Generates a sphere equation to present to user, adds 1 to correct answers if right
    void sphereQuestion() {
        Sphere s = new Sphere();
        s.generateSphere(getMaxValue(), getMinValue());
        System.out.println(s.eqToString());
        String userAnswer = input.next();
        if (userAnswer.equals("sphere")) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect");
            System.out.println("This is a sphere");
        }
        currentQuestion++;
    }

    // EFFECTS: Generates an ellipsoid equation to present to user, adds 1 to correct answers if right
    void ellipsoidQuestion() {
        Ellipsoid e = new Ellipsoid();
        e.generateEllipsoid(getMaxValue(), getMinValue());
        System.out.println(e.eqToString());
        String userAnswer = input.next();
        if (userAnswer.equals("ellipsoid")) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect");
            System.out.println("This is an ellipsoid");
        }
        currentQuestion++;
    }

    // EFFECTS: Generates a cone equation to present to user, adds 1 to correct answers if right
    void coneQuestion() {
        Cone c = new Cone();
        c.generateCone(getMaxValue(),getMinValue());
        System.out.println(c.eqToString());
        String userAnswer = input.next();
        if (userAnswer.equals("cone")) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect");
            System.out.println("This is a cone");
        }
        currentQuestion++;
    }



    // Getters

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getQuizLength() {
        return quizLength;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public List<QuizEntry> getQuestionList() {
        return questionList;
    }

}
