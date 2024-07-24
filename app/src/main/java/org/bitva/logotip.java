package org.bitva;

public class logotip {
    public void logo() {

        System.out.println("|--------------------------------|");
        System.out.println("|                                |");
        System.out.println("|              БИТВА             |");
        System.out.println("|               ЗА               |");
        System.out.println("|              СТАКАН            |");
        System.out.println("|              ВОДЫ              |");
        System.out.println("|                                |");
        System.out.println("|--------------------------------|");
        try {
            Thread.sleep(1000); // Задержка в 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

