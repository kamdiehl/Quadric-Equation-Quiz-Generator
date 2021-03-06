package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// This class handles the making of the full QUIZ. It calls QuizEntry the number of times the user wants to be tested
// and makes a list of questions that will be iterated through during the quiz.
public class QuestionMaster {

    // These provide the range of what the coefficients a,b,c can exist between
    private int maxValue;
    private int minValue;
    private int correctAnswers;
    // This is the length of the quiz, and the list of questions the user will be asked.
    private int quizLength;
    private int overallCorrectAnswers;
    private ArrayList<QuizEntry> questionList;


    // JSON
    private String name;


    // Constructor
    public QuestionMaster(int ql, int maxVal, int minVal) {
        maxValue = maxVal;
        minValue = minVal;
        quizLength = ql;
        questionList = new ArrayList<>();

    }

    // MODIFIES: questionList
    // EFFECTS: Creates a list of questions (depending on the # they want) to present to the user.
    public List<QuizEntry> createNewQuestionList(int numOfQuestions) {

        quizLength = numOfQuestions;

        for (int i = 0; i < numOfQuestions; i++) {
            QuizEntry newQuestion = new QuizEntry();
            questionList.add(newQuestion);
        }
        return questionList;
    }



    // JSON


//    //@Override
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//        json.put("name", name);
//        json.put("thingies", equationsToJson());
//        return json;
//    }
//
//
//    // EFFECTS: returns things in this workroom as a JSON array
//    private JSONArray equationsToJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (QuizEntry qe : questionList) {
//            jsonArray.put(qe.toJson());
//        }
//        return jsonArray;
//    }




    // Getters & setters

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getQuizLength() {
        return quizLength;
    }

    public void setQuizLength(int newUserInput) {
        this.quizLength = newUserInput;
    }

    public List<QuizEntry> getQuestionList() {
        return questionList;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int yes) {
        this.correctAnswers = yes;
    }


    public int getOverallCorrectAnswers() {
        return overallCorrectAnswers;
    }

    public void setOverallCorrectAnswers(int correct) {
        this.overallCorrectAnswers = correct;
    }
}
