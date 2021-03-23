package ui.graphics;

import model.QuestionMaster;
import model.StatCategory;
import model.StatValue;
import model.StatsManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LoadQuizPanel {

    StatsManager statsManager = new StatsManager("statHistory");
    private int correctAnswers;
    private QuestionMaster qm;


    // json
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public LoadQuizPanel(QuestionMaster newQuiz) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        correctAnswers = newQuiz.getCorrectAnswers();
        qm = newQuiz;
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
        int length = qm.getQuizLength();  // newQuiz
        int incorrect = length - correct;
        StatCategory category = StatCategory.values()[1];
        incorrectStat = new StatValue(category, incorrect);
        return incorrectStat;

    }

    //EFFECTS: Turns the quiz length into a StatValue.
    public StatValue readQuizLength() {
        StatValue lengthStat;
        int length = qm.getQuizLength(); // newQuiz
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
