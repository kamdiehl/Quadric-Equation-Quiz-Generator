package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class QuadricGui extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField field;
    private ImageIcon titleIcon;
    private JLabel titlePageLabel;
    private JFrame frame;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    public static final int TITLE_FONT = 24;
    public static final String TITLE_TEXT = "QUADRIC EQUATION QUIZ";
    public static final Color TITLE_COLOR = new Color(1, 108, 83);



    // Constructor
    // EFFECTS:
    public QuadricGui() {
        super("Quadric App");
        initializeGraphics();

        //titleIcon = new ImageIcon(this.getClass().getResource("/hyp1sh.jpg"));
       // titlePageLabel = new JLabel(titleIcon);
        //titlePageLabel.setSize(500, 200);

        //setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
        setLayout(new BorderLayout());

        // title
        JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(titlePanel);
        add(topPanel, BorderLayout.NORTH);

        //topPanel.add(titlePageLabel);

        // start & instruction buttons
        JPanel bottomPanel = new JPanel(new GridLayout(4, 4, 1, 1));

        JButton startBtn = new JButton("START");
        JButton instructionBtn = new JButton("HOW TO PLAY");
        JButton loadBtn = new JButton("LOAD DATA");
        JButton exitBtn = new JButton("EXIT");

        startBtn.setActionCommand("myButton");
        startBtn.addActionListener(this);

        bottomPanel.add(startBtn);
        bottomPanel.add(instructionBtn);
        bottomPanel.add(loadBtn);
        bottomPanel.add(exitBtn);
        add(bottomPanel, BorderLayout.SOUTH);




        // from project guide
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));



        //label = new JLabel("flag");
        //field = new JTextField(5);
       // add(field);

        //add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


        // background colours
        setBackground(Color.cyan);
        setForeground(Color.blue);

        Color startBtnColor = new Color(0, 198, 183);
        Color instructionBtnColor = new Color(5, 170, 157);
        Color loadBtnColor = new Color(4, 118, 109);
        Color exitBtnColor = new Color(2, 92, 94);

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




    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this quadric app will operate, and populates the tools to be used
    //           to manipulate this drawing
    public void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }





    // EFFECTS: Method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            label.setText(field.getText());
        }

    }
}
