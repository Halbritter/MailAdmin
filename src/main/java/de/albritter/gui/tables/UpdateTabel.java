package de.albritter.gui.tables;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public interface UpdateTabel {
    void updateDomainTable(String[] header, Object[][] data);

    void updateMailboxTable(String[] header, Object[][] data);

    void updateAliasTable(String[] header, Object[][] data);

    void updateTLSTable(String[] header, Object[][] data);
}
