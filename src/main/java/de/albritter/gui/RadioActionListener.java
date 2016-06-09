package de.albritter.gui;

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
        System.out.println(e.getID());
    }
}
