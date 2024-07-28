package org.bitva;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Water {
    private int randX;
    private int randY;
    private int tries = 1;
    private boolean xSolved = false;
    private boolean ySolved = false;
    private int baseScore = 1000;

    public Water() {
        Random rng = new Random();
        randX = rng.nextInt(101);
        randY = rng.nextInt(101);
    }

    public void Start(Player p) throws SQLException {
        System.out.println("""
                Сейчас мы сыграем в игру...
                
                Твоя задача - отгадать координаты с местонахождением воды.
                За правильный ответ ты получишь очки, но помни, что с каждой
                ошибкой твои баллы уменьшаются...
                
                Удачи.""");
        GuessX(p);
        p.SetScore(
                this.baseScore - (this.tries - 1) * 50
        );
        System.out.println("Ты сделал " + this.tries + " попыток.");
        System.out.println("Ты заработал " + p.GetScore() + " очков.");
        Database db = new Database();
        db.AddRecordWater(p.GetName(), p.GetScore());
    }

    private void GuessX(Player p) {
        System.out.println("Сейчас тебе придётся отгадать координату Х");
        while (!this.xSolved) {
            this.xSolved = Guesser(this.xSolved, this.randX);
        }
        System.out.println("Сейчас тебе придётся отгадать координату Y");
        while (!this.ySolved) {
            this.ySolved = Guesser(this.ySolved, this.randY);
        }
    }

    private boolean Guesser(boolean indicator, int target) {
        int resp;
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext() && !indicator) {
            if (inp.hasNextInt()) {
                resp = inp.nextInt();
                if (isThisIt(resp, target)) {
                    return true;
                }
            } else {
                System.out.println("Это должно быть число!");
                inp.next();
            }
        }
        return false;
    }

    private boolean isThisIt(int guesser, int target) {
        if (guesser < target) {
            System.out.println("Маловато будет...");
            this.tries = this.tries + 1;
            return false;
        }
        if (guesser > target) {
            System.out.println("Что-то ты перегнул, чёрный брат...");
            this.tries = this.tries + 1;
            return false;
        }
        System.out.println("ВО, то что ты искал.");
        return true;
    }
}
