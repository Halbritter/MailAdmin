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
        table = new DataTable();
        table.setTableHeader(HEADER);
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
