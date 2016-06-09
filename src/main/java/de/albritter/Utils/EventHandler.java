package de.albritter.Utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public class EventHandler {
    private static ArrayList<UseRadioSelection> useRadioSelectionsAdd = new ArrayList<UseRadioSelection>();
    private static ArrayList<UseRadioSelection> useRadioSelectionsUpdate = new ArrayList<UseRadioSelection>();
    private static ArrayList<UseRadioSelection> useRadioSelectionsRemove = new ArrayList<UseRadioSelection>();

    public static <T extends UseRadioSelection> void registerForRadioAdd(T obj) {
        useRadioSelectionsUpdate.add(obj);
    }

    public static <T extends UseRadioSelection> void registerForRadioUpdate(T obj) {
        useRadioSelectionsUpdate.add(obj);
    }

    public static <T extends UseRadioSelection> void registerForRadioRemove(T obj) {
        useRadioSelectionsUpdate.add(obj);
    }

    public static void radioAdd() {
        Iterator<UseRadioSelection> ite = useRadioSelectionsAdd.iterator();
        while (ite.hasNext()) {
            ite.next().selectAdd();
        }
    }

    public static void radioUpadte() {
        Iterator<UseRadioSelection> ite = useRadioSelectionsUpdate.iterator();
        while (ite.hasNext()) {
            ite.next().selectUpdate();
        }
    }

    public static void radioRemove() {
        Iterator<UseRadioSelection> ite = useRadioSelectionsRemove.iterator();
        while (ite.hasNext()) {
            ite.next().selectRemove();
        }
    }

}
