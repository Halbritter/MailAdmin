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

package de.albritter.gui.tables;

import de.albritter.utils.EventHandler;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * Created by hhalbritter on 14.06.2016.
 */
public class AliasTable extends JPanel implements UpdateTabel {
    public final static String[] HEADER = new String[]{"ID", "Incoming User", "Incoming Domain", "Destination User", "Destination Domain", "Active"};
    private DataTable table;

    public AliasTable() {
        EventHandler.registerForUpdateTableEvent(this);
        setLayout(new BorderLayout());
        table = new DataTable(HEADER);
        table.updateTable(new Object[][]{{422224, "usadsdsadrIn", "doasdsadmainIn", "usasdsaderOut", "asdasd", false}});

        add(new JScrollPane(table));
    }


    @Override
    public void updateDomainTable(Object[][] data) {
    }

    @Override
    public void updateMailboxTable(Object[][] data) {

    }

    @Override
    public void updateAliasTable(Object[][] data) {
        table.updateTable(data);

    }

    @Override
    public void updateTLSTable(Object[][] data) {

    }
}
