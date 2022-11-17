package user_login;

import javax.swing.*;

// This is for the UI.
public class LabelTextPanel extends JPanel {

    /**
     * A helper method to create a panel with a label and a text box.
     * @param label The label of various objects on the screen.
     * @param textField The text box.
     */
    public LabelTextPanel (JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
