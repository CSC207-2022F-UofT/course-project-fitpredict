package exercise_screens;

import javax.swing.*;

// Frameworks & Drivers

public class LabelTextPanel extends JPanel {
    /**
     * Generate a text field with a text label to the left of it
     * @param label The text to be labeled to the left of the text field
     * @param textField A text field to be placed to the right of the label
     */
    public LabelTextPanel(JLabel label, JTextField textField) {
        label.setAlignmentX(LEFT_ALIGNMENT);
        textField.setAlignmentX(RIGHT_ALIGNMENT);
        this.add(label);
        this.add(textField);
    }
}
