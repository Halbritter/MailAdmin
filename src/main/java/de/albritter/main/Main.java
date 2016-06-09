package de.albritter.main;

import de.albritter.sql.MySQLHandler;

/**
 * Created by albritter on 08.06.16.
 */
public class Main {
    public static void main(String[] argv) {
        MySQLHandler.openConnection();
    }
}
