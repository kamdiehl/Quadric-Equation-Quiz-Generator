package ui;

import ui.graphics.MainFrame;
import javax.swing.*;

public class Main {
    // This class is the main class that runs the app.
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();

            }
        });



//        try {
//            new QuadricApp();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }

    }
}
