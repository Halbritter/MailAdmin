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
import de.albritter.sql.data.Aliases;
import de.albritter.sql.data.Domain;
import de.albritter.sql.data.Mailbox;
import de.albritter.sql.data.TLSPolicy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lombok.Setter;

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

    public static ArrayList<Mailbox> getMailboxes() {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Mailbox> mailboxArrayList = new ArrayList<Mailbox>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(GET_MAILBOX);
            while (resultSet.next()) {
                Mailbox m = new Mailbox();
                m.setId(resultSet.getInt(0));
                m.setUsername(resultSet.getString(1));
                m.setDomain(resultSet.getString(2));
                m.setPassword(resultSet.getString(3));
                m.setQuota(resultSet.getInt(4));
                m.setActive(resultSet.getBoolean(5) ? 1 : 0);
                m.setSendonly(resultSet.getInt(5));
                mailboxArrayList.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return mailboxArrayList;
    }

    public static ArrayList<Domain> getDomains() {
        ArrayList<Domain> domainArrayList = new ArrayList<Domain>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(GET_MAILBOX);
            while (resultSet.next()) {
                Domain d = new Domain();
                d.setId(resultSet.getInt(0));
                d.setDomain(resultSet.getString(1));
                domainArrayList.add(d);
            }
        } catch (SQLException e) {

        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {

            }
        }
        return domainArrayList;
    }

    public static ArrayList<Aliases> getAliases() {
        ArrayList<Aliases> aliasesArrayList = new ArrayList<Aliases>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(GET_MAILBOX);
            while (resultSet.next()) {
                Aliases a = new Aliases();
                a.setId(resultSet.getInt(0));
                a.setSourceUsername(resultSet.getString(1));
                a.setSourceDomain(resultSet.getString(2));
                a.setDestinationUsername(resultSet.getString(3));
                a.setDestinationDomain(resultSet.getString(4));
                a.setActive(resultSet.getInt(5));
                aliasesArrayList.add(a);
            }
        } catch (SQLException e) {

        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {

            }
        }
        return aliasesArrayList;
    }

    public static ArrayList<TLSPolicy> getTlsPolicies() {
        ArrayList<TLSPolicy> tlsPolicyArrayList = new ArrayList<TLSPolicy>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(GET_MAILBOX);
            while (resultSet.next()) {
                TLSPolicy t = new TLSPolicy();
                t.setId(resultSet.getInt(0));
                t.setDomain(resultSet.getString(1));
                t.setPolicy(resultSet.getString(2));
                tlsPolicyArrayList.add(t);
            }
        } catch (SQLException e) {

        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {

            }
        }
        return tlsPolicyArrayList;

    }
}
