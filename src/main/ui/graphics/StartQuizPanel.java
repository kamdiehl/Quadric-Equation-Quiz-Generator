package ui.graphics;

import model.QuestionMaster;
import model.QuizEntry;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.Main;

import javax.swing.*;
import java.awt.*;

public class StartQuizPanel {

   // QuestionMaster newQuiz;
    QuizEntry currentQuiz;

    // json
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // constructor
    // REQUIRES: userQuizLength input > 0 from QuizLengthPopUp class.
    // EFFECTS: Initiates quiz with the required number of questions.
    public StartQuizPanel(QuestionMaster newQuiz) {

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }





}
