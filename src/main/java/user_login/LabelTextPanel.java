package user_login;

import javax.swing.*;

// This is for the UI.
public class LabelTextPanel extends JPanel {
    public LabelTextPanel (JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
