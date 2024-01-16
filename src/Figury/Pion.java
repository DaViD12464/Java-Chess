package Figury;

import Figury.Figura;

public class Pion extends Figura
{
    public int x;
    public int y;

    public String oznaczenie;

    public Pion(int x, int y, String kolor, String nazwa)
    {
        this.x = x;
        this.y = y;
        if(kolor.equals("bialy"))
        {
            this.znak =(KoloryFigur.WHITE_BOLD_BRIGHT + " ♟ ") ;
        }
        if(kolor.equals("czarny"))
        {
<<<<<<< HEAD
            this.znak =(KoloryFigur.RED_BOLD_BRIGHT + " ♟ ") ;
=======
            this.znak =(KoloryFigur.RED_BOLD + " O " ) ;
>>>>>>> 3d82ada9e74b123d28d33998a1834f8ac0f5641d
        }
    }


    public static void ruch(int Nx, int Ny, String nazwa)
    { //1. odczyt szachownicy - pozyskanie pol
        // Szachownica.GetPositions() -- zwrocic pozycje wszystkich figur na planszy
        //2. sprawdzanie dostepnosci ruchu dla danej figury
        //3. aktualizacja szachownicy / invalid move
       // Szachownica.PrzesunFigure()

    }

    public static void bicie(int Nx, int Ny, String nazwa)
    {

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