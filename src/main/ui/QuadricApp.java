package ui;

import java.util.Scanner;

public class QuadricApp {

    private Scanner input;

    // EFFECTS: Starts the quadric surface generator application
    public QuadricApp() {
        runApp();
    }

    public void runApp() {
        String command = null;
        input = new Scanner(System.in);

        System.out.println("How many questions do you want to be tested on?");
        command = input.next();
        command = command.toLowerCase();

        if (command.equals("five")) {
            System.out.println("sweet");
        } else {
            System.out.println("oof");
        }
    }
}
