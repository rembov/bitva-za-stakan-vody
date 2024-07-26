package org.bitva;

import java.sql.*;

public class Database {
    public Database() throws SQLException {
        try
            (
                    Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                    Statement st = con.createStatement()
            ) {
            st.execute("""
                 CREATE TABLE IF NOT EXISTS PLAYERS (NAME TEXT, SCORE INTEGER);""");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddRecord(String name, int score) {
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ) {
            st.execute("INSERT OR ABORT INTO PLAYERS (NAME,SCORE) VALUES ('" + name + "'," + score + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowRecords() {
        int size;
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ResultSet countRes = st.executeQuery("SELECT COUNT(*) FROM PLAYERS");
                ) {
            size = countRes.getInt(1);
            if (size == 0) {
                System.out.println("Упс! Тут пусто...\nНо ты можешь быть первым!");
                return;
            }
            ResultSet res = st.executeQuery("SELECT NAME,SCORE FROM PLAYERS LIMIT 10");
            while (countRes.next()) {
                System.out.println(res.getString("NAME") + " " + res.getInt("SCORE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
