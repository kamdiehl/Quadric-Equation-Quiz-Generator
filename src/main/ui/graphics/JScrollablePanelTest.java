package ui.graphics;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Structure credit a bit ?
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

// This class is in charge of the panel that holds the quiz questions and the quiz results.
public class JScrollablePanelTest extends JFrame implements ActionListener {

    StatsManager statsManager = new StatsManager("statHistory");

    private QuizEntry currentQuiz;
    private int quizLen;
    private QuestionMaster quiz;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private JPanel questionPanel;
    private JTextField field;
    private JScrollPane quizScroll;


    private HashMap<Integer, JTextField> map;

    // json
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private LoadQuizPanel loadedQuiz;
    private MainFrame mainFrame;

    // Constructor
    public JScrollablePanelTest(int quizLength, List<QuizEntry> questionList, QuestionMaster newQuiz) {

        questionPanel = new JPanel();
        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        createPanel(quizLength, newQuiz);
        quizScroll = new JScrollPane(questionPanel);

//        GridBagConstraints gbc = new GridBagConstraints();
//        mainFrame = new MainFrame();
//        JFrame frame = mainFrame.getMainWindow();
//        gbc.anchor = GridBagConstraints.SOUTHEAST;
//        frame.add(questionPanel, gbc);



        add(BorderLayout.CENTER, quizScroll);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        quiz = newQuiz;

        // x=parentComponent.width-w; y=0; w=100; h=100;

        jsonWriter = new JsonWriter(JSON_STORE);
       // jsonReader = new JsonReader(JSON_STORE);

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
            field = new JTextField();
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
               // System.out.println("Correct!");
                filledField.setForeground(correctText);
                filledField.setBackground(correctField);
                correctAnswers++;
                overallCorrectAnswers++;

            } else {
                filledField.setForeground(incorrectText);
                filledField.setBackground(incorrectField);
               // System.out.println("Incorrect!");
            }
        }
        postQuiz();
    }



    // EFFECTS: Displays quiz score to user and loops back to the start.
    public void postQuiz() {
        overallCorrectAnswers += quiz.getCorrectAnswers();
        questionsAsked += quiz.getQuizLength();

        JPanel resultsPanel = new JPanel();
        JButton saveBtn = new JButton("Save");
        JButton homeBtn = new JButton("Home");
        JButton loadBtn = new JButton("Load");

        saveBtn.setActionCommand("saveButton");
        saveBtn.addActionListener(this);
        homeBtn.setActionCommand("homeButton");
        homeBtn.addActionListener(this);
        loadBtn.setActionCommand("loadButton");
        loadBtn.addActionListener(this);

        String sentence1 = "Quiz score: " + correctAnswers + "/" + quiz.getQuizLength();
        String sentence2 = "              ";
        String sentence3 = "Overall score: " + overallCorrectAnswers + "/" + questionsAsked;

        String allText = sentence1 + sentence2 + sentence3;
        JLabel allT = new JLabel(allText);

        resultsPanel.add(allT);
        resultsPanel.add(saveBtn);
        resultsPanel.add(loadBtn);
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

        if (e.getActionCommand().equals("saveButton")) {
            addQuizResults();
            saveQuiz();
        }

        if (e.getActionCommand().equals("loadButton")) {
            loadedQuiz = new LoadQuizPanel(statsManager);

            //loadStats();
            //printStats();

        }

        if (e.getActionCommand().equals("homeButton")) {
            quizScroll.setVisible(false); // MAY CAUSE ISSUES !!!!
            questionPanel.setVisible(false);
        }
    }


// JSON ++++++++++++++++++++++

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

        statsManager.addStat(correct);
        statsManager.addStat(incorrect);
        statsManager.addStat(length);
    }

//
//    // EFFECTS: prints all the thingies in workroom to the console
//    private void printStats() {
//        List<StatValue> thingies = statsManager.getAllStats();
//        int counter = 1;
//        System.out.println("Quiz 1");
//        for (StatValue t: thingies) {
//            System.out.println(t);
//            int indexNum = thingies.lastIndexOf(t); // if statement below is temporary
//          if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
//                System.out.println(" ");
//                counter++;
//                System.out.println("Quiz " + counter);
//
//            }
//        }
//    }


    // EFFECTS: saves the workroom to file
    private void saveQuiz() {
        try {
            jsonWriter.open();
            jsonWriter.write(statsManager);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

//    // MODIFIES: this
//    // EFFECTS: loads workroom from file
//    private void loadStats() {
//        try {
//            statsManager = jsonReader.read();
//            System.out.println("Loaded " + statsManager.getStatHistory() + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + statsManager.getStatHistory() + JSON_STORE);
//        }
//    }








}

