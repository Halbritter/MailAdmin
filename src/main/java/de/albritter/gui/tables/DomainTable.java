package de.albritter.gui.tables;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;


/**
 * Created by hhalbritter on 10.06.2016.
 */
public class DomainTable extends JPanel {
    private JTable table;

    public DomainTable() {
        setLayout(new BorderLayout());
        table = new DataTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {new Integer(2), "Domain.tld", false},
                        {null, null, false },
                        {null, null, true},
                        {null, null, true},
                        {null, null, true},
                        {null, null, null},
                        {null, null, true},
                },
                new String[]{
                        "ID", "Domain", "Active"
                }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        add(new JScrollPane(table));
    }
}
