import java.util.List;

public class Szachownica {
    int x = 1;
    int y = 1;

    public Szachownica()
    {
        printSzachownica();
    }

    char[][] szachownica = new char[8][8];
    char[] notacja = {'8', '7', '6', '5', '4', '3', '2', '1'};


    public void printSzachownica() {
        System.out.print("--------------------\n");
        System.out.print("  A B C D E F G H\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(notacja[i] + " ");
            for (int j = 0; j < 8; j++) {
                szachownica[i][j] = (i + j) % 2 == 0 ? '■' : '□';
                System.out.print(szachownica[i][j] + " ");
                if (j == 7) {
                    System.out.print(notacja[i]);

                }
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
        System.out.print("--------------------\n");
    }
}