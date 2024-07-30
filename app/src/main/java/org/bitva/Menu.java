package org.bitva;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void Start() throws SQLException {
        Scanner inp = new Scanner(System.in);
        Player gaymer = new Player();
        System.out.println("Твой ник " + gaymer.GetName() + "\n");

        // Это уродливо, но должно работать как надо
        while (true) {
            System.out.println("""
                    |----------------------------------------------------|
                    |----------------------------------------------------|
                    |                        МЕНЮ                        |
                    |                                                    |
                    | 1. Начать режим битвы                              |
                    | 2. Начать поиск воды                               |
                    | 3. Посмотреть таблицу игроков                      |
                    | 4. Выйти из игры                                   |
                    |                                                    |
                    |----------------------------------------------------|
                    |----------------------------------------------------|""");

            int resp = captureInt(inp);
            switch (resp) {
                case 1:
                    StartBattle(gaymer, inp);
                    break;
                case 2:
                    StartWater(gaymer, inp);
                    break;
                case 3:
                    StartPoints(inp);
                    break;
                case 4:
                    return;
            }
        }
    }

    private void StartBattle(Player p, Scanner inp) throws SQLException {
        while (true) {
            System.out.println("""
                    |----------------------------------------------------|
                    |           Добро пожаловать в режим битвы           |
                    |    Выберите действие:                              |
                    |                                                    |
                    | 1. Начать битву                                    |
                    | 2. Выйти в предыдущее меню                         |
                    |                                                    |
                    |----------------------------------------------------|""");

            int resp = captureInt(inp);
            switch (resp) {
                case 1:
                    Battle battle = new Battle();
                    battle.Start(p);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void StartWater(Player p, Scanner inp) throws SQLException {
        while (true) {
            System.out.println("""
                    |----------------------------------------------------|
                    |        Добро пожаловать в режим поиска воды        |
                    |    Выберите действие:                              |
                    |                                                    |
                    | 1. Начать поиск                                    |
                    | 2. Выйти в предыдущее меню                         |
                    |                                                    |
                    |----------------------------------------------------|""");

            int resp = captureInt(inp);
            switch (resp) {
                case 1:
                    Water wt = new Water();
                    wt.Start(p);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void StartPoints(Scanner inp) throws SQLException {
        Database db = new Database();
        while (true) {
            System.out.println("""
                    |----------------------------------------------------|
                    |                    Лучшие игроки                   |
                    |    Выберите действие:                              |
                    |                                                    |
                    | 1. Очки режима битвы                               |
                    | 2. Очки режима поиска воды                         |
                    | 3. Выйти в предыдущее меню                         |
                    |                                                    |
                    |----------------------------------------------------|""");

            int resp = captureInt(inp);
            switch (resp) {
                case 1:
                    db.ShowRecordsBattle();
                    break;
                case 2:
                    db.ShowRecordsWater();
                    break;
                case 3:
                    return;
            }
        }
    }

    private int captureInt(Scanner inp) {
        int captured = 0;
        while (inp.hasNext()) {
            if (inp.hasNextInt()) {
                captured = inp.nextInt();
                break;
            } else {
                inp.next();
            }
        }
        return captured;
    }
}
