package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a single stat value, with the type of stat (ex. correctAnswers) and the value of the stat.
public class StatValue implements Writable {

    private int value;
    private StatCategory category;

    // EFFECTS: constructs a stat with a value and category
    public StatValue(StatCategory category, int value) {
        this.value = value;
        this.category = category;
    }

    public int getValue() {
        return value;
    }

    public StatCategory getCategory() {
        return category;
    }

    // EFFECTS: returns string representation of this stat.
    public String toString() {
        return category + ": " + value;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("category", category);
        json.put("value", value);
        //json.put("stat", this);
        return json;
    }
}
