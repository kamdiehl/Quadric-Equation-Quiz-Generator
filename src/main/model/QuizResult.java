package model;

import org.json.JSONObject;
import persistence.Writable;

public class QuizResult {

    private int correctAnswers;
    private int incorrectAnswers;
    private int quizLength;

    private String correctAnswersName;
    private String incorrectAnswersName;
    private String questionsAskedName;

    // constructor
    public QuizResult(QuestionMaster qm) {
        this.correctAnswers = qm.getCorrectAnswers(); // It won't change from 0
        this.quizLength = qm.getQuizLength();
        this.incorrectAnswers = (qm.getQuizLength() - qm.getCorrectAnswers());
    }

    public void displayResults() {
        System.out.println(correctAnswers);
        System.out.println(incorrectAnswers);
        System.out.println(quizLength);

    }

    // EFFECTS: returns string representation of this thingy
    public String correctToString() {
        return correctAnswersName + ": " + correctAnswers;
    }

    // EFFECTS: returns string representation of this thingy
    public String incorrectToString() {
        return incorrectAnswersName + ": " + incorrectAnswers;
    }

    // EFFECTS: returns string representation of this thingy
    public String lengthToString() {
        return questionsAskedName + ": " + quizLength;
    }


//    @Override
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//
//        json.put("correctAnswers", correctAnswersName);
//        json.put("correctAnswersValue", correctAnswers);
//
//        json.put("incorrectAnswers", incorrectAnswersName);
//        json.put("incorrectAnswersValue", incorrectAnswers);
//
//        json.put("questionsAsked", questionsAskedName);
//        json.put("questionsAskedValue", quizLength);
//
//        return json;
//    }


}
