package model;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionMaster {

    // These provide the range of what the coefficients a,b,c can exist between
    private int maxValue = 10;
    private int minValue = 1;
    // These keep track of what question user is on, number of correct answers, and quiz length
    private int currentQuestion;
    private int correctAnswers;
    private int quizLength;

    private Scanner input;

    ArrayList<Surface> surfaceList = new ArrayList<Surface>(3);

    public QuestionMaster(int ql, int maxVal, int minVal) {
        maxValue = maxVal;
        minValue = minVal;
        quizLength = ql;
    }


    void sphereQuestion() {
        Sphere s = new Sphere();
        s.generateSphere(this);
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

    void ellipsoidQuestion() {
        Ellipsoid e = new Ellipsoid();
        e.generateEllipsoid(this);
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

    void coneQuestion() {
        Cone c = new Cone();
        c.generateCone(this);
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

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void askQuestion() {

        input = new Scanner(System.in);
        int maxSurfaceCount = 3;
        int randNum = (int)(Math.random() * (maxSurfaceCount - 1 + 1) + 1);

        if (randNum == 1) {
            sphereQuestion();
        }

        if (randNum == 2) {
            ellipsoidQuestion();
        }

        if (randNum == 3) {
            coneQuestion();
        }
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

}
