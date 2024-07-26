package org.bitva;

import java.util.Scanner;

public class Gameplay {
    private int gameMode = 0;
    private int battleMode = 0;
    public void Start() {
        Scanner inp = new Scanner(System.in);
        Player gaymer = new Player();
        System.out.println("Твой ник " + gaymer.GetName() + "\n");

        System.out.println("""
                Выбирай:
                1. Начать игру
                2. Выйти""");
        System.out.print("Номер пункта: ");

        this.gameMode = captureInt(inp);

        switch (this.gameMode) {
            case 1:
                BattleModeCheck(gaymer, inp);
                break;
            default:
                System.exit(0);
                break;
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

    private void BattleModeCheck(Player p, Scanner inp) {
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
        do {
            this.battleMode = captureInt(inp);
        } while (this.battleMode < 1 || this.battleMode > 3);

        switch (this.battleMode) {
            case 1:
                int count = 0;
                bitva battle = new bitva();
                while (true) {
                    System.out.print("Введи количество негров для битвы: ");
                    count = captureInt(inp);
                    if (count < 0) {
                        System.out.println("Ты дебил? Негров не может быть в отрицательном количестве.");
                    }
                    if (count == 0) {
                        System.out.println("Приятно было сыграть.");
                        break;
                    }
                    if (count == 1) {
                        System.out.println("Ты дебил? Один негр всегда побеждает нуль врагов.");
                    }
                    battle.bit(count);
                }
                break;
            case 2:
                Water wt = new Water();
                wt.Start(p);
                break;
            case 3:
                Database db = new Database();
                db.ShowPlayers();
                break;
            default:
                System.exit(0);
        }
    }
}
