
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

package de.albritter.gui.tables;

import de.albritter.utils.EventHandler;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public class MailboxTable extends JPanel implements UpdateTabel {
    public final static String[] HEADER = new String[]{"ID", "Username", "Domain", "Password", "Quota", "Active", "Sendonly"};
    DataTable table;

    public MailboxTable() {

        EventHandler.registerForUpdateTableEvent(this);
        setLayout(new BorderLayout());
        table = new DataTable(HEADER);
        table.updateTable(new Object[][]{{13, "user", "domain", "pass", 5000, true, true}});
        add(new JScrollPane(table));
    }

    @Override
    public void updateDomainTable(Object[][] data) {

    }

    @Override
    public void updateMailboxTable(Object[][] data) {
        table.updateTable(data);
    }

    @Override
    public void updateAliasTable(Object[][] data) {

    }

    @Override
    public void updateTLSTable(Object[][] data) {

    }
}
