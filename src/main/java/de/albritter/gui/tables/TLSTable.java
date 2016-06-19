package de.albritter.gui.tables;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * Created by hhalbritter on 14.06.2016.
 */
public class TLSTable extends JPanel implements UpdateTabel {
    public static final String[] HEADER = new String[]{"ID", "Domain", "Parameter"};
    private Object[][] data;
    private DataTable table;

    public TLSTable() {
        setLayout(new BorderLayout());
        table = new DataTable(HEADER);
        table.updateTable(new Object[][]{{5, "Domain.tld", "params"}});
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
