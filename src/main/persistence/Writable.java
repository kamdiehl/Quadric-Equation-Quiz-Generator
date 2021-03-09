package persistence;

import org.json.JSONObject;

// This is the interface that returns objects as a JSON object.
public interface Writable {

    // EFFECTS: Returns object as a JSON object.
    JSONObject toJson();
}
