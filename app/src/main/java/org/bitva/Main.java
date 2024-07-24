package org.bitva;

public class Main {
    public static void main(String[] args) {
       logotip logo = new logotip();

        Gameplay game = new Gameplay();
       logo.logo();
       game.Start();
    }
}