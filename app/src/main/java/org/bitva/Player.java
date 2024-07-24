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

        while (true) {
            if (!inp.hasNextLine()) {
                System.out.println("Введи своё имя");
                if (inp.hasNext()) {
                    inp.next();
                } else {
                    return "Игрок";
                }
            } else {
                name = inp.nextLine();
                if (name.isEmpty()) {
                    name = "Игрок";
                }
                break;
            }
        }
        return name;
    }
}