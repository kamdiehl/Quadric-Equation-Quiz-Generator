package ui.graphics;

import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// https://www.tutorialspoint.com/how-can-we-implement-a-scrollable-jpanel-in-java

public class JScrollablePanelTest extends JFrame implements ActionListener {
    private JButton submitBtn;
    private JTextField field;


    public JScrollablePanelTest(int quizLength) {
        setTitle("Quiz Panel");
        setLayout(new BorderLayout());
        JPanel panel = createPanel(quizLength);
        add(BorderLayout.CENTER, new JScrollPane(panel));
        setSize(375, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JPanel createPanel(int quizLength) {

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(quizLength, 1, 10, 10));

        for (int i = 0; i < quizLength; i++) {
          //  for (int j = 0; j < 1; j++) {

            JLabel label = new JLabel("label " + i);
            field = new JTextField();
            submitBtn = new JButton("Submit");
            submitBtn.setActionCommand("submitAnswer");
            submitBtn.addActionListener(this);
            JLabel emptySpace = new JLabel(" ");
            label.setFont(new Font("Arial", Font.PLAIN, 20));

            questionPanel.add(label);
            questionPanel.add(field);
            questionPanel.add(submitBtn);
            questionPanel.add(emptySpace);

          //  }
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