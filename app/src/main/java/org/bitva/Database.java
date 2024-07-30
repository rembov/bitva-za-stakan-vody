package org.bitva;

import java.sql.*;
import java.util.Scanner;

public class Database {
    public Database() throws SQLException {
        try
            (
                    Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                    Statement st = con.createStatement()
            ) {
            st.execute("CREATE TABLE IF NOT EXISTS WATER_PLAYERS (NAME TEXT, SCORE INTEGER)");
            st.execute("CREATE TABLE IF NOT EXISTS BATTLE_PLAYERS (NAME TEXT, NCOUNT INTEGER, SCORE INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddRecordWater(String name, int score) {
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ) {
            st.execute("INSERT OR ABORT INTO WATER_PLAYERS (NAME,SCORE) VALUES ('" + name + "'," + score + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowRecordsWater() {
        int size;
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ResultSet countRes = st.executeQuery("SELECT COUNT(*) FROM WATER_PLAYERS");
                ) {
            size = countRes.getInt(1);
            if (size == 0) {
                System.out.println("Упс! Тут пусто...\nНо ты можешь быть первым!");
                return;
            }
            ResultSet res = st.executeQuery("SELECT NAME,SCORE FROM WATER_PLAYERS ORDER BY SCORE DESC LIMIT 10");
            while (countRes.next()) {
                System.out.println("ИМЯ: " + res.getString("NAME"));
                System.out.println("ОЧКИ: " + res.getInt("SCORE"));
                System.out.print("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddRecordBattle(Player p, int ncount) {
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ) {
            st.execute("INSERT OR ABORT INTO BATTLE_PLAYERS (NAME,NCOUNT,SCORE) VALUES ('" + p.GetName() + "'," + ncount + "," + p.GetScore() + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowRecordsBattle() {
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:./gamedata.db");
                Statement st = con.createStatement();
                ResultSet rcnt = st.executeQuery("SELECT COUNT(*) FROM BATTLE_PLAYERS");
                ) {
            int cnt = rcnt.getInt(1);
            if (cnt == 0) {
                System.out.println("Упс! Тут пусто...\nНо ты можешь быть первым!");
                return;
            }
            ResultSet table = st.executeQuery("SELECT NAME,NCOUNT,SCORE FROM BATTLE_PLAYERS ORDER BY NCOUNT DESC,SCORE LIMIT 10");
            while (table.next()) {
                System.out.println("ИМЯ: " + table.getString("NAME"));
                System.out.println("НЕГРОВ: " + table.getInt("NCOUNT"));
                System.out.println("ОЧКИ: " + table.getInt("SCORE"));
                System.out.print("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
