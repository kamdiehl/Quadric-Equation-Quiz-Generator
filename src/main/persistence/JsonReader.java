package persistence;

import model.QuestionMaster;
import model.QuizEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

// How do I properly give citations?
public class JsonReader {
    private String source;


    // Constructor
    // EFFECTS: Constructs a reader to read saved source files
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public QuestionMaster read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseQuestionMaster(jsonObject);

    }


    // EFFECTS: reads source file as string and returns it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }



    // EFFECTS: parses QuestionMaster from JSON object and returns it
    public QuestionMaster parseQuestionMaster(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        QuestionMaster qm = new QuestionMaster(10,10,1);  //change
        addEquations(qm, jsonObject);
        return qm;

    }



    // MODIFIES: qm
    // EFFECTS: parses equation list from JSON object and adds them to QuestionMaster.
    private void addEquations(QuestionMaster qm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("thingies");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addEquation(qm, nextThingy);
        }
    }



    // MODIFIES: qm
    // EFFECTS: parses equation (quizEntry) from JSON object and adds it to QuestionMaster.
    private void addEquation(QuestionMaster qm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        QuizEntry quizEntry = new QuizEntry();
        int numOfQuestions = qm.getQuizLength();
        List<QuizEntry> questionList = qm.createNewQuestionList(numOfQuestions);
        questionList.add(quizEntry);

    }

}
