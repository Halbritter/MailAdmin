package de.albritter.utils;

import java.util.EventListener;

/**
 * Created by hhalbritter on 09.06.2016.
 */
public interface UseRadioSelection extends EventListener {
    void selectAdd();

    void selectUpdate();

    void selectRemove();
}
