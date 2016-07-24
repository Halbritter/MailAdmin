
/*
 * This file is part of MailAdmin.
 *
 *     MailAdmin is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     MailAdmin is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with MailAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.gui;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                src.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Could not authenticate");
            }
        }

    }
}
