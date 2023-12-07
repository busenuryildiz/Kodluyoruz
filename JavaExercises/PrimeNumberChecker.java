public class PrimeNumberChecker {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Sayı Giriniz : ");
        int userInput = Integer.parseInt(System.console().readLine());
        
        if (isPrime(userInput)) {
            System.out.println(userInput + " sayısı ASALDIR!");
        } else {
            System.out.println(userInput + " sayısı ASAL değildir!");
        }
         main(args);
    }
}