package ui.graphics;

import model.StatValue;
import model.StatsManager;
import persistence.JsonWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

// Class creates panel and loads Json files when prompted
public class ViewStats extends JFrame implements ActionListener {

    private JScrollPane quizScroll;
    private JPanel resultsPanel;
    private JButton homeBtn;
    private JButton saveBtn;
    private StatsManager statMan;
    // json
    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/workroom.json";


    // constructor
    // creates and displays a panel with all your quiz stats
    public ViewStats(StatsManager statsManager, JsonWriter jsonWriters) {
        this.statMan = statsManager;
        this.jsonWriter = jsonWriters;

        resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(164, 224, 205));
        setTitle("Saved Results");
        setLayout(new BorderLayout());
        resultsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        quizScroll = new JScrollPane(resultsPanel);

        add(BorderLayout.CENTER, quizScroll);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        printStats();
        initiateButtons();


    }


    // EFFECTS: prints all the thingies in workroom to the console and the quizScroll JPanel
    private void printStats() {
        List<StatValue> thingies = statMan.getAllStats();
        int counter = 1;
        // console
        System.out.println("Quiz 1");

        // JSwing
        JLabel quizOne = new JLabel("Quiz 1", SwingConstants.CENTER);
        quizOne.setFont(new Font("Arial", Font.BOLD, 15));
        resultsPanel.add(quizOne);

        for (StatValue t: thingies) {

            // console
            System.out.println(t);
            int indexNum = thingies.lastIndexOf(t);

            // JSwing
            JLabel firstQuiz = new JLabel(t.toString(), SwingConstants.CENTER);
            firstQuiz.setFont(new Font("Arial", Font.PLAIN, 15));
            resultsPanel.add(firstQuiz);

            // console
            if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
                System.out.println(" ");
                counter++;
                System.out.println("Quiz " + counter);

                JLabel title = new JLabel("Quiz " + counter, SwingConstants.CENTER);
                title.setFont(new Font("Arial", Font.PLAIN, 15));
                resultsPanel.add(title);

            }
        }
    }


    // EFFECTS: Instantiates the JButtons for the resultsPanel
    public void initiateButtons() {

        homeBtn = new JButton("Home");
        homeBtn.setActionCommand("home");
        homeBtn.addActionListener(this);

        homeBtn.setOpaque(true);
        homeBtn.setBackground(new Color(13, 144, 144));

        saveBtn = new JButton("Save Results");
        saveBtn.setActionCommand("save");
        saveBtn.addActionListener(this);

        saveBtn.setOpaque(true);
        saveBtn.setBackground(new Color(17, 193, 152));

        resultsPanel.add(saveBtn);
        resultsPanel.add(homeBtn);

    }


    // EFFECTS: saves the workroom to file
    private void saveQuiz() {
        try {
            jsonWriter.open();
            jsonWriter.write(statMan);
            jsonWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("home")) {
            homeBtn.setBackground(new Color(39, 206, 7));
            homeBtn.setForeground(new Color(14, 90, 1));
            SwingUtilities.windowForComponent(this.resultsPanel).dispose();
        }

        if (e.getActionCommand().equals("save")) {
            saveBtn.setBackground(new Color(39, 206, 7));
            saveBtn.setForeground(new Color(14, 90, 1));
            saveQuiz();
            SwingUtilities.windowForComponent(this.resultsPanel).dispose();
        }
    }
}
