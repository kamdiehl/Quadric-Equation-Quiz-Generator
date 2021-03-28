package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.ArrayList;
import java.util.List;

// Represents a list of StatValues that compile to make the list of stats.
public class StatsManager implements Writable {

    private List<StatValue> statList;
    private String statHistory;
    private int overallCorrectAnswers;
    private int overallIncorrectAnswers;
    private int overallQuestionsAsked;

    // constructor
    public StatsManager(String statHistory) {
        this.statHistory = statHistory;
        statList = new ArrayList<>();
    }


    // MODIFIES: this
    // EFFECTS: adds another StatValue to this Statistic List.
    public void addStat(StatValue results) {
        statList.add(results);
    }



    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<StatValue> getAllStats() {
        return (statList);
    }



    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("statHistory", statHistory);
        json.put("allStats", statsToJson());
        return json;
    }


    // EFFECTS: returns things in this statList as a JSON array
    private JSONArray statsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (StatValue i : statList) {
            jsonArray.put(i.toJson());
        }
        return jsonArray;
    }



    // getters

    public String getStatHistory() {
        return statHistory;
    }

    public int getOverallCorrectAnswers() {
        return overallCorrectAnswers;
    }

    public void setOverallCorrectAnswers(int correct) {
        this.overallCorrectAnswers = correct;
    }

    public int getOverallIncorrectAnswers() {
        return overallCorrectAnswers;
    }

    public void setOverallIncorrectAnswers(int incorrect) {
        this.overallIncorrectAnswers = incorrect;
    }

    public void setStatList(List<StatValue> statList) {
        this.statList = statList;
    }
}
