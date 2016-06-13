package de.albritter.gui.tables;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public class MailboxTable extends JPanel implements UpdateTabel {
    DataTable table;

    public MailboxTable() {
        setLayout(new BorderLayout());
        table = new DataTable();
        table.setTableHeader(new String[]{"ID", "Username", "Domain", "Password", "Quota", "Enabled", "Sendonly"});
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(table.getColumnCount() - 1).setPreferredWidth(60);

        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(table.getColumnCount() - 1).setMaxWidth(120);
        add(new JScrollPane(table));
    }

    @Override
    public void updateDomainTable(String[] header, Object[][] data) {

    }

    @Override
    public void updateMailboxTable(String[] header, Object[][] data) {
        table.updateTable(header, data);
    }

    @Override
    public void updateAliasTable(String[] header, Object[][] data) {

    }

    @Override
    public void updateTLSTable(String[] header, Object[][] data) {

    }
}
