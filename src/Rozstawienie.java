import Figury.*;

public abstract class Rozstawienie
{
    public static void rozstawFigury(String[][] szachownica)
    {
        szachownica[0][0] = new Wieza(0, 0, "bialy","Wieza_Biala_Lewa").getZnak(szachownica);
        szachownica[0][1] = new Kon(0, 1, "bialy", "Kon_Bialy_Lewy").getZnak(szachownica);
        szachownica[0][2] = new Goniec(0, 2, "bialy", "Goniec_Bialy_Lewy").getZnak(szachownica);
        szachownica[0][3] = new Hetman(0, 3, "bialy", "Hetman_Bialy").getZnak(szachownica);
        szachownica[0][4] = new Krol(0, 4, "bialy", "Krol_Bialy").getZnak(szachownica);
        szachownica[0][5] = new Goniec(0, 5, "bialy", "Goniec_Bialy_Prawy").getZnak(szachownica);
        szachownica[0][6] = new Kon(0, 6, "bialy","Kon_Bialy_Prawy").getZnak(szachownica);
        szachownica[0][7] = new Wieza(0, 7, "bialy","Wieza_Biala_Prawa").getZnak(szachownica);

        for (int i = 0; i < 8; i++) {
            szachownica[1][i] = new Pion(1, i, "bialy","Pion"+i).getZnak(szachownica);
        }


        //==============================================================
        // RÓŻNE STRONY SZACHOWNICY
        //==============================================================
        szachownica[7][0] = new Wieza(7, 0, "czarny", "Wieza_Czarna_Lewa").getZnak(szachownica);
        szachownica[7][1] = new Kon(7, 1, "czarny", "Kon_Czarny_Lewy").getZnak(szachownica);
        szachownica[7][2] = new Goniec(7, 2, "czarny", "Goniec_Czarny_Lewy").getZnak(szachownica);
        szachownica[7][3] = new Hetman(7, 3, "czarny", "Hetman_Czarny").getZnak(szachownica);
        szachownica[7][4] = new Krol(7, 4, "czarny", "Krol_Czarny").getZnak(szachownica);
        szachownica[7][5] = new Goniec(7, 5, "czarny", "Goniec_Czarny_Prawy").getZnak(szachownica);
        szachownica[7][6] = new Kon(7, 6, "czarny", "Kon_Czarny_Prawy").getZnak(szachownica);
        szachownica[7][7] = new Wieza(7, 7, "czarny", "Wieza_Czarna_Prawa").getZnak(szachownica);
        for (int j = 0; j < 8; j++) {
            szachownica[6][j] = new Pion(6, j, "czarny", "Pion"+j).getZnak(szachownica);
        }
    }
}
