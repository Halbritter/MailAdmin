package de.albritter.gui;

import de.albritter.sql.MySQLHandler;
import de.albritter.sql.data.Domain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hhalbritter on 15.06.2016.
 */
public class ApplyListener implements ActionListener {
    private WindowMain src;

    public ApplyListener(WindowMain src) {

        this.src = src;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (src.getTabbedPane().getSelectedIndex()) {
            case 0:
                Domain d = new Domain();
                d.setDomain(src.getPanelDomain().getTextDomain().getText());
                d.setActive(src.getPanelDomain().getChckbxActive().isSelected());
                MySQLHandler.add(d);
                break;
            case 1://Mailbox
                break;
            case 2://Alias
                break;
            case 3: //TLS
                break;

        }
    }
}
