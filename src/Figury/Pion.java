package Figury;

import Figury.Figura;

public class Pion extends Figura
{
    public int x;
    public int y;
    public String kolor;

    public String oznaczenie;

    public Pion(int x, int y, String kolor)
    {
        this.x = x;
        this.y = y;
        if(kolor.equals("bialy"))
        {
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT + " O ") ;
        }
        if(kolor.equals("czarny"))
        {
            this.znak =(KoloryFigur.RED_BOLD_BRIGHT + " O ") ;
        }
    }

    public void ruch()
    {
        System.out.println("ruszam się - Pion");
    }

    @Override
    public String getZnak(String[][] szachownica) {
        if(szachownica[x][y].contains(" ■ "))
        {
            oznaczenie = (KoloryFigur.WHITE_BACKGROUND + this.znak + KoloryFigur.RESET );
        }
        if(szachownica[x][y].contains(" □ "))
        {
            oznaczenie = (KoloryFigur.BLACK_BACKGROUND + this.znak + KoloryFigur.RESET );
        }

        return oznaczenie;
    }

}