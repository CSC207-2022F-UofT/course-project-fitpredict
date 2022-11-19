package exercise_screens;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        label.setAlignmentX(LEFT_ALIGNMENT);
        textField.setAlignmentX(RIGHT_ALIGNMENT);
        this.add(label);
        this.add(textField);
    }
}
