package de.albritter.gui.tables;

import com.sun.istack.internal.NotNull;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Created by albritter on 10.06.16.
 */
public class DataTable extends JTable {
    private static final long serialVersionUID = 1L;
    private String[] header;
    private Object[][] data;

    public DataTable() {
        getTableHeader().setReorderingAllowed(false);

    }

    @Override
    public Class getColumnClass(int column) {
        if (getColumnCount() - 1 == column) {
            return Boolean.class;
        } else if (column == 0) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @NotNull
    public void updateTable(String[] header) {
        this.header = header;
        setModel(new DefaultTableModel(data, header));
    }

    public void setTableHeader(String[] header) {

        this.header = header;
        this. this = new DataTable();
    }
}


