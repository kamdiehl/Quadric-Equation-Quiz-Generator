package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Citation: Model of code was taken from JsonSterilizationDemo.
// Represents a reader that reads StatManager from JSON data stored in a file.
public class JsonReader {
    private String source;


    // Constructor
    // EFFECTS: Constructs a reader to read saved source files
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads StatsManager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public StatsManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseStatsManager(jsonObject);

    }

    // what
    // EFFECTS: reads source file as string and returns it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses StatsManager from JSON object and returns it
    private StatsManager parseStatsManager(JSONObject jsonObject) {
        String statHistory = jsonObject.getString("statHistory");
        StatsManager stats = new StatsManager(statHistory);
        addAllStats(stats, jsonObject);
        return stats;
    }


    // MODIFIES: sm
    // EFFECTS: parses thingies from JSON object and adds them to StatsManager
    private void addAllStats(StatsManager sm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("allStats");
        for (Object json : jsonArray) {
            JSONObject nextStat = (JSONObject) json;
            addIsolatedStat(sm, nextStat);
        }
    }

    // MODIFIES: sm
    // EFFECTS: parses thingy from JSON object and adds it to StatsManager
    private void addIsolatedStat(StatsManager sm, JSONObject jsonObject) {
        int value = jsonObject.getInt("value");
        StatCategory category = StatCategory.valueOf(jsonObject.getString("category"));
        StatValue isolatedStat = new StatValue(category, value);
        sm.addStat(isolatedStat);

    }


}
