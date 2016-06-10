package de.albritter.utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public class EventHandler {
    private static ArrayList<UseRadioSelection> useRadioSelection = new ArrayList<UseRadioSelection>();


    public static <T extends UseRadioSelection> void registerForRadioAdd(T obj) {
        useRadioSelection.add(obj);
    }


    public static void radioAdd() {
        Iterator<UseRadioSelection> ite = useRadioSelection.iterator();
        while (ite.hasNext()) {
            ite.next().selectAdd();
        }
    }

    public static void radioUpadte() {
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

}
