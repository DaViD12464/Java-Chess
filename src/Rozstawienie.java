import Figury.*;

public abstract class Rozstawienie
{
    public static void rozstawFigury(String[][] szachownica)
    {

        szachownica[0][0] = new Wieza(0, 0, "bialy").getZnak(szachownica);
        szachownica[0][1] = new Kon(0, 1, "bialy").getZnak(szachownica);
        szachownica[0][2] = new Goniec(0, 2, "bialy").getZnak(szachownica);
        szachownica[0][3] = new Hetman(0, 3, "bialy").getZnak(szachownica);
        szachownica[0][4] = new Krol(0, 4, "bialy").getZnak(szachownica);
        szachownica[0][5] = new Goniec(0, 5, "bialy").getZnak(szachownica);
        szachownica[0][6] = new Kon(0, 6, "bialy").getZnak(szachownica);
        szachownica[0][7] = new Wieza(0, 7, "bialy").getZnak(szachownica);
        for (int i = 0; i < 8; i++) {
            szachownica[1][i] = new Pion(1, i, "bialy").getZnak(szachownica);
        }
        //==============================================================
        // RÓŻNE STRONY SZACHOWNICY
        //==============================================================
        szachownica[7][0] = new Wieza(7, 0, "czarny").getZnak(szachownica);
        szachownica[7][1] = new Kon(7, 1, "czarny").getZnak(szachownica);
        szachownica[7][2] = new Goniec(7, 2, "czarny").getZnak(szachownica);
        szachownica[7][3] = new Hetman(7, 3, "czarny").getZnak(szachownica);
        szachownica[7][4] = new Krol(7, 4, "czarny").getZnak(szachownica);
        szachownica[7][5] = new Goniec(7, 5, "czarny").getZnak(szachownica);
        szachownica[7][6] = new Kon(7, 6, "czarny").getZnak(szachownica);
        szachownica[7][7] = new Wieza(7, 7, "czarny").getZnak(szachownica);
        for (int j = 0; j < 8; j++) {
            szachownica[6][j] = new Pion(6, j, "czarny").getZnak(szachownica);
        }
    }
}
