package exerciseGUI;

import javax.swing.*;

public class ExerciseCreatorGUI extends JFrame {
    private JButton button1;
    private JPanel mainPanel;
    private JLabel label1;
    private JLabel label2;

//    public ExerciseCreatorGUI() {
//        button1.addActionListener(new ActionListener() {
//            /**
//             * Invoked when an action occurs.
//             *
//             * @param e the event to be processed
//             */
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//    }

    public static void main(String[] args) {
        ExerciseCreatorGUI ecg = new ExerciseCreatorGUI();
        System.out.println(new ExerciseCreatorGUI().mainPanel.contains(0, 0));
        // ecg.setContentPane(new ExerciseCreatorGUI().mainPanel);
        ecg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecg.setVisible(true);
        ecg.pack();
    }
}
