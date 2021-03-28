package ui.graphics;

import model.QuestionMaster;
import model.StatsManager;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// This class is in charge of initializing the main JFrame that holds the quiz and the menu buttons.
public class MainFrame extends JFrame implements ActionListener {

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 900;
    private static final Color TITLE_COLOR = new Color(2, 250, 171);
    private static final Color TITLE_BACKGROUND = new Color(0, 0, 0);

    private static final Color startBtnColor = new Color(33, 189, 140);
    private static final Color instructionBtnColor = new Color(33, 189, 140);
    private static final Color saveBtnColor = new Color(33, 189, 140);
    private static final Color loadBtnColor = new Color(33, 189, 140);
    private static final Color exitBtnColor = new Color(33, 189, 140);

    JButton startBtn = new JButton();
    JButton instructionBtn = new JButton();
    JButton loadBtn = new JButton();
    JButton exitBtn = new JButton();
    JButton viewResultsBtn = new JButton();

    private GridBagConstraints gbc;
    private static final int IMAGE_WIDTH = 750;
    private static final int IMAGE_HEIGHT = 658;

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

        initializeTitleImage();

        mainWindow.getContentPane().setBackground(new Color(0, 0, 0));

        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);


        initializeBtnIcons();
    }


    // EFFECTS: Creates a new window (JFrame)
    public static void createWindow(JFrame newWindow) {

        newWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newWindow.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        newWindow.pack();
        newWindow.setLocationRelativeTo(null);
        newWindow.setVisible(true);
        newWindow.setResizable(false);
        newWindow.setBackground(new Color(116, 0, 142));

    }


    // EFFECTS: Creates title panel with title label.
    public void createTitlePanel(JFrame mainWindow) {

        JPanel titlePanel = new JPanel();
        int sw = SwingConstants.CENTER;
        //JLabel titleLabel = new JLabel("<html>QUADRIC<br/>EQUATION<br/>QUIZ</html>", sw);
        JLabel titleLabel = new JLabel("SELECT ONE:", sw);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        titleLabel.setForeground(TITLE_COLOR);
        titleLabel.setPreferredSize(new Dimension(300, 100));
        titlePanel.add(titleLabel);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        titlePanel.setBackground(TITLE_BACKGROUND);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 0, 0));
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
        startBtn.setOpaque(true);

        instructionBtn.setBackground(instructionBtnColor);
       // instructionBtn.setForeground(loadBtnColor);
        instructionBtn.setOpaque(true);
        //instructionBtn.setFont(new Font("Arial", Font.BOLD, 35));

        viewResultsBtn.setBackground(saveBtnColor);
        //viewResultsBtn.setForeground(loadBtnColor);
        viewResultsBtn.setOpaque(true);
        //viewResultsBtn.setFont(new Font("Arial", Font.BOLD, 35));

        loadBtn.setBackground(loadBtnColor);
        //loadBtn.setForeground(instructionBtnColor);
        loadBtn.setOpaque(true);
        //loadBtn.setFont(new Font("Arial", Font.BOLD, 35));

        exitBtn.setBackground(exitBtnColor);
        //exitBtn.setForeground(startBtnColor);
        exitBtn.setOpaque(true);
        //exitBtn.setFont(new Font("Arial", Font.BOLD, 35));

    }



    // EFFECTS: Method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        String btnSound = "/Users/kamryndiehl/IdeaProjects/CPSC210/Lab/project_n5y2b/src/main/sounds/btnSound.wav";

        if (e.getActionCommand().equals("startButton")) {
            //initializeStartBtnImage();
            playBtnSound(btnSound);
            quizLengthPopUp(mainWindow, statsManager);
        }

        if (e.getActionCommand().equals("instructionButton")) {
            playBtnSound(btnSound);
            new InstructionPopUp();
        }

        if (e.getActionCommand().equals("viewResults")) {
            playBtnSound(btnSound);
            new ViewStats(statsManager, jsonWriter);
        }

        if (e.getActionCommand().equals("loadButton")) {
            playBtnSound(btnSound);
            new LoadStats(statsManager, jsonReader);

        }
        if (e.getActionCommand().equals("exitButton")) {
            playBtnSound(btnSound);
            System.exit(0);
        }
    }

    // credit: https://stackoverflow.com/questions/36394909/i-created-a-jbutton-that-plays-a-sound-when-clicked
    // EFFECTS: Plays a button sound from file.
    public void playBtnSound(String btnSound) {
        Map<String, Clip> sounds = new HashMap<>();

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(btnSound).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            sounds.put(btnSound, clip);
            clip.start();

        } catch (Exception ex) {

            System.out.println("Error playing sound");
            ex.printStackTrace();
        }
    }


    // MODIFIES: This
    // EFFECTS: Initializes the image that appears on the title page.
    private void initializeTitleImage() {
        ImageIcon unscaledTitleIcon = createImageIcon("/images/titlePage.png", "title picture"); // create the icon
        Image titleImage = unscaledTitleIcon.getImage(); // convert it into an image
        Image finalTitleImage = titleImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
        unscaledTitleIcon = new ImageIcon(finalTitleImage); // convert it back to an image icon
        JLabel titlePageLabel = new JLabel(unscaledTitleIcon);

        mainWindow.add(titlePageLabel, gbc);
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


    // EFFECTS: Initializes all of the button images.
    public void initializeBtnIcons() {
        initializeStartBtnImage();
        initializeInstructionBtnImage();
        initializeResultsBtnImage();
        initializeLoadBtnImage();
        initializeExitBtnImage();
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

        new QuizPanelPopUp(userInputNum, newQuiz, mainFrame, statsManager);
    }

    // EFFECTS: Initiates the new JFrame.
    public void initiatePopUp() {
        popUp = new JFrame();
        popUp.setForeground(Color.pink);
    }





    // GETTERS AND SETTERS ----------------------------------------------------------------------------------

    public void setUserInputNum(int userInputNum) {
        this.userInputNum = userInputNum;
    }



    // PRIVATE ----------------------------------------------------------------------------------------------


    private void initializeStartBtnImage() {
        try {
            ImageIcon img = createImageIcon("/images/startBtn.png", "btnPicture");
            Image titleImage = img.getImage(); // convert it into an image
            Image finalTitleImage = titleImage.getScaledInstance(355, 130,  java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(finalTitleImage);
            startBtn.setIcon(img);

        } catch (Exception ex) {
            System.out.println("NO IMAGE??");
        }
    }

    private void initializeInstructionBtnImage() {

        try {
            ImageIcon img = createImageIcon("/images/instructionsBtn.png", "btnPicture");
            Image titleImage = img.getImage(); // convert it into an image
            Image finalTitleImage = titleImage.getScaledInstance(355, 130,  java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(finalTitleImage);
            instructionBtn.setIcon(img);

        } catch (Exception ex) {
            System.out.println("NO IMAGE??");
        }
    }

    private void initializeResultsBtnImage() {

        try {
            ImageIcon img = createImageIcon("/images/resultsBtn.png", "btnPicture");
            Image titleImage = img.getImage(); // convert it into an image
            Image finalTitleImage = titleImage.getScaledInstance(355, 130,  java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(finalTitleImage);
            viewResultsBtn.setIcon(img);

        } catch (Exception ex) {
            System.out.println("NO IMAGE??");
        }
    }

    private void initializeLoadBtnImage() {

        try {
            ImageIcon img = createImageIcon("/images/loadBtn.png", "btnPicture");
            Image titleImage = img.getImage(); // convert it into an image
            Image finalTitleImage = titleImage.getScaledInstance(355, 130,  java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(finalTitleImage);
            loadBtn.setIcon(img);

        } catch (Exception ex) {
            System.out.println("NO IMAGE??");
        }
    }

    private void initializeExitBtnImage() {

        try {
            ImageIcon img = createImageIcon("/images/exitBtn.png", "btnPicture");
            Image titleImage = img.getImage(); // convert it into an image
            Image finalTitleImage = titleImage.getScaledInstance(355, 130,  java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(finalTitleImage);
            exitBtn.setIcon(img);

        } catch (Exception ex) {
            System.out.println("NO IMAGE??");
        }
    }



}
