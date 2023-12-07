import java.util.Scanner;

public class MineSweeper {
    private static final char MAYIN_KARAKTERI = '*';
    private static final char BOS_HUCRE = '-';
    private static final char ACILMAMIS_HUCRE = '+';

    private char[][] mayinTarlasi;
    private char[][] gosterilenTahminler;
    private int satirSayisi;
    private int sutunSayisi;
    private int kalanHucreSayisi;

    public MineSweeper(int satirSayisi, int sutunSayisi) {
        this.satirSayisi = satirSayisi;
        this.sutunSayisi = sutunSayisi;
        this.mayinTarlasi = new char[satirSayisi][sutunSayisi];
        this.gosterilenTahminler = new char[satirSayisi][sutunSayisi];
        this.kalanHucreSayisi = satirSayisi * sutunSayisi;

        initializeGameBoard();
        placeMines();
    }

    private void initializeGameBoard() {
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                mayinTarlasi[i][j] = BOS_HUCRE;
                gosterilenTahminler[i][j] = ACILMAMIS_HUCRE;
            }
        }
    }

    private void placeMines() {
        int mineCount = satirSayisi * sutunSayisi / 4;
        while (mineCount > 0) {
            int row = (int) (Math.random() * satirSayisi);
            int col = (int) (Math.random() * sutunSayisi);
            if (mayinTarlasi[row][col] != MAYIN_KARAKTERI) {
                mayinTarlasi[row][col] = MAYIN_KARAKTERI;
                mineCount--;
            }
        }
    }

    private void printGameBoard() {
        System.out.println("===========================");
        if (kalanHucreSayisi == satirSayisi * sutunSayisi - satirSayisi * sutunSayisi / 4) {
            System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        }
        printBoard(gosterilenTahminler);
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void makeMove(int row, int col) {
        // Kullanıcının girdiği değerleri bir azaltarak dizinin indisleriyle uyumlu hale
        // getirme
        row--;
        col--;

        if (row < 0 || row >= satirSayisi || col < 0 || col >= sutunSayisi) {
            System.out.println("Geçersiz bir hücre seçtiniz. Lütfen tekrar seçin.");
            return;
        }

        if (gosterilenTahminler[row][col] == ACILMAMIS_HUCRE) {
            gosterilenTahminler[row][col] = mayinTarlasi[row][col];
            kalanHucreSayisi--;

            if (mayinTarlasi[row][col] == MAYIN_KARAKTERI) {
                gameOver();
            } else {
                printGameBoard();
                if (kalanHucreSayisi == satirSayisi * sutunSayisi - satirSayisi * sutunSayisi / 4) {
                    gameWon();
                }
            }
        } else {
            System.out.println("Bu hücre zaten açıldı. Lütfen başka bir hücre seçin.");
        }
    }

    private void gameOver() {
        printGameBoard();
        System.out.println("Game Over!!");
        System.exit(0);
    }

    private void gameWon() {
        printGameBoard();
        System.out.println("Congratulations! You won the game!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satır Sayısını Giriniz: ");
        int satirSayisi = scanner.nextInt();

        System.out.print("Sütun Sayısını Giriniz: ");
        int sutunSayisi = scanner.nextInt();

        MineSweeper mineSweeper = new MineSweeper(satirSayisi, sutunSayisi);
        mineSweeper.printGameBoard();

        while (true) {
            System.out.print("Satır Giriniz: ");
            int row = scanner.nextInt();

            System.out.print("Sütun Giriniz: ");
            int col = scanner.nextInt();

            mineSweeper.makeMove(row, col);
        }
    }
}
