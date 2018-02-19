package de.albritter.utils;

import lombok.Getter;
import lombok.NonNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Options {
    Connection conn = null;

    private static Options instance;

    public static Options getInstance() {
        if (instance == null) {
            try {
                instance = new Options();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private Options() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:" + Strings.HISTORY_DB);
        try {
            Statement s = conn.createStatement();
            s.execute("Select id from Server order by id asc;");
            ResultSet res = s.getResultSet();
        } catch (Exception e) {
            initDB();
        }
    }

    public void initDB() throws SQLException {
        Statement s = conn.createStatement();
        s.execute(Strings.CREATE_SERVER_TABLE);
        s.close();
    }


    @NonNull
    public HashMap<Integer, Profile> loadProfiles(){

        HashMap<Integer, Profile> profiles = new HashMap<>();

        Statement s = null;
        try {
            s = conn.createStatement();
            s.execute("Select id id, server server, dbname dbname, username username from Server order by id asc;");
            ResultSet res = s.getResultSet();
            while (res.next()) {
                Profile p = new Profile();
                p.setServer(res.getString("server"));
                p.setDbname(res.getString("dbname"));
                p.setUsername(res.getString("username"));
                p.setId(res.getInt("id"));
                profiles.put(p.getId(), p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public void saveProfile(@NonNull Profile p) {
        PreparedStatement s = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select count(*) from Server where server=?");
            ps.setString(1, p.getServer());
            ps.execute();
            ResultSet res = ps.getResultSet();
            res.next();
            System.out.println(res.getInt(1));
            if (res.getInt(1) <= 0) {
                s = conn.prepareStatement("insert into server (server,dbname,username) values(?,?,?);");
                s.setString(1, p.getServer());
                s.setString(2, p.getDbname());
                s.setString(3, p.getUsername());
                s.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void removeProfile(Profile p){
        try {
            PreparedStatement ps = conn.prepareStatement("delete from server where server = ?");
            ps.setString(1,p.getServer());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
