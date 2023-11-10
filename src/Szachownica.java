import java.util.ArrayList;
import java.util.List;

public class Szachownica {
    int x = 1;
    int y = 1;
    List<Integer> wspolrzedne;
    boolean pionyRozstawione = false;

    public Szachownica() {
        rysujSzachownice();
    }

    char[][] szachownica = new char[8][8];
    char[] notacja = {'8', '7', '6', '5', '4', '3', '2', '1'};

    public void rysujSzachownice() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                szachownica[i][j] = (i + j) % 2 == 0 ? '■' : '□';
            }
        }
        printSzachownica();
    }

    public void printSzachownica() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(szachownica[i][j] + " ");
                if (j == 7) {
                    System.out.print(notacja[i]);
                }
            }
            System.out.println();
        }
        System.out.println("A B C D E F G H");
    }

    public void rozstawFiguryGraczy() {
        for (int i = 0; i < 8; i++) {
            Pion pionek = new Pion();
            System.out.print(pionek.getZnak() + " ");
        }
    }
}