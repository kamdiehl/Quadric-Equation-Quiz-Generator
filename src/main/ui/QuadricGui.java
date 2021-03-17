package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class QuadricGui extends JframeMaker implements ActionListener {
  //  private JFrame numOfQuestionsFrame;

    private JLabel label;
    private ImageIcon unscaledTitleIcon;
    private JLabel titlePageLabel;
    private Scanner input;
    private QuizLengthGui quizLengthFrame;

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    public static final int IMAGE_WIDTH = 450;
    public static final int IMAGE_HEIGHT = 470;
    public static final int TITLE_FONT = 27;
    public static final String TITLE_TEXT = "QUADRIC EQUATION QUIZ";

    public static final Color TITLE_COLOR = new Color(1, 108, 104);
    public static final Color startBtnColor = new Color(0, 198, 183);
    public static final Color instructionBtnColor = new Color(5, 170, 157);
    public static final Color loadBtnColor = new Color(4, 118, 109);
    public static final Color exitBtnColor = new Color(2, 92, 94);

    JButton startBtn = new JButton("START");
    JButton instructionBtn = new JButton("HOW TO PLAY");
    JButton loadBtn = new JButton("LOAD DATA");
    JButton exitBtn = new JButton("EXIT");

    JFrame startWindow;



    // Constructor
    // EFFECTS: Initializes everything needed for quiz
    public QuadricGui() {

        setLayout(new GridBagLayout());
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel(new GridLayout(4, 4, 1, 1));

        startWindow = newViewWindow(TITLE_TEXT);

        //initializeGraphics();
        initializeTitleButtons(bottomPanel);
        initializeTitleImage(topPanel);
        //initializeTitle(topPanel, startWindow, "QUADRIC EQUATION QUIZ");

        // from project guide
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
       // ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        runQuadricApp();

    }

    // EFFECTS: Runs the app
    public void runQuadricApp() {

        startBtn.setActionCommand("startButton");
        startBtn.addActionListener(this);
        instructionBtn.setActionCommand("instructionButton");
        instructionBtn.addActionListener(this);
        loadBtn.setActionCommand("loadButton");
        loadBtn.addActionListener(this);
        exitBtn.setActionCommand("exitButton");
        exitBtn.addActionListener(this);

        input = new Scanner(System.in);


    }

    // EFFECTS: Method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("startButton")) {
            dispose();
            new QuizLengthGui();


        }
        if (e.getActionCommand().equals("instructionButton")) {
            // label.setText(field.getText());
        }
        if (e.getActionCommand().equals("loadButton")) {
            // label.setText(field.getText());
        }
        if (e.getActionCommand().equals("exitButton")) {
            // label.setText(field.getText());
        }

    }


//    // MODIFIES: this
//    // EFFECTS:  draws the JFrame window where this quadric app will operate
//    public void initializeGraphics() {
//        setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(WIDTH, HEIGHT));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//
//        // background colours
//        setBackground(Color.cyan);
//        setForeground(Color.blue);
//    }


//    // MODIFIES: this
//    // EFFECTS:  initializes the title page that starts the quiz
//    public void initializeTitlePage(JPanel topPanel, JPanel bottomPanel) {
//        initializeTitleButtons(bottomPanel);
//        initializeTitle(topPanel);
//        initializeTitleImage(topPanel);
//    }











    // PRIVATE METHODS ---------------------------------------------------------------------------------------


    // Title Page and Menu Option Methods:

    // EFFECTS: Initializes the menu options on the title page
    private void initializeTitleButtons(JPanel bottomPanel) {

        bottomPanel.add(startBtn);
        bottomPanel.add(instructionBtn);
        bottomPanel.add(loadBtn);
        bottomPanel.add(exitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // background button colours
        startBtn.setBackground(startBtnColor);
        startBtn.setForeground(exitBtnColor);
        startBtn.setOpaque(true);
        instructionBtn.setBackground(instructionBtnColor);
        instructionBtn.setForeground(loadBtnColor);
        instructionBtn.setOpaque(true);
        loadBtn.setBackground(loadBtnColor);
        loadBtn.setForeground(instructionBtnColor);
        loadBtn.setOpaque(true);
        exitBtn.setBackground(exitBtnColor);
        exitBtn.setForeground(startBtnColor);
        exitBtn.setOpaque(true);
    }


//    // EFFECTS: Initializes the title text that displays title name on title page.
//    private void initializeTitle(JPanel topPanel) {
//        JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
//        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
//        titleLabel.setForeground(TITLE_COLOR);
//        JPanel titlePanel = new JPanel();
//        titlePanel.add(titleLabel);
//        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
//        topPanel.add(titlePanel);
//        add(topPanel, BorderLayout.NORTH);
//    }


    // MODIFIES: This
    // EFFECTS: Initializes the image that appears on the title page.
    private void initializeTitleImage(JPanel topPanel) {
        unscaledTitleIcon = createImageIcon("/images/hyp1sh.jpg", "title picture"); // create the icon
        Image titleImage = unscaledTitleIcon.getImage(); // convert it into an image
        Image finalTitleImage = titleImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
        unscaledTitleIcon = new ImageIcon(finalTitleImage); // convert it back to an image icon
        label = new JLabel("Image and Text", unscaledTitleIcon, JLabel.CENTER);
        titlePageLabel = new JLabel(unscaledTitleIcon);
        topPanel.add(titlePageLabel);
    }


    // EFFECTS: Creates the title image icon
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }



    // GETTERS AND SETTERS ----------------------------------------------------------------------------------



}
