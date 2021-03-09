package ui;

import model.*;
import org.json.JSONObject;
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
    StatValue statValue;

    private Scanner input;
    private int userQuizLength;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private int currentQuestion;


    private static final String JSON_STORE = "./data/workroom.json";
    JSONObject jsonObject;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() throws FileNotFoundException {
        newQuiz = new QuestionMaster(userQuizLength, 10, 1);
       // statsManager = new StatsManager("statHistory");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();

    }


    // EFFECTS: Initiates the app by asking user if they want to begin and how many questions they want to be asked.
    //          Then calls runQuiz to iterate through question array list.
    public void runApp() {
        input = new Scanner(System.in);
        System.out.println("Enter 1 to start, enter 0 to exit, 2 to load");
        int userInput = input.nextInt();
        while (userInput == 1) {
            System.out.println("How many questions do you want to be asked?");
            userQuizLength = input.nextInt();
            newQuiz.setQuizLength(userQuizLength);

            runQuiz();

            System.out.println("Enter 1 to start, enter 0 to exit, 2 to load");
            userInput = input.nextInt();
        }

        while (userInput == 2) {
            loadStats();
            printStats();
        }

    }


    // EFFECTS: Causes the QuestionMaster to produce x number of questions and iterates through them after each
    //          user answer. Once quiz is over, produces results.
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

        System.out.println("Quiz score: " + correctAnswers + "/" + newQuiz.getQuizLength());
        overallCorrectAnswers += newQuiz.getCorrectAnswers();
        questionsAsked += newQuiz.getQuizLength();

        System.out.println("Overall score: " + overallCorrectAnswers + "/" + questionsAsked);
        //newQuiz.setOverallCorrectAnswers(overallCorrectAnswers);

        addQuizResults(); // temporary

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


    // JSON

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

        statsManager.addThingy(correct);
        statsManager.addThingy(incorrect);
        statsManager.addThingy(length);
    }


    // EFFECTS: prints all the thingies in workroom to the console
    private void printStats() {
        List<StatValue> thingies = statsManager.getAllStats();

        for (StatValue t: thingies) {
            System.out.println(t);
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

