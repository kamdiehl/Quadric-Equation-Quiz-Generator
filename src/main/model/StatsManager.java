package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatsManager implements Writable {
// only have the global statistics in this class. QuizResult will have the individual quiz results.

    private int totalCorrectAnswers;
    private int totalIncorrectAnswers;
    private int totalQuestionsAsked;
    private List<StatValue> statList;
    private String statHistory;

    // JSON


    // constructor
    public StatsManager(String statHistory) {
        this.statHistory = statHistory;
        statList = new ArrayList<>();
        //this.correctAnswers = qm.getCorrectAnswers();
     //   this.totalCorrectAnswers = qm.getOverallCorrectAnswers(); // this will have to be saved somehow

    }

    // MODIFIES: this
    // EFFECTS: adds another QuizResult to this Statistic List.
    public void addThingy(StatValue results) {
        statList.add(results);
    }


    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<StatValue> getAllStats() {
        return Collections.unmodifiableList(statList);
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

    public int getTotalCorrectAnswers() {
        return totalCorrectAnswers;
    }

    public int getTotalIncorrectAnswers() {
        return totalIncorrectAnswers;
    }

    public int getTotalQuestionsAsked() {
        return totalQuestionsAsked;
    }


}
