import screens.DashboardScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window
        JFrame application = new JFrame("Dashboard Display");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        DashboardScreen dashboardScreen = new DashboardScreen();
        screens.add(dashboardScreen);
        cardLayout.show(screens, "dashboard");

        application.pack();
        application.setVisible(true);
    }
}
