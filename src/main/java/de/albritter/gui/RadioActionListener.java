package de.albritter.gui;

import de.albritter.utils.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public class RadioActionListener implements ActionListener {


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                EventHandler.radioAdd();
                break;
            case "Update":
                EventHandler.radioUpdate();
                break;
            case "Remove":
                EventHandler.radioRemove();
                break;
        }
    }
}
