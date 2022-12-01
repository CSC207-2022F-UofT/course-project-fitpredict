package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public interface WindowCloser {
    default void closeWindow(ActionEvent e){
        JComponent jc = (JComponent) e.getSource();
        Window w = SwingUtilities.getWindowAncestor(jc);
        w.dispose();
    }
}
