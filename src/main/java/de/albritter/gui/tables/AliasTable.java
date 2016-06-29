package de.albritter.gui.tables;

import de.albritter.utils.EventHandler;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by hhalbritter on 14.06.2016.
 */
public class AliasTable extends JPanel implements UpdateTabel {
    public final static String[] HEADER = new String[]{"ID", "Incoming User", "Incoming Domain", "Destination User", "Destination Domain", "Active"};
    private DataTable table;

    public AliasTable() {
        EventHandler.registerForUpdateTableEvent(this);
        setLayout(new BorderLayout());
        table = new DataTable(HEADER);
        table.updateTable(new Object[][]{{422224, "usadsdsadrIn", "doasdsadmainIn", "usasdsaderOut", "asdasd", false}});

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
        table.updateTable(data);

    }

    @Override
    public void updateTLSTable(Object[][] data) {

    }
}
