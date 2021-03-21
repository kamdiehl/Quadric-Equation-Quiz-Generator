package ui.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ActionListener {
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 900;
    public static final int TITLE_FONT = 22;
    public static final Color TITLE_COLOR = new Color(1, 108, 104);
    public static final Color TITLE_BACKGROUND = new Color(2, 239, 231);

    public static final Color startBtnColor = new Color(0, 198, 183);
    public static final Color instructionBtnColor = new Color(5, 170, 157);
    public static final Color saveBtnColor = new Color(8, 137, 127);
    public static final Color loadBtnColor = new Color(4, 118, 109);
    public static final Color exitBtnColor = new Color(2, 92, 94);

    JButton startBtn = new JButton("START");
    JButton instructionBtn = new JButton("HOW TO PLAY");
    JButton loadBtn = new JButton("LOAD DATA");
    JButton exitBtn = new JButton("EXIT");
    JButton saveBtn = new JButton("SAVE");

    GridBagConstraints gbc;


    // constructor
    // EFFECTS: Constructs the main JFrame containing all of the panels for the program.
    public MainFrame() {
        JFrame mainWindow = new JFrame("Quadric Quiz");
        mainWindow.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createWindow(mainWindow);
        createTitlePanel(mainWindow);

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
        buttonPanel.add(saveBtn);
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
        saveBtn.setActionCommand("saveButton");
        saveBtn.addActionListener(this);

    }



    // EFFECTS: Initiates button colors.
    public void buttonColors() {

        startBtn.setBackground(startBtnColor);
        startBtn.setForeground(exitBtnColor);
        startBtn.setOpaque(true);
        instructionBtn.setBackground(instructionBtnColor);
        instructionBtn.setForeground(loadBtnColor);
        instructionBtn.setOpaque(true);
        saveBtn.setBackground(saveBtnColor);
        saveBtn.setForeground(loadBtnColor);
        saveBtn.setOpaque(true);
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





    // GETTERS AND SETTERS ----------------------------------------------------------------------------------



}
