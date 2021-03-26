package ui.graphics;

import model.StatsManager;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoadStats {
    private static final int TITLE_FONT = 15;
    private JScrollPane quizScroll;
    private JPanel resultsPanel;
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonReader jsonReader;
    private StatsManager statMan;

    public LoadStats(StatsManager statsManager) {
        this.statMan = statsManager;
        jsonReader = new JsonReader(JSON_STORE);
        loadStats();
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadStats() {
        try {
            statMan = jsonReader.read();
            System.out.println("Loaded " + statMan.getStatHistory() + " from " + JSON_STORE);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + statMan.getStatHistory() + JSON_STORE);
        }
    }

}
