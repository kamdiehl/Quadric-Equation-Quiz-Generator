package ui.graphics;

import model.StatsManager;
import persistence.JsonReader;
import java.io.IOException;

// When instantiated, loads the data from file.
public class LoadStats {

    private static final String JSON_STORE = "./data/workroom.json";
    private JsonReader jsonReader;
    private StatsManager statMan;

    // constructor
    // calls the loadStats method to load data from file
    public LoadStats(StatsManager statsManager, JsonReader jsonReaders) {
        this.statMan = statsManager;
        this.jsonReader = jsonReaders;

        loadStats();
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadStats() {

        try {

            StatsManager loadedStatMan = jsonReader.read();
            statMan.setOverallCorrectAnswers(loadedStatMan.getOverallCorrectAnswers());
            statMan.setOverallIncorrectAnswers(loadedStatMan.getOverallIncorrectAnswers());
            statMan.setStatList(loadedStatMan.getAllStats());

            System.out.println("Loaded " + statMan.getStatHistory() + " from " + JSON_STORE);

        } catch (IOException e) {

            System.out.println("Unable to read from file: " + statMan.getStatHistory() + JSON_STORE);
        }
    }

}
