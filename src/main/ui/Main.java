package ui;

import java.io.FileNotFoundException;

public class Main {
    // This class is the main class that runs the app.
    public static void main(String[] args) {
        try {
            new QuadricApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
