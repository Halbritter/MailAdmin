package de.albritter.utils;

import com.sun.istack.internal.NotNull;
import de.albritter.gui.tables.UpdateTabel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public final class EventHandler {
    private static ArrayList<UseRadioSelection> useRadioSelection = new ArrayList<UseRadioSelection>();
    private static ArrayList<UpdateTabel> updateTabel = new ArrayList<UpdateTabel>();

    @NotNull
    public static <T extends UseRadioSelection> void registerForRadioEvent(T obj) {
        useRadioSelection.add(obj);
    }

    @NotNull
    public static <T extends UpdateTabel> void registerForUpdateTableEvent(@NotNull T obj) {
        updateTabel.add(obj);
    }

    public static void radioAdd() {
        Iterator<UseRadioSelection> ite = useRadioSelection.iterator();
        while (ite.hasNext()) {
            ite.next().selectAdd();
        }
    }

    public static void radioUpdate() {
        Iterator<UseRadioSelection> ite = useRadioSelection.iterator();
        while (ite.hasNext()) {
            ite.next().selectUpdate();
        }
    }

    public static void radioRemove() {
        Iterator<UseRadioSelection> ite = useRadioSelection.iterator();
        while (ite.hasNext()) {
            ite.next().selectRemove();
        }
    }

    public static void updateMailboxTable(Object[][] data) {
        Iterator<UpdateTabel> ite = updateTabel.iterator();
        while (ite.hasNext()) {
            ite.next().updateMailboxTable(data);
        }
    }

    public static void updateAliasTable(Object[][] data) {
        Iterator<UpdateTabel> ite = updateTabel.iterator();
        while (ite.hasNext()) {
            ite.next().updateAliasTable(data);
        }
    }

    public static void updateDomainTable(Object[][] data) {
        Iterator<UpdateTabel> ite = updateTabel.iterator();
        while (ite.hasNext()) {
            ite.next().updateDomainTable(data);
        }
    }

    public static void updateTLSTable(Object[][] data) {
        Iterator<UpdateTabel> ite = updateTabel.iterator();
        while (ite.hasNext()) {
            ite.next().updateTLSTable(data);
        }
    }
}
