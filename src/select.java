import java.util.Scanner;

public class select {
    public int k;
    public void vibor() {

        bitva voina = new bitva();
        Scanner vhod = new Scanner(System.in);
        nik imya = new nik();
        if (k == 0) {
            imya.imena();
        }

        System.out.println("Выберите нужный пункт:\n" +
                "1.Начать игру\n" +
                "2.Список игроков\n");
        System.out.print("Введите нужное число в строку:  ");
        int a = vhod.nextInt();

        switch (a) {
            case 1:
                while (true) {

                    System.out.print("Введите количество негров (чтобы выйти напишите 328984):  ");
                    int b = vhod.nextInt();
                    //vhod.close();
                    if (b == 328984) {
                        k += 1;
                        break;
                    } else {
                        voina.bit(b);
                    }
                }
                vibor();
            case 2:
                k += 1;
                System.out.println("Список негров:\n");
                vibor();

        }
    }


}
