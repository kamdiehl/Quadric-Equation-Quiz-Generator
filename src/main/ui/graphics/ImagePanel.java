package ui.graphics;

import javax.swing.*;
import java.awt.*;

public class ImagePanel {
    private ImageIcon unscaledTitleIcon;
    public static final int IMAGE_WIDTH = 450;
    public static final int IMAGE_HEIGHT = 470;
    private JLabel titlePageLabel;
    private JLabel label;

    public ImagePanel(JPanel imagePanel) {
        initializeTitleImage(imagePanel);
    }


    // MODIFIES: This
    // EFFECTS: Initializes the image that appears on the title page.
    private void initializeTitleImage(JPanel topPanel) {
        unscaledTitleIcon = createImageIcon("/images/hyp1sh.jpg", "title picture"); // create the icon
        Image titleImage = unscaledTitleIcon.getImage(); // convert it into an image
        Image finalTitleImage = titleImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
        unscaledTitleIcon = new ImageIcon(finalTitleImage); // convert it back to an image icon
        label = new JLabel("Image and Text", unscaledTitleIcon, JLabel.CENTER);
        titlePageLabel = new JLabel(unscaledTitleIcon);
        topPanel.add(titlePageLabel);
    }


    // EFFECTS: Creates the title image icon
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
