package ui.graphics;

import javax.swing.*;
import java.awt.*;

public class InstructionPopUp {
    private JFrame popUp;


    // constructor
    public InstructionPopUp() {
        popUp = new JFrame();
        String sentence1 = "bro just press start and its pretty self explanatory from then on.";
        String sentence2 = " ur here to guess quadric equations and ur seriously clicking on the instructions?";
        String sentence3 = " idiot";
        JOptionPane.showMessageDialog(popUp, sentence1 + sentence2 + sentence3);
    }







    // getters & setters


}
