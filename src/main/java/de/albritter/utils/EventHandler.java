/*
 * This file is part of MailAdmin.
 *
 *     MailAdmin is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     MailAdmin is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with MailAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of VMail.
 *
 *     VMail is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     VMail is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.utils;

import de.albritter.gui.tables.DataTable;
import de.albritter.gui.tables.UpdateTabel;

import java.util.ArrayList;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public final class EventHandler {
    //   private static ArrayList<UseRadioSelection> useRadioSelection = new ArrayList<UseRadioSelection>();
    private static ArrayList<UpdateTabel> updateTabel = new ArrayList<UpdateTabel>();
    private static ArrayList<TableSelectionEvent> tableSelectionEvent = new ArrayList<TableSelectionEvent>();

   /* public static <T extends UseRadioSelection> void registerForRadioEvent(T obj) {
        useRadioSelection.add(obj);
    }*/

    public static <T extends UpdateTabel> void registerForUpdateTableEvent(T obj) {
        updateTabel.add(obj);
    }

    public static <T extends TableSelectionEvent> void registerForSelectionChangeEvent(T obj) {
        tableSelectionEvent.add(obj);
    }

/*    public static void radioAdd() {
        for (UseRadioSelection anUseRadioSelection : useRadioSelection) {
            anUseRadioSelection.selectAdd();
        }
    }

    public static void radioUpdate() {
        for (UseRadioSelection anUseRadioSelection : useRadioSelection) {
            anUseRadioSelection.selectUpdate();
        }
    }

    public static void radioRemove() {
        for (UseRadioSelection anUseRadioSelection : useRadioSelection) {
            anUseRadioSelection.selectRemove();
        }
    }*/

    public static void updateMailboxTable(Object[][] data) {
        for (UpdateTabel anUpdateTabel : updateTabel) {
            anUpdateTabel.updateMailboxTable(data);
        }
    }

    public static void updateAliasTable(Object[][] data) {
        for (UpdateTabel anUpdateTabel : updateTabel) {
            anUpdateTabel.updateAliasTable(data);
        }
    }

    public static void updateDomainTable(Object[][] data) {
        for (UpdateTabel anUpdateTabel : updateTabel) {
            anUpdateTabel.updateDomainTable(data);
        }
    }

    public static void updateTLSTable(Object[][] data) {
        for (UpdateTabel anUpdateTabel : updateTabel) {
            anUpdateTabel.updateTLSTable(data);
        }
    }

    public static void selectionCahnge(DataTable table) {
        System.out.println("Klick");
        for (TableSelectionEvent aTableSelectionEvent : tableSelectionEvent) {
            aTableSelectionEvent.selectionChange(table);
        }
    }
}
