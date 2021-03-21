package ui.graphics;

import model.QuestionMaster;
import model.QuizEntry;

import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

public class JScrollablePanelTest extends JFrame implements ActionListener {
    private JButton submitBtn;
    private JTextField field;
    private QuizEntry currentQuiz;


    public JScrollablePanelTest(int quizLength, List<QuizEntry> questionList, QuestionMaster newQuiz) {
        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        JPanel panel = createPanel(quizLength, questionList, newQuiz);
        add(BorderLayout.CENTER, new JScrollPane(panel));
        setSize(600, 400);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JPanel createPanel(int quizLength, List<QuizEntry> questionList, QuestionMaster newQuiz) {

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(quizLength, 1, 10, 10));

        for (int i = 0; i < quizLength; i++) {

            currentQuiz = newQuiz.getQuestionList().get(i);
            String currentEquation = currentQuiz.getQuestion();


            JLabel question = new JLabel(currentEquation);
            field = new JTextField();
            submitBtn = new JButton("Submit");
            submitBtn.setActionCommand("submitAnswer");
            submitBtn.addActionListener(this);
            //JLabel questionNumber = new JLabel("Q" + i);
            question.setFont(new Font("Arial", Font.PLAIN, 15));

           // questionPanel.add(questionNumber);
            questionPanel.add(question);
            questionPanel.add(field);
            questionPanel.add(submitBtn);

        }
        return questionPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submitAnswer")) {
            //
        }
    }
}