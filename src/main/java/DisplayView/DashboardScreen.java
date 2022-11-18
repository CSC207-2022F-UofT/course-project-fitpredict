package DisplayView;

import javax.swing.*;
import java.awt.*;

public class DashboardScreen extends JPanel {

    public DashboardScreen() {
        JLabel title = new JLabel("Dashboard");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] columnNames = {"Weight", "Age"};
        Object[][] data = {
                {100, 18},
                {120, 19}
        };

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(scrollPane);

    }

}
