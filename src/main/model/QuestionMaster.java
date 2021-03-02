package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class handles the making of the full QUIZ. It calls QuizEntry the number of times the user wants to be tested
// and makes a list of questions that will be iterated through during the quiz.
public class QuestionMaster {

    // These provide the range of what the coefficients a,b,c can exist between
    private int maxValue;
    private int minValue;
    // This is the length of the quiz, and the list of questions the user will be asked.
    private int quizLength;
    private int correctAnswers;
    private ArrayList<QuizEntry> questionList;


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


    // Getters

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getQuizLength() {
        return quizLength;
    }

    public List<QuizEntry> getQuestionList() {
        return questionList;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }
}
