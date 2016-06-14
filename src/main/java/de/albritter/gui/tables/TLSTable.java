package de.albritter.gui.tables;

import javax.swing.JPanel;

/**
 * Created by hhalbritter on 14.06.2016.
 */
public class TLSTable extends JPanel implements UpdateTabel {
    public static final String[] HEADER = new String[]{};
    private Object[][] data;

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
