package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// This class provides method for main() to call and start the app, and processes user input.
public class QuadricApp {

    QuestionMaster newQuiz;
    QuizEntry currentQuiz;
    StatsManager statsManager = new StatsManager("statHistory");

    private Scanner input;
    private int userQuizLength;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private int currentQuestion;

    // json
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() throws FileNotFoundException {
        newQuiz = new QuestionMaster(userQuizLength, 10, 1);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();

    }


    // EFFECTS: Initiates the app by asking user if they want to begin and how many questions they want to be asked.
    //          Then calls runQuiz to iterate through question array list.
    public void runApp() {
        input = new Scanner(System.in);
        System.out.println("Enter 1 to start, enter 0 to exit, 2 to load");


        while (true) {
            int userInput = input.nextInt();
            if (userInput == 1) {
                System.out.println("How many questions do you want to be asked?");
                userQuizLength = input.nextInt();
                newQuiz.setQuizLength(userQuizLength);

                runQuiz();

            }
            if (userInput == 2) {
                System.out.println("Fetching Quiz Stats ...");
                loadStats();
                printStats();
            }
            if (userInput == 0) {
                System.out.println("Exiting program ...");
                System.out.println("Goodbye!");
                break;
            }

        }
    }



    // EFFECTS: Causes the QuestionMaster to produce x number of questions and iterates through them after each
    //          user answer.
    public void runQuiz() {

        newQuiz.createNewQuestionList(userQuizLength);
        currentQuestion = 0;
        correctAnswers = 0;

        for (int i = 0; i < userQuizLength; i++) { // loop for each of the questions made
            currentQuiz = newQuiz.getQuestionList().get(i); // get i index question/answer pair

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
        postQuiz();
        runApp();
    }



    // EFFECTS: Displays quiz score to user and loops back to the start.
    public void postQuiz() {
        System.out.println("Quiz score: " + correctAnswers + "/" + newQuiz.getQuizLength());
        overallCorrectAnswers += newQuiz.getCorrectAnswers();
        questionsAsked += newQuiz.getQuizLength();

        System.out.println("Overall score: " + overallCorrectAnswers + "/" + questionsAsked);

        addQuizResults();

        System.out.println("Do you want to save these quiz stats?");
        System.out.println("1 for yes, 0 for no");
        int userInput3 = input.nextInt();
        if (userInput3 != 0) {
            saveQuiz();
        }
    }


    // EFFECTS: Compares the user's answer to the correct answer for that question, returns true if correct.
    public boolean checkAnswer(String userAnswer, String answer) {
        return userAnswer.equals(answer);
    }



    //EFFECTS: Turns the number of correct answers from quiz into a StatValue.
    public StatValue readCorrectAnswers() {
        StatValue correctStat;

        int correct = correctAnswers;
        StatCategory category = StatCategory.values()[0];
        correctStat = new StatValue(category, correct);
        return correctStat;

    }

    //EFFECTS: Turns the number of incorrect answers from quiz into a StatValue.
    public StatValue readIncorrectAnswers() {
        StatValue incorrectStat;

        int correct = correctAnswers;
        int length = newQuiz.getQuizLength();
        int incorrect = length - correct;
        StatCategory category = StatCategory.values()[1];
        incorrectStat = new StatValue(category, incorrect);
        return incorrectStat;

    }

    //EFFECTS: Turns the quiz length into a StatValue.
    public StatValue readQuizLength() {
        StatValue lengthStat;
        int length = newQuiz.getQuizLength();
        StatCategory category = StatCategory.values()[2];
        lengthStat = new StatValue(category, length);
        return lengthStat;
    }


    // MODIFIES: this
    // EFFECTS: prompt user for name and category of thingy and adds to workroom
    private void addQuizResults() {

        StatValue correct = readCorrectAnswers();
        StatValue incorrect = readIncorrectAnswers();
        StatValue length = readQuizLength();

        statsManager.addStat(correct);
        statsManager.addStat(incorrect);
        statsManager.addStat(length);
    }


    // EFFECTS: prints all the thingies in workroom to the console
    private void printStats() {
        List<StatValue> thingies = statsManager.getAllStats();
        int counter = 1;
        System.out.println("Quiz 1");
        for (StatValue t: thingies) {
            System.out.println(t);
            int indexNum = thingies.lastIndexOf(t); // if statement below is temporary
            if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
                System.out.println(" ");
                counter++;
                System.out.println("Quiz " + counter);

            }
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveQuiz() {
        try {
            jsonWriter.open();
            jsonWriter.write(statsManager);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadStats() {
        try {
            statsManager = jsonReader.read();
            System.out.println("Loaded " + statsManager.getStatHistory() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + statsManager.getStatHistory() + JSON_STORE);
        }
    }



}

