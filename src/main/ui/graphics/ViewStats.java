package ui.graphics;

import model.StatValue;
import model.StatsManager;
import persistence.JsonReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ViewStats extends JFrame implements ActionListener {

    private static final int TITLE_FONT = 15;
    private JScrollPane quizScroll;
    private JPanel resultsPanel;
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonReader jsonReader;
    private JButton homeBtn;
    private StatsManager statMan;

    public ViewStats(StatsManager statsManager) {
        this.statMan = statsManager;

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

        jsonReader = new JsonReader(JSON_STORE);

       // loadStats();
        printStats();
        initiateButtons();


    }

//
//    // MODIFIES: this
//    // EFFECTS: loads workroom from file
//    private void loadStats() {
//        try {
//            statMan = jsonReader.read();
//            String loadIntroString = "Loaded " + statMan.getStatHistory() + " from " + JSON_STORE;
//            JLabel loadIntro = new JLabel(loadIntroString, SwingConstants.CENTER);
//            loadIntro.setFont(new Font("Arial", Font.PLAIN, 15));
//            resultsPanel.add(loadIntro);
//
//            System.out.println("Loaded " + statMan.getStatHistory() + " from " + JSON_STORE);
//
//            printStats();
//
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + statMan.getStatHistory() + JSON_STORE);
//        }
//    }



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
            // JSwing
            JLabel firstQuiz = new JLabel(t.toString(), SwingConstants.CENTER);
            firstQuiz.setFont(new Font("Arial", Font.PLAIN, 15));
            resultsPanel.add(firstQuiz);

            // console
            System.out.println(t);
            int indexNum = thingies.lastIndexOf(t);

            // console
            if ((indexNum == 2 || indexNum == 5 || indexNum == 8 || indexNum == 11) && indexNum < thingies.size() - 1) {
                System.out.println(" ");
                counter++;
                System.out.println("Quiz " + counter);

            }
        }
    }

    // EFFECTS: Instantiates the JButtons for the resultsPanel
    public void initiateButtons() {

        homeBtn = new JButton("Home");
        homeBtn.setActionCommand("home");
        homeBtn.addActionListener(this);

        homeBtn.setOpaque(true);
        homeBtn.setBackground(new Color(13, 144, 83));

        resultsPanel.add(homeBtn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("home")) {
            SwingUtilities.windowForComponent(this.resultsPanel).dispose();
        }


    }
}
