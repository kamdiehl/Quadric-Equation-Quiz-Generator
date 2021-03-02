package ui;

import model.QuestionMaster;
import model.QuizEntry;

import java.util.Scanner;

// This class is the face of the Surface Generator, provides method for main() to call and start the app,
// and processes user input.
public class QuadricApp {

    private Scanner input;
    private int correctAnswers;
    private int questionsAsked;
    private int currentQuestion;


    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() {
        runApp();
    }

    // EFFECTS: processes user input, calls new questions until number of questions asked equals
    //          the quiz length inputted by user.

    @SuppressWarnings("checkstyle:MethodLength")
    public void runApp() { // FIX METHOD LENGTH
        input = new Scanner(System.in);
        System.out.println("Enter 1 to start, enter 0 to exit");
        int userInput = input.nextInt();
        while (userInput != 0) {
            System.out.println("How many questions do you want to be asked?");
            int userInput2 = input.nextInt();

            QuestionMaster newQuiz = new QuestionMaster(userInput2, 10, 1);
            newQuiz.createNewQuestionList(userInput2);


            for (int i = 0; i < userInput2; i++) { // loop for each of the questions made
                QuizEntry currentQuiz = newQuiz.getQuestionList().get(i); // get i index question/answer pair

                System.out.println(currentQuiz.getQuestion()); // print question to user

                String userAnswer = input.next();  // debugger says getQuestion above is NULL
                Boolean isCorrect = checkAnswer(userAnswer, currentQuiz.getAnswer());

                if (isCorrect) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect");
                }
                currentQuestion++;
            }

            System.out.println("Quiz score: " + newQuiz.getCorrectAnswers() + "/" + newQuiz.getQuizLength());
            correctAnswers += newQuiz.getCorrectAnswers();
            questionsAsked += newQuiz.getQuizLength();
            System.out.println("Overall score: " + correctAnswers + "/" + questionsAsked);

            System.out.println("Enter 1 to start, enter 0 to exit");
            userInput = input.nextInt();
        }
    }



    public boolean checkAnswer(String userAnswer, String answer) {
        return userAnswer.equals(answer);
    }

}
