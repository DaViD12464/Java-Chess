package Figury;

import Figury.Figura;

public class Kon extends Figura
{
    public int x;
    public int y;

    public String oznaczenie;

    public Kon(int x, int y, String kolor)
    {
        this.x = x;
        this.y = y;
        if(kolor.equals("bialy"))
        {
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT + " ♞ ") ;
        }
        if(kolor.equals("czarny"))
        {
<<<<<<< HEAD
            this.znak =(KoloryFigur.RED_BOLD_BRIGHT + " ♞ ") ;
=======
            this.znak =(KoloryFigur.RED_BOLD + " N ") ;
>>>>>>> 3d82ada9e74b123d28d33998a1834f8ac0f5641d
        }
    }

    public void ruch()
    {
        System.out.println("ruszam się - Koń");
    }

    @Override
    public String getZnak(String[][] szachownica) {
        if(szachownica[x][y].contains("_ _"))
        {
            oznaczenie = (KoloryFigur.WHITE_BACKGROUND + this.znak + KoloryFigur.RESET );
        }
        if(szachownica[x][y].contains(" _ "))
        {
            oznaczenie = (KoloryFigur.BLACK_BACKGROUND + this.znak + KoloryFigur.RESET );
        }

        return oznaczenie;
    }
}