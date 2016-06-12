package de.albritter.gui.tables;

import javax.swing.JTable;

/**
 * Created by albritter on 10.06.16.
 */
public class DataTable extends JTable {
    private static final long serialVersionUID = 1L;

    @Override
    public Class getColumnClass(int column) {
        System.out.print(column + " " + getColumnCount() + "\n");
        if (2 == column) {
            return Boolean.class;
        } else if (column == 0) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    public DataTable() {
        getTableHeader().setReorderingAllowed(false);
    }
}


