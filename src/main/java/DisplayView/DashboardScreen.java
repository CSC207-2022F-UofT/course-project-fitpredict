package DisplayView;

import javax.swing.*;
import java.awt.*;

public class DashboardScreen extends JPanel {

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

        // setting the layout of the screen
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // adding all the components via JSwing
        this.add(tableScrollPane);
        this.add(buttons);

    }

}
