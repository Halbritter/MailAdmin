package de.albritter.gui.tables;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by hhalbritter on 14.06.2016.
 */
public class TLSTable extends JPanel implements UpdateTabel {
    public static final String[] HEADER = new String[]{"ID", "Domain", "Parameter", "Active"};
    private Object[][] data;
    private DataTable table;

    public TLSTable() {
        setLayout(new BorderLayout());
        table = new DataTable(HEADER);
        table.updateTable(new Object[][]{{5, "Domain.tld", "params", true}});
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

    }

    @Override
    public void updateTLSTable(Object[][] data) {
        this.data = data;
    }
}
