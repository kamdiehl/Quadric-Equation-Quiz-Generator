package persistence;

import model.QuestionMaster;
import model.QuizEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.QuadricApp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

// How do I properly give citations? Took this from demo
public class JsonReader {
    private String source;
    QuadricApp qa;
    QuestionMaster qm;
    QuizEntry qe;
    List<QuizEntry> questionList;


    // Constructor
    // EFFECTS: Constructs a reader to read saved source files
    public JsonReader(String source) {
        this.source = source;
    }

//
//    // EFFECTS: reads workroom from file and returns it;
//    // throws IOException if an error occurs reading data from file
//    public QuadricApp read() throws IOException {
//        String jsonData = readFile(source);
//        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseQuadricApp(jsonObject);
//
//    }
//
//    // what
//    // EFFECTS: reads source file as string and returns it
//    public String readFile(String source) throws IOException {
//        StringBuilder contentBuilder = new StringBuilder();
//        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
//            stream.forEach(s -> contentBuilder.append(s));
//        }
//        return contentBuilder.toString();
//    }
//
//
//
//    // EFFECTS: parses QuestionMaster from JSON object and returns it
//    // no. I should have this as "parse incorrect answers from Quadric app"
//    public QuadricApp parseQuadricApp(JSONObject jsonObject) {
//        String quiz = jsonObject.getString("incorrect list");
//        qa = new QuadricApp();
//        addEquations(qa, jsonObject);
//        return qa;
//
//    }
//
//
//
//    // MODIFIES: qm
//    // EFFECTS: parses equation list from JSON object and adds them to QuestionMaster.
//    private void addEquations(QuadricApp qa, JSONObject jsonObject) {
//        JSONArray jsonArray = jsonObject.getJSONArray("incorrect list");
//        for (Object json : jsonArray) {
//            JSONObject nextEq = (JSONObject) json;
//            addEquation(qa, nextEq);
//        }
//    }
//
//
//
//    // MODIFIES: qm
//    // EFFECTS: parses equation (quizEntry) from JSON object and adds it to QuestionMaster.
//    private void addEquation(QuadricApp qa, JSONObject jsonObject) {
//        String equation = jsonObject.getString("incorrect");
//        qa.addIncorrectEq(equation);
//
//        //int numOfQuestions = qa.getUserInput2();
//        //questionList = qm.createNewQuestionList(numOfQuestions);
//       // questionList.add(qe);
//
//    }

}
