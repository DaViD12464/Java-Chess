package Figury;

import Figury.Figura;

public class Krol extends Figura
{
    public int x;
    public int y;

    public String oznaczenie;

    public Boolean czywykonalruch = false;

    public Krol(int x, int y, String kolor)
    {
        this.x = x;
        this.y = y;
        if(kolor.equals("bialy"))
        {
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT + " K ") ;
        }
        if(kolor.equals("czarny"))
        {
            this.znak =(KoloryFigur.RED_BOLD + " K ") ;
        }
    }

    public void ruch()
    {
        System.out.println("ruszam się - Król");
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