/*
 * This file is part of VMail.
 *
 *     VMail is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     VMail is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.gui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public class TabbedItemListener implements ChangeListener {


    private final JTabbedPane src;

    public TabbedItemListener(JTabbedPane src) {
        this.src = src;
    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        WindowMain w = (WindowMain) src.getParent().getParent().getParent().getParent();
        switch (src.getSelectedIndex()) {
            case 0:
                w.swapPanel(w.getPanelDomain());
                break;
            case 1:
                w.swapPanel(w.getPanelMailbox());
                break;
            case 2:
                w.swapPanel(w.getPanelAliases());
                break;
            case 3:
                w.swapPanel(w.getPanelTLS());
                break;
        }

    }
}
