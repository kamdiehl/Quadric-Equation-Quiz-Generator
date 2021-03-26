package ui.graphics;

import model.QuestionMaster;
import model.StatsManager;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

// This class is in charge of initializing the main JFrame that holds the quiz and the menu buttons.
public class MainFrame extends JFrame implements ActionListener {

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 900;
    private static final int TITLE_FONT = 22;
    private static final Color TITLE_COLOR = new Color(1, 108, 104);
    private static final Color TITLE_BACKGROUND = new Color(2, 239, 231);

    private static final Color startBtnColor = new Color(0, 198, 183);
    private static final Color instructionBtnColor = new Color(5, 170, 157);
    private static final Color saveBtnColor = new Color(8, 137, 127);
    private static final Color loadBtnColor = new Color(4, 118, 109);
    private static final Color exitBtnColor = new Color(2, 92, 94);

    JButton startBtn = new JButton("START");
    JButton instructionBtn = new JButton("HOW TO PLAY");
    JButton loadBtn = new JButton("LOAD DATA");
    JButton exitBtn = new JButton("EXIT");
    JButton viewResultsBtn = new JButton("VIEW RESULTS");

    private GridBagConstraints gbc;
    private static final int IMAGE_WIDTH = 450;
    private static final int IMAGE_HEIGHT = 470;

    private StatsManager statsManager;
    private JFrame mainWindow;
    private JFrame popUp;
    private int userInputNum;

    // json
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/workroom.json";


    // constructor
    // EFFECTS: Constructs the main JFrame containing all of the panels for the program.
    public MainFrame() {
        mainWindow = new JFrame("Quadric Quiz");
        statsManager = new StatsManager("statHistory");
        mainWindow.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createWindow(mainWindow);
        createTitlePanel(mainWindow);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        initializeTitleImage(eastPanel);

        mainWindow.getContentPane().setBackground(new Color(154, 205, 185));

        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

    }


    // EFFECTS: Creates a new window (JFrame)
    public static void createWindow(JFrame newWindow) {

        newWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newWindow.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        newWindow.pack();
        newWindow.setLocationRelativeTo(null);
        newWindow.setVisible(true);
        newWindow.setResizable(false);
        newWindow.setBackground(Color.cyan);

    }


    // EFFECTS: Creates title panel with title label.
    public void createTitlePanel(JFrame mainWindow) {

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("QUADRIC EQUATION QUIZ",SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
        titleLabel.setForeground(TITLE_COLOR);
        titleLabel.setPreferredSize(new Dimension(300, 100));
        titlePanel.add(titleLabel);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        titlePanel.setBackground(TITLE_BACKGROUND);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 5));
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST;

        initiateButtons();

        buttonPanel.add(titlePanel, gbc);
        buttonPanel.add(startBtn);
        buttonPanel.add(instructionBtn);
        buttonPanel.add(viewResultsBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(exitBtn);

        mainWindow.add(buttonPanel, gbc);

    }



    // EFFECTS: Creates the buttons and adds their background colors.
    public void initiateButtons() {

        buttonColors();
        startBtn.setActionCommand("startButton");
        startBtn.addActionListener(this);
        instructionBtn.setActionCommand("instructionButton");
        instructionBtn.addActionListener(this);
        loadBtn.setActionCommand("loadButton");
        loadBtn.addActionListener(this);
        exitBtn.setActionCommand("exitButton");
        exitBtn.addActionListener(this);
        viewResultsBtn.setActionCommand("viewResults");
        viewResultsBtn.addActionListener(this);

    }



    // EFFECTS: Initiates button colors.
    public void buttonColors() {

        startBtn.setBackground(startBtnColor);
        startBtn.setForeground(exitBtnColor);
        startBtn.setOpaque(true);
        instructionBtn.setBackground(instructionBtnColor);
        instructionBtn.setForeground(loadBtnColor);
        instructionBtn.setOpaque(true);
        viewResultsBtn.setBackground(saveBtnColor);
        viewResultsBtn.setForeground(loadBtnColor);
        viewResultsBtn.setOpaque(true);
        loadBtn.setBackground(loadBtnColor);
        loadBtn.setForeground(instructionBtnColor);
        loadBtn.setOpaque(true);
        exitBtn.setBackground(exitBtnColor);
        exitBtn.setForeground(startBtnColor);
        exitBtn.setOpaque(true);

    }



    // EFFECTS: Method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("startButton")) {
            quizLengthPopUp(mainWindow, statsManager);
        }

        if (e.getActionCommand().equals("instructionButton")) {
            new InstructionPopUp();
        }

        if (e.getActionCommand().equals("viewResults")) {
            new ViewStats(statsManager, jsonWriter);
        }

        if (e.getActionCommand().equals("loadButton")) {
            new LoadStats(statsManager, jsonReader);

        }
        if (e.getActionCommand().equals("exitButton")) {
            System.exit(0);
        }
    }


    // MODIFIES: This
    // EFFECTS: Initializes the image that appears on the title page.
    private void initializeTitleImage(JPanel eastPanel) {
        ImageIcon unscaledTitleIcon = createImageIcon("/images/hyp1sh.jpg", "title picture"); // create the icon
        Image titleImage = unscaledTitleIcon.getImage(); // convert it into an image
        Image finalTitleImage = titleImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
        unscaledTitleIcon = new ImageIcon(finalTitleImage); // convert it back to an image icon
       // JLabel label = new JLabel("Image and Text", unscaledTitleIcon, JLabel.CENTER);
        JLabel titlePageLabel = new JLabel(unscaledTitleIcon);
        eastPanel.add(titlePageLabel, BorderLayout.EAST);
        eastPanel.setVisible(true);
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




    // RIP QuizLengthPopUp Class

    // EFFECTS: Instantiates new quiz and
    public void quizLengthPopUp(JFrame mainFrame, StatsManager statsManager) {
        initiatePopUp();
        String userInputString = JOptionPane.showInputDialog(popUp,
                "Enter the number of questions you want in your quiz");
        userInputNum = Integer.parseInt(userInputString);
        setUserInputNum(userInputNum);

        // HERE IS WHERE WE INSTANTIATE THE NEW QUIZ
        QuestionMaster newQuiz = new QuestionMaster(userInputNum, 10, 1);
        newQuiz.setQuizLength(userInputNum);
        newQuiz.createNewQuestionList(userInputNum);

        new JScrollablePanelTest(userInputNum, newQuiz, mainFrame, statsManager);
    }

    public void initiatePopUp() {
        popUp = new JFrame();
        popUp.setForeground(Color.pink);
    }







    // GETTERS AND SETTERS ----------------------------------------------------------------------------------

    public void setUserInputNum(int userInputNum) {
        this.userInputNum = userInputNum;
    }


}
