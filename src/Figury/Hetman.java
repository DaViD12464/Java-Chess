package Figury;

import Figury.Figura;

public class Hetman extends Figura
{
    public int x;
    public int y;
    public String oznaczenie;

    public Hetman(int x, int y, String kolor, String nazwa)
    {
        this.x = x;
        this.y = y;
        if(kolor.equals("bialy"))
        {
<<<<<<< HEAD
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT + " ♛ ") ;
        }
        if(kolor.equals("czarny"))
        {
            this.znak =(KoloryFigur.RED_BOLD_BRIGHT + " ♛ ") ;
=======
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT+ " Q ") ;
        }
        if(kolor.equals("czarny"))
        {
            this.znak =(KoloryFigur.RED_BOLD + " Q ") ;
>>>>>>> 3d82ada9e74b123d28d33998a1834f8ac0f5641d
        }
    }

    public static void ruch()
    {
        System.out.println("ruszam się - Hetman");
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