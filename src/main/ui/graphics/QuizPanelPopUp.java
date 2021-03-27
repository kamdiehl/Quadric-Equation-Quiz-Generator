package ui.graphics;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

// Structure credit a bit ?
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

// This class is in charge of the panel that holds the quiz questions and the quiz results.
public class QuizPanelPopUp extends JFrame implements ActionListener {

    private QuestionMaster quiz;
    private StatsManager statsManagerQ;
    private QuizEntry currentQuiz;

    private int quizLen;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private JPanel questionPanel;
    private JScrollPane quizScroll;

    private HashMap<Integer, JTextField> map;


    // Constructor
    // EFFECTS: constructs the scrollable window that holds all the questions.
    public QuizPanelPopUp(int quizLength, QuestionMaster newQuiz, JFrame mainFrame, StatsManager statsManager) {

        questionPanel = new JPanel();
        quizScroll = new JScrollPane(questionPanel);
        this.statsManagerQ = statsManager;
        this.quiz = newQuiz;

// ------- trying to anchor the panel to the JFrame but no luck so far
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainFrame.add(quizScroll, gbc);
// --------

        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        createPanel(quizLength, newQuiz);
        add(BorderLayout.CENTER, quizScroll);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    // EFFECTS: Creates the quizPanel and uses HashMap to associate the textField to a number.
    public JPanel createPanel(int quizLength, QuestionMaster newQuiz) {

        questionPanel.setLayout(new GridLayout(0, 1, 10, 10));
        quizLen = quizLength;
        map = new HashMap<>();

        for (int i = 0; i < quizLength; i++) {

            currentQuiz = newQuiz.getQuestionList().get(i);
            String currentEquation = currentQuiz.getQuestion();
            JLabel question = new JLabel(currentEquation);
            JTextField field = new JTextField();
            map.put(i, field);
            question.setFont(new Font("Arial", Font.PLAIN, 15));

            questionPanel.add(question);
            questionPanel.add(field);

        }

        JButton submitBtn = new JButton("Submit");
        questionPanel.add(submitBtn, BorderLayout.SOUTH);
        submitBtn.addActionListener(this);
        submitBtn.setActionCommand("submitAnswers");

        return questionPanel;
    }



    // EFFECTS: Creates a list of answers from the question list for the current quiz.
    public ArrayList<String> createAnswerList(int quizLength, QuestionMaster newQuiz) {

        ArrayList<String> answerList = new ArrayList<>();
        
        for (int i = 0; i < quizLength; i++) {
            currentQuiz = newQuiz.getQuestionList().get(i);
            String currentAnswer = currentQuiz.getAnswer();
            answerList.add(currentAnswer);
        }
        return answerList;
    }



    // EFFECTS: Scans all the text boxes to make a list of the user's inputted answers.
    public ArrayList<String> createUserAnswerList(int quizLength) {
        ArrayList<String> userAnswerList = new ArrayList<>();

        for (int i = 0; i < quizLength; i++) {
            JTextField filledField = map.get(i);
            String userAnswer = filledField.getText();
            userAnswerList.add(userAnswer);
        }

        return userAnswerList;
    }



    // EFFECTS: Compares the userAnswer's list to the actual answer list
    public void checkUserAnswers(ArrayList<String> userAnswers, ArrayList<String> answers) {
        correctAnswers = 0;
        Color correctText = new Color(73, 134, 14);
        Color correctField = new Color(232, 255, 192);
        Color incorrectText = new Color(186, 23, 23);
        Color incorrectField = new Color(255, 202, 202);

        for (int i = 0; i < quizLen; i++) {
            JTextField filledField = map.get(i);
            String user = userAnswers.get(i);
            String ans = answers.get(i);

            if (user.equals(ans)) {
                filledField.setForeground(correctText);
                filledField.setBackground(correctField);
                correctAnswers++;
                overallCorrectAnswers++;

            } else {
                filledField.setForeground(incorrectText);
                filledField.setBackground(incorrectField);
            }
        }
        postQuiz();
    }



    // EFFECTS: Displays quiz score to user and loops back to the start.
    public void postQuiz() {
        overallCorrectAnswers += quiz.getCorrectAnswers();
        questionsAsked += quiz.getQuizLength();

        JPanel resultsPanel = new JPanel();

        JButton homeBtn = new JButton("Home");
        homeBtn.setActionCommand("homeButton");
        homeBtn.addActionListener(this);

        String sentence1 = "Quiz score: " + correctAnswers + "/" + quiz.getQuizLength();
        String sentence2 = "              ";
        String sentence3 = "Overall score: " + overallCorrectAnswers + "/" + questionsAsked;

        String allStrings = sentence1 + sentence2 + sentence3;
        JLabel resultString = new JLabel(allStrings);

        resultsPanel.add(resultString);
        resultsPanel.add(homeBtn);
        resultsPanel.setVisible(true);

        questionPanel.add(resultsPanel);

    }


    // EFFECTS: Deals with actions prompted by button clicks.
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("submitAnswers")) {
            ArrayList<String> userAnsList = createUserAnswerList(quizLen);
            ArrayList<String> ansList = createAnswerList(quizLen, quiz);
            checkUserAnswers(userAnsList, ansList);
        }

        if (e.getActionCommand().equals("homeButton")) {
            addQuizResults();
            SwingUtilities.windowForComponent(this.quizScroll).dispose();

        }
    }


// JSON  -----------------------------------------------------------------------------------------

    //EFFECTS: Turns the number of correct answers from quiz into a StatValue.
    public StatValue readCorrectAnswers() {
        StatValue correctStat;

        int correct = correctAnswers;
        StatCategory category = StatCategory.values()[0];
        correctStat = new StatValue(category, correct);
        return correctStat;

    }

    //EFFECTS: Turns the number of incorrect answers from quiz into a StatValue.
    public StatValue readIncorrectAnswers() {
        StatValue incorrectStat;

        int correct = correctAnswers;
        int length = quiz.getQuizLength();
        int incorrect = length - correct;
        StatCategory category = StatCategory.values()[1];
        incorrectStat = new StatValue(category, incorrect);
        return incorrectStat;

    }

    //EFFECTS: Turns the quiz length into a StatValue.
    public StatValue readQuizLength() {
        StatValue lengthStat;
        int length = quiz.getQuizLength();
        StatCategory category = StatCategory.values()[2];
        lengthStat = new StatValue(category, length);
        return lengthStat;
    }


    // MODIFIES: this
    // EFFECTS: prompt user for name and category of thingy and adds to workroom
    private void addQuizResults() {

        StatValue correct = readCorrectAnswers();
        StatValue incorrect = readIncorrectAnswers();
        StatValue length = readQuizLength();

        statsManagerQ.addStat(correct);
        statsManagerQ.addStat(incorrect);
        statsManagerQ.addStat(length);
    }



    // getters --------------------------------------------------------------------------

    public StatsManager getStatsManager() {
        return statsManagerQ;
    }




}

