package ui;

import java.util.Scanner;

// This class is the face of the Surface Generator, provides method for main() to call and start the app,
// and processes user input.
public class QuadricApp {

    private Scanner input;
    private int correctAnswers;
    private int questionsAsked;

    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() {
        runApp();
    }

    // EFFECTS: processes user input, calls new questions until number of questions asked equals
    //          the quiz length inputted by user.
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
            correctAnswers += newQuiz.getCorrectAnswers();
            questionsAsked += newQuiz.getQuizLength();
            System.out.println("Overall score: " + correctAnswers + "/" + questionsAsked);

            System.out.println("Enter 1 to start, enter 0 to exit");
            userInput = input.nextInt();
        }
    }

}
