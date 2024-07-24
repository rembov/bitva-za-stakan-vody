package org.bitva;

import java.util.Random;
public class bitva {
    public void bit(int n) {
        if (n == 1) {
            System.out.println("Дурак? Битвы не будет " + n + " негр победил");
            return;
        }
        if (n < 1) {
            System.out.println("Дурак? Негров не может быть 0 или меньше 0 .");
            return;
        }
        igra_veroyat(n);
    }
    public void igra_veroyat(int n) {
        Random rnd = new Random();
        int negr = rnd.nextInt(n) + 1;
        System.out.println("Победил негр № " + negr);
        if (negr == 0x5D0) {
            System.out.println("Посхалко");
        }
    }
}
