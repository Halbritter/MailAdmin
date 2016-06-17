package de.albritter.gui.tables;

import java.util.EventListener;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public interface UpdateTabel extends EventListener {
    void updateDomainTable(Object[][] data);

    void updateMailboxTable(Object[][] data);

    void updateAliasTable(Object[][] data);

    void updateTLSTable(Object[][] data);
}
