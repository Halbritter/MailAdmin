package de.albritter.gui.tables;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public interface UpdateTabel {
    void updateDomainTable(Object[][] data);

    void updateMailboxTable(Object[][] data);

    void updateAliasTable(Object[][] data);

    void updateTLSTable(Object[][] data);
}
