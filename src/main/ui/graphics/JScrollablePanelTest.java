package ui.graphics;

import model.QuestionMaster;
import model.QuizEntry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Structure credit a bit ?
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

// This class is in charge of the panel that holds the quiz questions and the quiz results.
public class JScrollablePanelTest extends JFrame implements ActionListener {

    private QuizEntry currentQuiz;
    private int quizLen;
    private QuestionMaster quiz;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private JPanel questionPanel;
    private JTextField field;
    private JPanel panel;

    private HashMap<Integer, JTextField> map;

    // Constructor
    public JScrollablePanelTest(int quizLength, List<QuizEntry> questionList, QuestionMaster newQuiz) {

        questionPanel = new JPanel();
        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        createPanel(quizLength, newQuiz);
        add(BorderLayout.CENTER, new JScrollPane(questionPanel));
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        quiz = newQuiz;

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

        JButton submitBtn = new JButton("Submit");      // !!!!!!!!!!!!!!!!!!!!!!
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

        String sentence1 = "Quiz score: " + correctAnswers + "/" + quiz.getQuizLength();
        String sentence2 = "              ";
        String sentence3 = "Overall score: " + overallCorrectAnswers + "/" + questionsAsked;

        String allText = sentence1 + sentence2 + sentence3;
        JLabel allT = new JLabel(allText);

        resultsPanel.add(allT);
        resultsPanel.add(saveBtn);
        resultsPanel.add(homeBtn);
        resultsPanel.setVisible(true);

        questionPanel.add(resultsPanel);

//        Object[] options = {"Save", "Home"};
//
//        String sentence1 = "Quiz score: " + correctAnswers + "/" + quiz.getQuizLength();
//        String sentence2 = "              ";
//        String sentence3 = "Overall score: " + overallCorrectAnswers + "/" + questionsAsked;
//
//        int n = JOptionPane.showOptionDialog(questionPanel, sentence1 + sentence2 + sentence3,
//                "- Quiz Results -",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[1]);


    }


    // EFFECTS: Deals with actions prompted by button clicks.
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("submitAnswers")) {

            ArrayList<String> userAnsList = createUserAnswerList(quizLen);
            ArrayList<String> ansList = createAnswerList(quizLen, quiz);

            checkUserAnswers(userAnsList, ansList);
        }
    }







}

