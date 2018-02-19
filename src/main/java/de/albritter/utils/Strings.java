package de.albritter.utils;

public class Strings {
    public static final String HISTORY_DB;
    public static final String CREATE_SERVER_TABLE;

    static {
        HISTORY_DB = System.getProperty("user.home") + "/.mailadmin.db";
        CREATE_SERVER_TABLE = "CREATE TABLE Server (id integer PRIMARY KEY AUTOINCREMENT, server string, username string, dbname string)";


    }
}
