package ui;

import ui.graphics.MainFrame;


import javax.swing.*;
import java.awt.geom.QuadCurve2D;
import java.io.FileNotFoundException;

public class Main {
    // This class is the main class that runs the app.
    public static void main(String[] args) {
        //new MainFrame();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();

            }
        });


                //new QuadricGui();
//        try {
//            new QuadricApp();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }
    }
}
