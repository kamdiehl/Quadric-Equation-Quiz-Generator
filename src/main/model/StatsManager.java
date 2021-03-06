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

    // JSON
    private String history;



    // constructor
    public StatsManager() {
        statList = new ArrayList<>();
        //this.correctAnswers = qm.getCorrectAnswers();
     //   this.totalCorrectAnswers = qm.getOverallCorrectAnswers(); // this will have to be saved somehow

    }

    // MODIFIES: this
    // EFFECTS: adds another QuizResult to this Statistic List.
    public void addThingy(StatValue results) {
        statList.add(results);
    }



    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("History", history);
        json.put("thingies", statsToJson());
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

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<StatValue> getAllStats() {
        return Collections.unmodifiableList(statList);
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
