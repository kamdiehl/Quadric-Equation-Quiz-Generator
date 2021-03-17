package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class JframeMaker extends JFrame {

    private JFrame newWindow;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    public static final int TITLE_FONT = 27;
    public static final Color TITLE_COLOR = new Color(1, 108, 104);


    public JFrame newViewWindow(String titleName) {

        newWindow = new JFrame(titleName);
        newWindow.setVisible(true);

        newWindow.setLayout(new GridBagLayout());
        newWindow.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel(new GridLayout(4, 4, 1, 1));

        initializeGraphics(newWindow);
        initializeTitle(topPanel, newWindow, titleName);

        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setResizable(false);

        return newWindow;
    }


    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this quadric app will operate
    public void initializeGraphics(JFrame newFrameName) {
        newFrameName.setLayout(new BorderLayout());
        newFrameName.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        newFrameName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrameName.setLocationRelativeTo(null);
        newFrameName.setVisible(true);

        // background colours
        newFrameName.setBackground(Color.cyan);
        newFrameName.setForeground(Color.blue);
    }


    // EFFECTS: Initializes the title text that displays title name on title page.
    public void initializeTitle(JPanel topPanel, JFrame windowName, String titleName) {
        JLabel titleLabel = new JLabel(titleName, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_FONT));
        titleLabel.setForeground(TITLE_COLOR);
        JPanel lengthPanel = new JPanel();
        lengthPanel.add(titleLabel);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(lengthPanel);
        windowName.add(topPanel, BorderLayout.NORTH);
    }

}
