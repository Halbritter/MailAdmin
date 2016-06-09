package de.albritter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hhalbritter on 07.06.2016.
 */
public class LoginActionListener implements ActionListener {

    Window src;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancel") {
            src.dispose();
            System.exit(0);
        } else if (e.getActionCommand() == "Login") {
         System.out.print("Login");
        }

    }

    public LoginActionListener(Window src) {
        this.src = src;
    }
}
