/*
 * Copyright (C) 2016 albritter
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package de.albritter.sql;

import de.albritter.sql.data.ADataObject;
import lombok.Setter;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by albritter on 04.06.16.
 */
public final class MySQLHandler {
    private static final String ADD_DOMAIN;
    private static final String ADD_MAILBOX;
    private static final String ADD_ALIAS;
    private static final String ADD_TLS;
    private static final String UPDATE_DOMAIN;
    private static final String UPDATE_MAILBOX;
    private static final String UPDATE_ALIAS;
    private static final String UPDATE_TLS;
    private static final String REMOVE_DOMAIN;
    private static final String REMOVE_MAILBOX;
    private static final String REMOVE_ALIAS;
    private static final String REMOVE_TLS;
    private static final String GET_DOMAIN;
    private static final String GET_MAILBOX;
    private static final String GET_ALIAS;
    private static final String GET_TLS;
    @Setter
    private static String password;
    @Setter
    private static String server;
    @Setter
    private static String user;
    @Setter
    private static String db;
    private static PreparedStatement preparedStatement;
    private static Connection conn;

    static {
        ADD_DOMAIN = "INSERT INTO domains (domain) VALUES (?)";
        ADD_MAILBOX = "INSERT INTO accounts (username, domain, password, quota, enabled, sendonly) VALUES (?,?,?,?,?,?)";
        ADD_ALIAS = "INSERT INTO aliases (source_username, source_domain, destination_username, destination_domain, enabled) VALUES (?,?,?,?,?)";
        ADD_TLS = "INSERT INTO tlspolicies (domain, policy, params) VALUES (?,?,?)";
        UPDATE_DOMAIN = "UPDATE domains SET domain=? WHERE id=?;";
        UPDATE_MAILBOX = "UPDATE accounts SET username=?, domain=?, password=?, quota=?, enabled=?, sendonly=? WHERE id=?;";
        UPDATE_ALIAS = "UPDATE aliases SET source_username=?, source_domain=?, destination_username=?, destination_domain=?, enabled=? WHERE id=?;";
        UPDATE_TLS = "UPDATE tlspolicies SET domain=?, policy=?, params=? WHERE id=?;";
        REMOVE_DOMAIN = "DELETE FROM domains where id=?;";
        REMOVE_MAILBOX = "DELETE FROM accounts where id=?;";
        REMOVE_ALIAS = "DELETE FROM aliases where id=?;";
        REMOVE_TLS = "DELETE FROM tlspolicies where id=?;";
        GET_DOMAIN = "SELECT * FROM domain;";
        GET_MAILBOX = "SELECT * FROM accounts;";
        GET_ALIAS = "SELECT * FROM aliases";
        GET_TLS = "SELECT * FROM tlspolicies";

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + db + "?requireSSL=true&serverTimezone=Europe/Berlin", user, password);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        try {
            return conn.isValid(500);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T extends ADataObject> void update(T data) {
        PreparedStatement preparedStatement = null;
        int idPos = -1;
        try {
            switch (data.getClass().getSimpleName()) {
                case "Domain":
                    preparedStatement = conn.prepareStatement(UPDATE_DOMAIN);
                    idPos = 2;
                    break;
                case "Mailbox":
                    preparedStatement = conn.prepareStatement(UPDATE_MAILBOX);
                    idPos = 7;
                    break;
                case "Aliases":
                    preparedStatement = conn.prepareStatement(UPDATE_ALIAS);
                    idPos = 6;
                    break;
                case "TLSPolicy":
                    preparedStatement = conn.prepareStatement(UPDATE_TLS);
                    idPos = 4;
                    break;
            }
            // preparedStatement = fill(preparedStatement, sData);
            preparedStatement.setInt(idPos, data.getId());
            fill(preparedStatement, data.getDataAsArray());
            preparedStatement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            try {


                preparedStatement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        }
    }

    public static <T extends ADataObject> void add(T data) {
        System.out.println("Add Statemnt");
        PreparedStatement preparedStatement = null;
        String[] sData = data.getDataAsArray();
        try {
            switch (data.getClass().getSimpleName()) {
                case "Domain":
                    preparedStatement = conn.prepareStatement(ADD_DOMAIN);
                    break;
                case "Mailbox":
                    preparedStatement = conn.prepareStatement(ADD_MAILBOX);
                    System.out.print(data.getDataAsArray());
                    break;
                case "Aliases":
                    preparedStatement = conn.prepareStatement(ADD_ALIAS);
                    break;
                case "TLSPolicy":
                    preparedStatement = conn.prepareStatement(ADD_TLS);
                    break;
                default:
                    System.out.print(data.getClass().getSimpleName());
            }
            fill(preparedStatement, sData).execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public static <T extends ADataObject> void remove(T data) {
        PreparedStatement preparedStatement = null;
        try {
            switch (data.getClass().getSimpleName()) {
                case "Domain":
                    preparedStatement = conn.prepareStatement(REMOVE_DOMAIN);
                    break;
                case "Mailbox":
                    preparedStatement = conn.prepareStatement(REMOVE_MAILBOX);
                    break;
                case "Aliases":
                    preparedStatement = conn.prepareStatement(REMOVE_ALIAS);
                    break;
                case "TLSPolicy":
                    preparedStatement = conn.prepareStatement(REMOVE_TLS);
                    break;
            }
            preparedStatement.setInt(1, data.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement fill(PreparedStatement preparedStatement, String[] data) throws SQLException {
        try {
            for (int i = 0; i < data.length; i++) {
                preparedStatement.setString(i + 1, data[i]);
                System.out.println("insert " + data[i]);
            }
        } catch (Exception e) {

        }
        return preparedStatement;
    }

    public static String[] getMailboxes() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            statement.execute(GET_MAILBOX);
            resultSet = statement.getResultSet();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getDomains() {
        Statement statement = null;
        ResultSet resultSet = null;
        return null;
    }

    public static String[] getAliases() {
        Statement statement = null;
        ResultSet resultSet = null;
        return null;
    }

    public static String[] getTlsPolicies() {
        Statement statement = null;
        ResultSet resultSet = null;
        return null;
    }
}
