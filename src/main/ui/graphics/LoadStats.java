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
