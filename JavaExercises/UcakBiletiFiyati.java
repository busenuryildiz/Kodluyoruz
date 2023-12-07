import java.util.Scanner;

public class UcakBiletiFiyati {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen mesafeyi (KM) giriniz : ");
        double mesafe = input.nextDouble();

        System.out.println("Lütfen yaşınızı giriniz : ");
        int yas = input.nextInt();

        System.out.println("Lütfen yolculuk tipini giriniz (1 - Tek Yön, 2 - Gidiş-Dönüş) : ");
        int yolculukTipi = input.nextInt();

        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            input.close();
            return;
        }

        double toplamUcret = mesafe * 0.10;

        if (yas <= 12) {
            toplamUcret -= toplamUcret * 0.50;
        } else if (yas >= 13 && yas <= 24) {
            toplamUcret -= toplamUcret * 0.10;
        } else if (yas >= 65) {
            toplamUcret -= toplamUcret * 0.30;
        }

        if (yolculukTipi == 2) {
            toplamUcret -= toplamUcret * 0.20;
        }

        System.out.println("Toplam Uçak Bileti Fiyatı : " + toplamUcret + " TL");

        input.close();
    }
}