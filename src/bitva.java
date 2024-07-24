import java.util.Random;
public class bitva {
    public void bit(int n) {
        if (n == 1) {
            System.out.println("Дурак? Битвы не будет   " + n + "   негр победил");
        } else if (n > 1) {
            Random rnd = new Random();
            int negr = rnd.nextInt(n) + 1;
            System.out.println("Победил негр № " + negr);
        } else {
            System.out.println("Дурак? Негров не может быть 0 или меньше 0 .");

        }
    }
     public void igra_veroyat(int n){
        Random rnd = new Random();
            int negr = rnd.nextInt(n) + 1;
            System.out.println("Победил негр № " + negr);
     }
}
