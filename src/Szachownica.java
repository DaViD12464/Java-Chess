import java.util.Scanner;

public class Szachownica {

    public Szachownica()
    {
        printSzachownica();
    }

    String[][] szachownica = new String[8][8];
    char[] notacja = {'1', '2', '3', '4', '5', '6', '7', '8'};

    public String[][] getSzachownica()
    {
        return szachownica;
    }

    public void printSzachownica() {
        System.out.print("------------------------------\n");
        System.out.print("   A  B  C  D  E  F  G  H\n");
        for (int i = 7; i >= 0; i--) {
            System.out.print(notacja[i] + " ");
            for (int j = 0; j < 8; j++) {
                szachownica[i][j] = (i + j) % 2 == 0 ? (Kolory.WHITE_BACKGROUND+ "_ _" + Kolory.RESET) : (Kolory.BLACK_BACKGROUND+" _ "+ Kolory.RESET);
                System.out.print(szachownica[i][j]);
                if (j == 7) {
                    System.out.print(" " + notacja[i]);
                }
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.print("------------------------------\n");
    }

    public void wyswietl() {
        System.out.print("------------------------------\n");
        System.out.print("   A  B  C  D  E  F  G  H\n");
        for (int i = 7; i >= 0; i--) {
            System.out.print(notacja[i] + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(szachownica[i][j]);
                if (j == 7) {
                    System.out.print(" " + notacja[i]);
                }
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.print("------------------------------\n");
    }

    private int convertFileToIndex(char file) {
        // Convert the file character (e.g., 'a', 'b', 'c') to the corresponding array index
        return file - 'a';

    public void ustawPole(String figura, int x, int y)
    {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7)
        {
            szachownica[x][y] = (x + y) % 2 == 0 ? (Kolory.WHITE_BACKGROUND+ figura + Kolory.RESET) : (Kolory.BLACK_BACKGROUND+ figura + Kolory.RESET);
        } else
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.YELLOW_BOLD_BRIGHT +"Błąd: Próba ustawienia figury poza zakresem planszy."+Kolory.RESET);
        }
    }

    public void starePole(String figura, int x, int y)
    {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7)
        {
            szachownica[x][y] = (x + y) % 2 == 0 ? (Kolory.WHITE_BACKGROUND+ "_ _" + Kolory.RESET) : (Kolory.BLACK_BACKGROUND+" _ "+ Kolory.RESET);
        } else
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.YELLOW_BOLD_BRIGHT +"Błąd: Próba ustawienia figury poza zakresem planszy."+Kolory.RESET);
        }

    }
}