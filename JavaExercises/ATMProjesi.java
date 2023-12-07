import java.util.Scanner;

public class ATMProjesi {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int balance = 1500;
        int select;

        while (right > 0) {
            System.out.print("Kullanıcı Adınız: ");
            userName = input.nextLine();
            System.out.print("Parolanız: ");
            password = input.nextLine();

            if (userName.equals("busenur") && password.equals("123456")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");

                do {
                    System.out.println("1-Para Yatırma\n" +
                                       "2-Para Çekme\n" +
                                       "3-Bakiye Sorgula\n" +
                                       "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
                    select = input.nextInt();

                    if (select == 1) {
                        System.out.print("Para miktarı: ");
                        int price = input.nextInt();
                        balance += price;
                        System.out.println("Yeni bakiyeniz: " + balance);
                    } else if (select == 2) {
                        System.out.print("Para miktarı: ");
                        int price = input.nextInt();
                        if (price > balance) {
                            System.out.println("Bakiye yetersiz.");
                        } else {
                            balance -= price;
                            System.out.println("Yeni bakiyeniz: " + balance);
                        }
                    } else if (select == 3) {
                        System.out.println("Bakiyeniz: " + balance);
                    } else if (select != 4) {
                        System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    }

                } while (select != 4);

                System.out.println("Tekrar görüşmek üzere.");
                break;
            } else {
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur. Lütfen banka ile iletişime geçiniz.");
                } else {
                    System.out.println("Kalan Hak: " + right);
                }
            }
        }

        // Scanner'ı kapat
        input.close();
    }
}
