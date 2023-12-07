import java.util.Scanner;

public class MaxMinSayi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Kaç tane sayı gireceksiniz: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Hatalı Veri Girdiniz !");
            input.close();
            return;
        }

        int[] sayilar = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". Sayıyı giriniz: ");
            sayilar[i] = input.nextInt();
        }

        int minSayi = sayilar[0];
        int maxSayi = sayilar[0];

        for (int sayi : sayilar) {
            if (sayi < minSayi) {
                minSayi = sayi;
            }

            if (sayi > maxSayi) {
                maxSayi = sayi;
            }
        }

        System.out.println("En büyük sayı: " + maxSayi);
        System.out.println("En küçük sayı: " + minSayi);

        input.close();
    }
}