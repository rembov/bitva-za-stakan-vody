package org.bitva;

public class Database {
//    private static final String url = "jdbc:mysql://localhost:3306/test";
//    private static final String user = "root";
//    private static final String password = "root";
    public void ShowPlayers() {
        String []players = {"Максим", "Чунгачгук", "Хохол", "Негр"};
        System.out.println("Игроки:");
        for (String player : players) {
            System.out.println(player);
        }
    }

}
