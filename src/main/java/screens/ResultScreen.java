package screens;

// Frameworks & Drivers

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultScreen extends JFrame implements ActionListener {

    /**
     * A small, pop-up screen that can be closed by pushing a button labeled "Okay"
     * @param text The message to be displayed on the screen
     */
    public ResultScreen(String text) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setPreferredSize(new Dimension(300, 40));

        JLabel title = new JLabel(text);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(title);

        JButton exit = new JButton("Okay");
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addActionListener(this);
        main.add(exit);

        this.setContentPane(main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Invoked when an action occurs.
     * Close the pop-up when the "Okay" button is pressed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
