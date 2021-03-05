package persistence;

import model.QuestionMaster;
import model.QuizEntry;
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


//    // MODIFIES: this
//    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
//    // be opened for writing
//    public void open() throws FileNotFoundException {
//        writer = new PrintWriter(new File(destination));
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: writes JSON representation of a incorrect q (isn't a string already in JSON format)
//    // but no, i should have this as "writes incorrect answer to file"
//    public void write(String eq) {
//      //  JSONObject json = eq.toJson();
//        saveToFile(eq); //TAB why was that there
//        // I should have this take in a string and then get rid of the .toString()
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: closes writer
//    public void close() {
//        writer.close();
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: writes string to file
//    public void saveToFile(String json) {
//        writer.print(json);
//    }
//    // whats the diff between this and write

}
