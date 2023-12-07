import java.util.Scanner;

public class VucutKitleIndeksi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen boyunuzu giriniz (Örneğin; 1,75): ");
        while (!input.hasNextDouble()) {
            System.out.println("Geçerli bir sayı giriniz: ");
            input.next(); // Yanlış türdeki girişi temizle
        }
        double boy = input.nextDouble();

        System.out.println("Lütfen kilonuzu giriniz: ");
        while (!input.hasNextDouble()) {
            System.out.println("Geçerli bir sayı giriniz: ");
            input.next();
        }
        double kilo = input.nextDouble();

        double vucutKitleIndeksi = kilo / (boy * boy);

        System.out.println("Vücut Kitle İndeksiniz : " + vucutKitleIndeksi);

        input.close();
    }
}
