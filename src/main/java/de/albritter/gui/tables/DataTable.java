package de.albritter.gui.tables;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Created by albritter on 10.06.16.
 */
public class DataTable extends JTable {
    private static final long serialVersionUID = 1L;
    private String[] header;
    private Object[][] data;

    public DataTable(String[] header) {
        this.header = header;
        getTableHeader().setReorderingAllowed(false);
        setModel(new DefaultTableModel(data, header));
    }

    @Override
    public Class getColumnClass(int column) {
        String name = getColumnName(column);
        if (name.equals("ID") || name.equals("Quota")) {
            return Integer.class;
        } else if (name.equals("Active") || name.equals("Sendonly")) {
            return Boolean.class;
        } else return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void updateTable(Object[][] data) {
        this.data = data;
        setModel(new DefaultTableModel(data, header));
        for (int i = 0; i < header.length; i++) {
            switch (getColumnName(i)) {
                case "ID":
                case "Quota":
                    getColumnModel().getColumn(i).setMinWidth(45);
                    getColumnModel().getColumn(i).setPreferredWidth(45);
                    getColumnModel().getColumn(i).setMaxWidth(60);
                    break;
                case "Sendonly":
                case "Active":
                    getColumnModel().getColumn(i).setPreferredWidth(60);
                    getColumnModel().getColumn(i).setMaxWidth(60);
                    getColumnModel().getColumn(i).setMinWidth(60);
                    break;

            }
        }

    }


    public void setTableHeader() {
        this.header = header;


    }
}


