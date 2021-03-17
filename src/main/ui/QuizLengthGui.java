package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Scanner;

// This gets called when the user presses the "START" button and handles the user input for the quiz length.
public class QuizLengthGui extends JFrame {
    private JFrame quizLengthFrame;
    private Scanner input;
    private JTextField field;

    public static final int TITLE_FONT = 27;
    public static final String TITLE_TEXT = "Enter the # of quiz questions you want generated";
    public static final Color TITLE_COLOR = new Color(1, 108, 104);

    public QuizLengthGui() {
        quizLengthFrame = new JFrame("ChooseQuizLength");
        quizLengthFrame.setVisible(true);

        quizLengthFrame.setLayout(new GridBagLayout());
        quizLengthFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel(new GridLayout(4, 4, 1, 1));

        initializeGraphics(quizLengthFrame);
        initializeTitle(topPanel, quizLengthFrame);

        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));

        // WHY IS THIS NOT DOING THE THING
        field = new JTextField(5);
        quizLengthFrame.add(field);

    }



    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this quadric app will operate
    public void initializeGraphics(JFrame quizLengthFrame) {
        quizLengthFrame.setLayout(new BorderLayout());
        quizLengthFrame.setSize(1000,700);

        quizLengthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizLengthFrame.setLocationRelativeTo(null);
        quizLengthFrame.setVisible(true);

        // background colours
        quizLengthFrame.setBackground(Color.white);
        //quizLengthFrame.setForeground(Color.blue);
    }



    // EFFECTS: Initializes the title text that displays title name on title page.
    private void initializeTitle(JPanel topPanel, JFrame thisFrame) {
        JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
        titleLabel.setForeground(TITLE_COLOR);
        JPanel lengthPanel = new JPanel();
        lengthPanel.add(titleLabel);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(lengthPanel);
        thisFrame.add(topPanel, BorderLayout.NORTH);
    }




}
