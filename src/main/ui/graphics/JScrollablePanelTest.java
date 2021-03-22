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

public class JScrollablePanelTest extends JFrame implements ActionListener {

    private QuizEntry currentQuiz;
    private int quizLen;
    private QuestionMaster quiz;
    private int overallCorrectAnswers;
    private int correctAnswers;
    private int questionsAsked;
    private JPanel questionPanel;
    private JTextField field;

    private HashMap<Integer, JTextField> map;

    // Constructor
    public JScrollablePanelTest(int quizLength, List<QuizEntry> questionList, QuestionMaster newQuiz) {
        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        JPanel panel = createPanel(quizLength, newQuiz);
        JButton submitBtn = new JButton("Submit");
        panel.add(submitBtn);
        submitBtn.addActionListener(this);
        submitBtn.setActionCommand("submitAnswers");

        add(BorderLayout.CENTER, new JScrollPane(panel));
        setSize(600, 400);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        quiz = newQuiz;

    }

    public JPanel createPanel(int quizLength, QuestionMaster newQuiz) {

        questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(quizLength, 1, 10, 10));
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
        boolean isRight = true;

        for (int i = 0; i < quizLen; i++) {
            String user = userAnswers.get(i);
            String ans = answers.get(i);

            if (user.equals(ans)) {
                System.out.println("Correct!");
                isRight = true;
                correctAnswers++;
                overallCorrectAnswers++;

            } else {
                isRight = false;
                System.out.println("Incorrect!");
            }

            for (int j = 0; j < quizLen; j++) {
                JTextField filledField = map.get(j);
                if (isRight) {
                    filledField.setForeground(Color.green);
                }
                if (!isRight) {
                    filledField.setForeground(Color.red);
                }
            }
        }
        postQuiz();
    }


    // EFFECTS: Displays quiz score to user and loops back to the start.
    public void postQuiz() {
        overallCorrectAnswers += quiz.getCorrectAnswers();
        questionsAsked += quiz.getQuizLength();

        Object[] options = {"Save", "Home"};

        String sentence1 = "Quiz score: " + correctAnswers + "/" + quiz.getQuizLength();
        String sentence2 = "              ";
        String sentence3 = "Overall score: " + overallCorrectAnswers + "/" + questionsAsked;

        int n = JOptionPane.showOptionDialog(questionPanel, sentence1 + sentence2 + sentence3,
                "- Quiz Results -",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

    }





    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("submitAnswers")) {

            ArrayList<String> userAnsList = createUserAnswerList(quizLen);
            ArrayList<String> ansList = createAnswerList(quizLen, quiz);

            checkUserAnswers(userAnsList, ansList);
        }
    }



    // EFFECTS: Compares the user's answer to the correct answer for that question, returns true if correct.
    public boolean checkAnswer(String userAnswer, String answer) {
        return userAnswer.equals(answer);
    }



}

