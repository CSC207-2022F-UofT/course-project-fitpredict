package screens;

import controllers.UserLoginController;
import entities.CurrentUser;
import use_cases.UserAccountList;
import use_cases.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DashboardScreen class
 */
public class DashboardScreen extends JFrame implements ActionListener, WindowCloser {
    String[] columnNames = {
            "Date",
            "Weight",
            "Calories Burnt"
    };

    // CurrentUser.getDataPointMap to be implemented during refactoring
    /* in refactoring: we may need to define an empty Object[][] and then generate it in the screen, so
      we have access to CurrentUser currentUser.
     */
    Object[][] data = Table.generate(CurrentUser.getInstance().getDataPointMap());

    String backText = "Back";
    String logOutText = "Log out";
    UserAccountList userAccountList;

    /**
     * Constructor for DashboardScreen
     */
    public DashboardScreen(UserAccountList userAccountList) {
        this.userAccountList = userAccountList;

        // Setting the title and alignment
        JLabel title = new JLabel("Dashboard");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The table that will be displayed as part of the dashboard
        JTable table = new JTable(data, columnNames);

        // Putting the table in a JScrollPane object so it will be fully visible
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Creating the buttons for actions
        JButton logOut = new JButton(logOutText);
        JButton back = new JButton(backText);
        
        JPanel buttons = new JPanel();
        buttons.add(back);
        buttons.add(logOut);

        // add even listeners to buttons
        logOut.addActionListener(this);
        back.addActionListener(this);

        // setting the layout of the screen
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // adding all the components via JSwing
        this.add(tableScrollPane);
        this.add(buttons);
    }

    /**
     * React to a button click that results in event.
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getActionCommand().equals(backText)) {
                closeWindow(event);

                MainMenuScreen screen = new MainMenuScreen(userAccountList);
                screen.pack();
                screen.setVisible(true);
            } else if (event.getActionCommand().equals(logOutText)) {
                JOptionPane.showMessageDialog(this, "Logged out!");

                closeWindow(event);

                UserLogin userLogin = new UserLogin(userAccountList);
                UserLoginController userLoginController = new UserLoginController(userLogin);
                UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
                userLoginScreen.pack();
                userLoginScreen.setVisible(true);
            } else {
                System.out.println("Button clicked has no function");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
