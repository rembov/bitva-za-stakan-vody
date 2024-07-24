package org.bitva;

import java.util.Scanner;

public class select {
    public void vibor() {
        bitva voina = new bitva();
        Scanner vhod = new Scanner(System.in);
        Player gaymer = new Player();
        System.out.print("Твой ник " + gaymer.GetName() + "\n");

        System.out.println("Выберите нужный пункт:\n" +
                "1.Начать игру\n" +
                "2.Список игроков\n");
        System.out.print("Введите нужное число в строку: ");
        int a = vhod.nextInt();

        switch (a) {
            case 1:
                while (true) {
                    System.out.print("Введите количество негров (чтобы выйти напишите 328984):  ");
                    int b = vhod.nextInt();
                    if (b == 328984) {
                        break;
                    } else {
                        voina.bit(b);
                    }
                }
                vibor();
            case 2:
                System.out.println("Список негров:\n");
                // Зачем?
                // vibor();
        }
    }


}
