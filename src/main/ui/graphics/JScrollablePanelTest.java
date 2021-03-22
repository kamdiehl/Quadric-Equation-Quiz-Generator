package ui.graphics;

import model.QuestionMaster;
import model.QuizEntry;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

public class JScrollablePanelTest extends JFrame implements ActionListener {
    private JButton submitBtn;
    private JTextField field;
    private QuizEntry currentQuiz;
    private String currentEquation;
    private String currentAnswer;
    private int quizLen;
    private QuestionMaster quiz;



    HashMap<Integer, JTextField> map;


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

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(quizLength, 1, 10, 10));
        quizLen = quizLength;
        map = new HashMap<>();

        for (int i = 0; i < quizLength; i++) {

            currentQuiz = newQuiz.getQuestionList().get(i);
            currentEquation = currentQuiz.getQuestion();
            JLabel question = new JLabel(currentEquation);
            field = new JTextField();
            map.put(i, field);

            question.setFont(new Font("Arial", Font.PLAIN, 15));

            questionPanel.add(question);
            questionPanel.add(field);
            //questionPanel.add(submitBtn);
        }


       // submitBtn = new JButton("Submit");
       // questionPanel.add(submitBtn);
        return questionPanel;
    }


    public ArrayList<String> createAnswerList(int quizLength, QuestionMaster newQuiz) {
        ArrayList<String> answerList = new ArrayList<>();
        
        for (int i = 0; i < quizLength; i++) {
            currentQuiz = newQuiz.getQuestionList().get(i);
            currentAnswer = currentQuiz.getAnswer();
            answerList.add(currentAnswer);
        }
        return answerList;
    }


    public ArrayList<String> createUserAnswerList(int quizLength) {
        ArrayList<String> userAnswerList = new ArrayList<>();

        for (int i = 0; i < quizLength; i++) {
            JTextField filledField = map.get(i);
            String userAnswer = filledField.getText();
            userAnswerList.add(userAnswer);
        }
        //System.out.println(userAnswerList);
        return userAnswerList;
    }


    //
    public void checkUserAnswers(ArrayList<String> userAnswers, ArrayList<String> answers) {

        for (int i = 0; i < quizLen; i++) {
            String user = userAnswers.get(i);
            String ans = answers.get(i);

            if (user.equals(ans)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
        }
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


    public void setQuizLen(int quizLen) {
        this.quizLen = quizLen;
    }
}

