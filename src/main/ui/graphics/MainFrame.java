package ui.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class MainFrame extends JFrame implements ActionListener {
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 900;
    public static final int TITLE_FONT = 22;
    public static final Color TITLE_COLOR = new Color(1, 108, 104);

    public static final Color startBtnColor = new Color(0, 198, 183);
    public static final Color instructionBtnColor = new Color(5, 170, 157);
    public static final Color loadBtnColor = new Color(4, 118, 109);
    public static final Color exitBtnColor = new Color(2, 92, 94);

    JButton startBtn = new JButton("START");
    JButton instructionBtn = new JButton("HOW TO PLAY");
    JButton loadBtn = new JButton("LOAD DATA");
    JButton exitBtn = new JButton("EXIT");
    JButton saveBtn = new JButton("SAVE");

    GridBagConstraints gbc;
//    ImagePanel startQuizPanel;
//    JPanel sidePanel;


    // constructor
    public MainFrame() {
        JFrame mainWindow = new JFrame("Quadric Quiz");
        JPanel mainPanel = new JPanel(new GridLayout(4,6));
        mainWindow.setLayout(new BorderLayout());
        //gbc = new GridBagConstraints();
        createWindow(mainWindow);


        mainWindow.add(mainPanel);
       // createTitlePanel(mainWindow);
       // initiateButtons(mainWindow);
        compilePanels(mainPanel);
        mainWindow.add(mainPanel);
//        sidePanel = new JPanel();
//        startQuizPanel = new ImagePanel(sidePanel);


    }


    public void compilePanels(JPanel mainPanel) {
        JPanel titlePanel = new JPanel();

       //GridBagConstraints c = new GridBagConstraints();

        JLabel titleLabel = new JLabel("QUADRIC EQUATION QUIZ");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
        titleLabel.setForeground(TITLE_COLOR);
        titleLabel.setPreferredSize(new Dimension(300, 100));
        titlePanel.add(titleLabel);
      //  c.fill = GridBagConstraints.HORIZONTAL;
       // c.weightx = 1;
        //c.weighty = 1;
        //c.anchor = GridBagConstraints.NORTHWEST;

        mainPanel.add(titlePanel,);


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
       // titlePanel.setBackground(Color.blue);

        mainWindow.add(titlePanel, gbc);
    }


    // EFFECTS: Runs the app
    public void initiateButtons(JFrame mainWindow) {

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 5));
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST;

        startBtn.setActionCommand("startButton");
        startBtn.addActionListener(this);
        instructionBtn.setActionCommand("instructionButton");
        instructionBtn.addActionListener(this);
        loadBtn.setActionCommand("loadButton");
        loadBtn.addActionListener(this);
        exitBtn.setActionCommand("exitButton");
        exitBtn.addActionListener(this);
        saveBtn.setActionCommand("saveButton");
        saveBtn.addActionListener(this);

        buttonPanel.add(startBtn);
        buttonPanel.add(instructionBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(exitBtn);

        mainWindow.add(buttonPanel, gbc);

    }

    // EFFECTS: Method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("startButton")) {
            playSound("/sounds/button.wav");
            new QuizLengthPopUp();
        }

        if (e.getActionCommand().equals("instructionButton")) {
            new InstructionPopUp();
        }

        if (e.getActionCommand().equals("saveButton")) {
            // label.setText(field.getText());
        }
        if (e.getActionCommand().equals("loadButton")) {
            // label.setText(field.getText());
        }
        if (e.getActionCommand().equals("exitButton")) {
            System.exit(0);
        }

    }

    // function STRUCTURE credit to sauveSnippets.com

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }



}
