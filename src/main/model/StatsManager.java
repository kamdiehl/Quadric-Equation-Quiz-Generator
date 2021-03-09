package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import ui.QuadricApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatsManager implements Writable {
// only have the global statistics in this class. QuizResult will have the individual quiz results.

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
    } // I think part of the problem has something to do with this.
    // (regarding why its not separating the stat tuples)


    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<StatValue> getAllStats() {
        return Collections.unmodifiableList(statList);
    }


    public void setGlobalStats(QuestionMaster qm) {

        // setting global correct answers stat
        int globalCorrect = qm.getCorrectAnswers();
        setOverallCorrectAnswers(globalCorrect);

        // setting total questions asked stat
        int globalAsked = qm.getQuizLength();
        setOverallQuestionsAsked(globalAsked);

        // setting global incorrect answers stat
        int globalIncorrect = globalCorrect - globalAsked;
        setOverallIncorrectAnswers(globalIncorrect);
    }


    // I want to put the overall correct and incorrect answers here, but I'm not sure how.
    // Also, to do a global thing like this, I'm gonna have to call the json file holding the overall
    // correct and incorrect answers to add them on right
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("statHistory", statHistory);

        //json.put("TotalCorrectAnswers",overallCorrectAnswers);
        //json.put("TotalIncorrectAnswers",overallIncorrectAnswers);
       // json.put("TotalQuestionsAsked",overallQuestionsAsked);

        json.put("allStats", statsToJson());
        return json;
    }

    // EFFECTS: returns things in this statList as a JSON array
    private JSONArray statsToJson() {
        JSONArray jsonArray = new JSONArray();

//        for (int t = 0; t > 5; t++) {
//            StatValue currentStat = statList.get(t);
//            jsonArray.put(currentStat.toJson());
//        }

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

    public void setOverallQuestionsAsked(int total) {
        this.overallQuestionsAsked = total;
    }

    public int getOverallQuestionsAsked() {
        return overallQuestionsAsked;
    }



}
