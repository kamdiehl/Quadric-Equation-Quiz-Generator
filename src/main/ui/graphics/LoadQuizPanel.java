package ui.graphics;

import model.StatValue;
import model.StatsManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class LoadQuizPanel {

    private JScrollPane quizScroll;
    private JPanel resultsPanel;
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonReader jsonReader;

    public LoadQuizPanel(StatsManager statsManager) {
        resultsPanel = new JPanel();
        quizScroll = new JScrollPane(resultsPanel);
        jsonReader = new JsonReader(JSON_STORE);
        loadStats(statsManager);
        printStats(statsManager);
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadStats(StatsManager statsManager) {
        try {
            statsManager = jsonReader.read();
            System.out.println("Loaded " + statsManager.getStatHistory() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + statsManager.getStatHistory() + JSON_STORE);
        }
    }


    // EFFECTS: prints all the thingies in workroom to the console
    private void printStats(StatsManager statsManager) {
        List<StatValue> thingies = statsManager.getAllStats();
        int counter = 1;
        System.out.println("Quiz 1");
        for (StatValue t: thingies) {
            System.out.println(t);
            int indexNum = thingies.lastIndexOf(t);
            if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
                System.out.println(" ");
                counter++;
                System.out.println("Quiz " + counter);

            }
        }
    }






}
