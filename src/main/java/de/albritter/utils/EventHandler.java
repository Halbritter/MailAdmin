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

import de.albritter.gui.tables.UpdateTabel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public final class EventHandler {
    private static ArrayList<UseRadioSelection> useRadioSelection = new ArrayList<UseRadioSelection>();
    private static ArrayList<UpdateTabel> updateTabel = new ArrayList<UpdateTabel>();

    public static <T extends UseRadioSelection> void registerForRadioEvent(T obj) {
        useRadioSelection.add(obj);
    }

    public static <T extends UpdateTabel> void registerForUpdateTableEvent(T obj) {
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
