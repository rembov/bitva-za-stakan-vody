package org.bitva;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       logotip logo = new logotip();

        Gameplay game = new Gameplay();
       logo.logo();
       game.Start();
    }
}