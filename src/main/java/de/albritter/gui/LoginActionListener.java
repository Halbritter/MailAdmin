package de.albritter.gui;

import de.albritter.utils.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Created by hhalbritter on 07.06.2016.
 */
public class LoginActionListener implements ActionListener {

    Window src;

    public LoginActionListener(Window src) {
        this.src = src;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancel") {
            src.dispose();
            System.exit(0);
        } else if (e.getActionCommand() == "Login") {
            if (src.openMySQLConection()) {
                WindowMain w = new WindowMain();
                w.setVisible(true);
                w.setSize(600, 400);
                EventHandler.radioAdd();
                src.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Could not authenticate");
            }
        }

    }
}
