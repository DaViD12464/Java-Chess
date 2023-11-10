import Figury.*;

public abstract class Rozstawienie
{
    public static void rozstawFigury(String[][] szachownica)
    {

        szachownica[0][0] = new Wieza(0, 0).getZnak();
        szachownica[0][1] = new Kon(0, 2).getZnak();
        szachownica[0][2] = new Goniec(0, 1).getZnak();
        szachownica[0][3] = new Hetman(0, 3).getZnak();
        szachownica[0][4] = new Krol(0, 4).getZnak();
        szachownica[0][5] = new Goniec(0, 5).getZnak();
        szachownica[0][6] = new Kon(0, 6).getZnak();
        szachownica[0][7] = new Wieza(0, 7).getZnak();

        for (int j = 0; j < 8; j++) {
            szachownica[1][j] = new Pion(1, j).getZnak();
        }
    }
}
