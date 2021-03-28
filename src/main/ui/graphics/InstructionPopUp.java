package ui.graphics;

import javax.swing.*;
import java.awt.*;

// This class produces the JFrame containing the instructions for the app. It's created when the instruction button
// is pressed in MainFrame.
public class InstructionPopUp {


    // constructor
    // EFFECTS: Initiates all text to be put into the dialog box and sets the color of the box.
    public InstructionPopUp() {

        JFrame popUp = new JFrame();
        ImageIcon icon = new ImageIcon("images/hyp1sh.jpg");

        // credit kinda: https://www.roseindia.net/tutorial/java/swing/showtextcolor.html
        UIManager.put("OptionPane.background",new Color(0, 227, 197));
        UIManager.put("Panel.background",new Color(179, 234, 229));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", (new Color(60, 34, 88)));
        // ---

        Object[] options = { "Okay", "View Equation Slideshow" };

        int answer = JOptionPane.showOptionDialog(popUp,
                compileAll(),
                "How to Play",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                options,
                options[0]);

        if (answer == JOptionPane.YES_NO_CANCEL_OPTION) {
            JFrame slide1 = new JFrame();
            slideshow(slide1, icon);
        }
    }

    // EFFECTS: Constructs the slide show displays all of the equation answers.
    public void slideshow(JFrame slide1, Icon icon) {
        String text1 = "\nCIRCULAR CYLINDER\nax^2 + ay^2 = d\nExample: 2x^2 +2x^2 = 6";
        JOptionPane.showMessageDialog(slide1, text1, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide2 = new JFrame();
        String text2 = "\nHYPERBOLIC PARABOLOID\nax^2 - by^2 - cz = 0\nExample: 4x^2 - 2x^2 - 5z = 0";
        JOptionPane.showMessageDialog(slide2, text2, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide3 = new JFrame();
        String text3 = "\nCONE\nax^2 + by^2 - cz^2 = 0\nExample: 1x^2 + 2x^2 - 3z^2 = 0";
        JOptionPane.showMessageDialog(slide3, text3, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide4 = new JFrame();
        String text4 = "\nELLIPSOID\nax^2 + by^2 + cz^2 = d\nExample: 8x^2 + 2x^2 + 2z^2 = 9";
        JOptionPane.showMessageDialog(slide4, text4, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide5 = new JFrame();
        String text5 = "\nHYPERBOLOID OF ONE SHEET\nax^2 + by^2 - cz^2 = d\nExample: 2x^2 + 3x^2 - 4z^2 = 5";
        JOptionPane.showMessageDialog(slide5, text5, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide6 = new JFrame();
        String text6 = "\nSPHERE\nax^2 + ay^2 + az^2 = d\nExample: 2x^2 + 2x^2 + 2z^2 = 4";
        JOptionPane.showMessageDialog(slide6, text6, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide7 = new JFrame();
        String text7 = "\nPARABOLOID\nax^2 + by^2 - cz = 0\nExample: 2x^2 + 7x^2 - 3z = 0";
        JOptionPane.showMessageDialog(slide7, text7, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

        JFrame slide8 = new JFrame();
        String text8 = "\nHYPERBOLOID OF TWO SHEETS\n- ax^2 - by^2 + cz^2 = d\nExample: - 6x^2 - 2x^2 + 3z^2 = 3";
        JOptionPane.showMessageDialog(slide8, text8, "Equation Slideshow", JOptionPane.INFORMATION_MESSAGE, icon);

    }




    // EFFECTS: Compiles all of the text needed in the text box.
    public String compileAll() {
        return compileIntro() + compileInstructions() + compileFootnotes();
    }


    // EFFECTS: Compiles all the strings that make up the introduction for the InstructionPopUp.
    public String compileIntro() {
        String s1 = "This is a quadric surface equation generator. It used to practice identifying quadric surfaces\n";
        String s2 = "from solely their equation form. Why is it called a generator? Because if you want it to, it\n";
        String s3 = "will generate an infinite^1 number of equations for you to practice with.\n";
        String s4 = "You'll never have to spend time looking for practice problems online ever again.\n";
        String s5 = "\n";

        return s5 + s1 + s2 + s3 + s4 + s5;
    }


    // EFFECTS: Compiles all the strings that make up the instructions for the InstructionPopUp.
    public String compileInstructions() {

        String s0 = "\n";
        String s6 = "INSTRUCTIONS\n";
        String s7 = "1. Click the START button and enter the number of questions you want to be asked in the popup.\n";
        String s8 = "2. Click OKAY. Another pop-up containing your inputted # of randomly generated equations will \n";
        String s9 = "be displayed. Input your answer^2 for each equation in the text field next to it.\n";
        String s10 = "3. Once finished, press SUBMIT at the bottom of the quiz. Your answers will light up green\n";
        String s11 = "if your answer is correct, and red if it is incorrect.\n";
        String s12 = "4. You will also receive your quiz score at the bottom of the completed quiz. It will be \n";
        String s13 = "available for further viewing in the VIEW STATS button on the main page. \n";
        String s14 = "5. When viewing stats, you'll have the option to save your quiz results to file if you want \n";
        String s15 = "to inspect them after exiting the program and re-running it. In this case, just click SAVE.\n";
        String s16 = "6. When re-entering the program, if you wish to see your previous quiz results, click LOAD \n";
        String s17 = "DATA and then press VIEW STATS. \n";

        return s6 + s0 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16 + s17 + s0;

    }


    // EFFECTS: Compiles all the strings that make up the footnotes for the InstructionPopUp.
    public String compileFootnotes() {

        String s1 = "FOOTNOTES: \n";
        String s0 = "\n";
        String s2 = "1. By infinite questions, I mean up to 2147483647 questions because \n";
        String s3 = "that's all intelliJ can handle. Do not input a number higher than 2147483647 when\n";
        String s4 = "prompted or your computer WILL spontaneously combust. Yes, that is a threat. \n";

        String s5 = "2. Answers in the text field are in string format. This means that after identifying the \n";
        String s6 = "equation on the left, type out the name of the surface it produces. For example, if the \n";
        String s7 = "question is '3x^2 - 2y^2 - 4z = 0', then type your answer as 'hyperbolic paraboloid'. \n";

        return s1 + s0 + s2 + s3 + s4 + s5 + s6 + s7;
    }




}
