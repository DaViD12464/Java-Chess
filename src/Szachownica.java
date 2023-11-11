
public class Szachownica {
    int x = 1;
    int y = 1;

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
                szachownica[i][j] = (i + j) % 2 == 0 ? (Kolory.WHITE_BACKGROUND+ " ■ " + Kolory.RESET) : (Kolory.BLACK_BACKGROUND+" □ "+ Kolory.RESET);
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
}