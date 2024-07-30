package org.bitva;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       logotip logo = new logotip();

       Menu game = new Menu();
       logo.logo();
       game.Start();
    }
}