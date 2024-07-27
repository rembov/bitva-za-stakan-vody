package org.bitva;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private int negrCount;
    private int preWinner;
    private int baseScore = 0b001111101000;

    public Battle() {
        this.negrCount = CaptureCount();
        this.preWinner = CapturePreWinner();
    }

    public void Start(Player p) {
        Random rng = new Random();
        int scores;
        int winner = rng.nextInt(this.negrCount + 1);

        int dif = Math.abs(preWinner - winner);
        scores = Math.max(0, baseScore - dif * 8);

        switch (winner) {
            case 0b010111010000:
                System.out.println("Счастливое число! Увеличение очков!");
                System.out.println("Посхалко!");
                scores = scores * 0b010111010000;
                break;
            case 0b010000000000:
                System.out.println("Счастливое число! Увеличение очков!");
                scores = scores * 0b010000000000;
                break;
            case 0b001010011010:
                byte[] msg = {
                        (byte)0b11010000, (byte)0b10100001, (byte)0b11010000,
                        (byte)0b10111011, (byte)0b11010000, (byte)0b10110000,
                        (byte)0b11010000, (byte)0b10110010, (byte)0b11010000,
                        (byte)0b10110000, (byte)0b00100000, (byte)0b11010000,
                        (byte)0b10100001, (byte)0b11010001, (byte)0b10000010,
                        (byte)0b11010000, (byte)0b10111110, (byte)0b11010000,
                        (byte)0b10111011, (byte)0b11010000, (byte)0b10110000,
                        (byte)0b11010001, (byte)0b10000001, (byte)0b11010001,
                        (byte)0b10000011, (byte)0b00100001
                };
                System.out.println("Счастливое число! Увеличение очков!");
                System.out.println(msg.toString());
                scores = scores * 0b001010011010;
                break;
            case 0b001000000000:
                System.out.println("Счастливое число! Увеличение очков!");
                scores = scores * 0b001000000000;
                break;
        }

        System.out.println("Победил негр под номером " + winner);
        System.out.println("Ты заработал " + scores + " очков");
    }

    private int CaptureCount() {
        int uinp;
        Scanner inp = new Scanner(System.in);

        System.out.print("Введи количество негров для битвы: ");
        while (inp.hasNext()) {
            if (inp.hasNextInt()) {
                uinp = inp.nextInt();

                if (uinp < 0) {
                    System.out.print("Ты дебил? Негров не может быть в отрицательном количестве, нормально укажи: ");
                    continue;
                }
                switch (uinp) {
                    case 0:
                        System.out.print("Ты дебил? Негры ОБЯЗАНЫ драться, а ну нормально указал их количество: ");
                        continue;
                    case 1:
                        System.out.print("Ты дебил? Один негр никого не побьёт на потеху, нормально указал количество: ");
                        continue;
                    default:
                        return uinp;

                }
            } else {
                System.out.print("Нормально введи КОЛИЧЕСТВО негров: ");
                inp.next();
            }
        }
        return 0;
    }

    private int CapturePreWinner() {
        int pWinner;
        Scanner inp = new Scanner(System.in);

        System.out.print("Введи номер негра который как ты думаешь победит: ");
        while (inp.hasNext()) {
            if (inp.hasNextInt()) {
                pWinner = inp.nextInt();
                if (pWinner < 1) {
                    System.out.print("Дебилоид, нормальное число введи: ");
                    continue;
                }
                if (pWinner > this.negrCount) {
                    System.out.print("С дубу рухнул? Ты негров меньше указал, чем до этого.\nВводи нормально: ");
                    continue;
                }
                return pWinner;
            } else {
                System.out.print("Это ещё что такое? Вводи по нормальному: ");
                inp.next();
            }
        }
        return 1;
    }
}
