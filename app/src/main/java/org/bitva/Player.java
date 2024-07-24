package org.bitva;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public void SetName(String s) {
        this.name = s;
    }

    public String GetName() {
        return this.name;
    }

    public void SetScore(int s) {
        this.score = s;
    }

    public int GetScore() {
        return this.score;
    }

    public void AddScore() {
        this.score = this.score + 1;
    }

    public void AddScore(int i) {
        this.score = this.score + i;
    }

    public Player() {
        this.name = InputName();
        this.score = 0;
    }

    private String InputName() {
        Scanner inp = new Scanner(System.in);
        String name = new String();
        System.out.println("Введи своё имя");

        while (inp.hasNext()) {
            if (inp.hasNextLine()) {
                name = inp.nextLine();
                if (name.length() < 2) {
                    System.out.println("Введи своё имя");
                } else {
                    break;
                }
            } else {
                inp.next();
            }
        }
        return name;
    }
}