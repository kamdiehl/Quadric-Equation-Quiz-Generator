package ui.graphics;

import model.StatValue;
import model.StatsManager;
import persistence.JsonReader;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LoadQuizPanel extends JFrame {

    private static final int TITLE_FONT = 15;
    private JScrollPane quizScroll;
    private JPanel resultsPanel;
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonReader jsonReader;

    public LoadQuizPanel(StatsManager statsManager) {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        setLocationRelativeTo(null);
        quizScroll = new JScrollPane(resultsPanel);
        setSize(600, 400);
        setVisible(true);

        jsonReader = new JsonReader(JSON_STORE);

        loadStats(statsManager);
        printStats(statsManager);

    }


    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadStats(StatsManager statsManager) {
        try {
            statsManager = jsonReader.read();
            String loadIntroString = "Loaded " + statsManager.getStatHistory() + " from " + JSON_STORE;
            JLabel loadIntro = new JLabel(loadIntroString, SwingConstants.CENTER);
            loadIntro.setFont(loadIntro.getFont().deriveFont(Font.BOLD, TITLE_FONT));
            quizScroll.add(loadIntro);

            System.out.println("Loaded " + statsManager.getStatHistory() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + statsManager.getStatHistory() + JSON_STORE);
        }
    }



    // EFFECTS: prints all the thingies in workroom to the console
    private void printStats(StatsManager statsManager) {
        List<StatValue> thingies = statsManager.getAllStats();
        int counter = 1;
        System.out.println("Quiz 1");
        for (StatValue t: thingies) {
            System.out.println(t);
            int indexNum = thingies.lastIndexOf(t);
            if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
                System.out.println(" ");
                counter++;
                System.out.println("Quiz " + counter);

            }
        }
    }






}
