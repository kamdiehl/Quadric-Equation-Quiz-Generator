package persistence;

import model.QuestionMaster;
import model.QuizEntry;
import model.StatsManager;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonWriter {
    private String destination;
    private PrintWriter writer;
    private static final int TAB = 4; // what do this mean


    // Constructor
    public JsonWriter(String destination) {

        this.destination = destination;
    }

// MODIFIES: this
    // EFFECTS: writes JSON representation of a stat
    public void write(StatsManager stats) {
        JSONObject json = stats.toJson();
        saveToFile(json.toString(TAB));

    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }


    // MODIFIES: this
    // EFFECTS: writes string to file

    private void saveToFile(String json) {
        writer.print(json);
    }


}
