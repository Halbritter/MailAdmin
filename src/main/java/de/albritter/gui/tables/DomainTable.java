package de.albritter.gui.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * Created by hhalbritter on 10.06.2016.
 */
public class DomainTable extends JPanel {
    private JTable table;

    //todo Gett Image rendering in table working
    public DomainTable() {
        ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("images/accepted-151153_640.png"));
        setLayout(new BorderLayout());
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {new Integer(2), "Domain.tld", ""},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[]{
                        "ID", "Domain", "Active"
                }
        ));
        table.setValueAt(new JLabel(ico), 0, 2);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        add(new JScrollPane(table));
    }
}
