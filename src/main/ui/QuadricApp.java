package ui;

import model.QuestionMaster;
import model.QuizEntry;
import java.util.Scanner;

// This class provides method for main() to call and start the app, and processes user input.
public class QuadricApp {

    private Scanner input;
    private int userInput2;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private int currentQuestion;


    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() {
        runApp();
    }



    // EFFECTS: Initiates the app by asking user if they want to begin and how many questions they want to be asked.
    //          Then calls runQuiz to iterate through question array list.
    public void runApp() {
        input = new Scanner(System.in);
        System.out.println("Enter 1 to start, enter 0 to exit");
        int userInput = input.nextInt();
        while (userInput != 0) {
            System.out.println("How many questions do you want to be asked?");
            userInput2 = input.nextInt();

            runQuiz();

            System.out.println("Enter 1 to start, enter 0 to exit");
            userInput = input.nextInt();
        }
    }



    // EFFECTS: Causes the QuestionMaster to produce x number of questions and iterates through them after each
    //          user answer. Once quiz is over, produces results.
    public void runQuiz() {

        QuestionMaster newQuiz = new QuestionMaster(userInput2, 10, 1);
        newQuiz.createNewQuestionList(userInput2);
        currentQuestion = 0;
        correctAnswers = 0;

        for (int i = 0; i < userInput2; i++) { // loop for each of the questions made
            QuizEntry currentQuiz = newQuiz.getQuestionList().get(i); // get i index question/answer pair

            String currentEquation = currentQuiz.getQuestion(); // get i index question from that pair

            System.out.println(currentEquation); // print 1 question to user

            String userAnswer = input.next();

            if (checkAnswer(userAnswer, currentQuiz.getAnswer())) {
                System.out.println("Correct!");
                overallCorrectAnswers++;
                correctAnswers++;
            } else {
                System.out.println("Incorrect");
                System.out.println("The answer was " + currentQuiz.getAnswer());
            }
            currentQuestion++;
        }

        System.out.println("Quiz score: " + correctAnswers + "/" + newQuiz.getQuizLength());
        overallCorrectAnswers += newQuiz.getCorrectAnswers();
        questionsAsked += newQuiz.getQuizLength();
        System.out.println("Overall score: " + overallCorrectAnswers + "/" + questionsAsked);

    }



    // EFFECTS: Compares the user's answer to the correct answer for that question, returns true if correct.
    public boolean checkAnswer(String userAnswer, String answer) {
        return userAnswer.equals(answer);
    }

}
