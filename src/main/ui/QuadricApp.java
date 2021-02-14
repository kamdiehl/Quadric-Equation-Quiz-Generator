package ui;

import model.QuestionMaster;
import java.util.Scanner;

public class QuadricApp {

    private Scanner input;

    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() {
        runApp();
    }

    public void runApp() {
        input = new Scanner(System.in);
        System.out.println("Enter 1 to start, enter 0 to exit");
        int userInput = input.nextInt();
        while (userInput != 0) {
            System.out.println("How many questions do you want to be asked?");
            int userInput2 = input.nextInt();

            QuestionMaster newQuiz = new QuestionMaster(userInput2, 10, 1);
            while (newQuiz.getCurrentQuestion() < newQuiz.getQuizLength()) {
                newQuiz.askQuestion();
            }
            System.out.println("Quiz score: " + newQuiz.getCorrectAnswers() + "/" + newQuiz.getQuizLength());
            System.out.println("Enter 1 to start, enter 0 to exit");
            userInput = input.nextInt();
        }
    }

}
