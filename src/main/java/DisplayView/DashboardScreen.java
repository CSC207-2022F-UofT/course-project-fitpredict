package DisplayView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardScreen extends JPanel implements ActionListener {

    // Placeholder data for the table. We will input real data after merging
    String[] columnNames = {"Weight", "Age"};
    Object[][] data = {
            {100, 18},
            {120, 19}
    };

    public DashboardScreen() {
        // Setting the title and alignment
        JLabel title = new JLabel("Dashboard");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The table that will be displayed as part of the dashboard
        JTable table = new JTable(data, columnNames);

        // Putting the table in a JScrollPane object so it will be fully visible
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Creating the buttons for actions
        JButton logOut = new JButton("Log out");
        JButton back = new JButton("Back");

        JPanel buttons = new JPanel();
        buttons.add(back);
        buttons.add(logOut);

        // add even listeners to buttons
        logOut.addActionListener(this);
        back.addActionListener(this);

        // setting the layout of the screen
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // adding all the components via JSwing
        this.add(tableScrollPane);
        this.add(buttons);

    }

    /**
     * React to a button click that results in event.
     */
    public void actionPerformed(ActionEvent event) {
        System.out.println("Clicked " + event.getActionCommand());
        System.out.println(event.getSource());
        System.out.println(event.getModifiers());
        System.out.println(event.getWhen());
        System.out.println(event.getID());
        System.out.println(event.paramString());
    }
}
