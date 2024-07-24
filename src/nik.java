import java.util.Scanner;

public class nik {
    public void imena() {
        Scanner vhod = new Scanner(System.in);
        System.out.println("Введите свой ник\n");//не забыть условие дописать
        String niki = vhod.nextLine();
        System.out.println("Ваш ник: " + niki);
    }
}
