package Figury;

import Figury.Figura;
import Kolory;

public class Hetman extends Figura
{
    public int x;
    public int y;
    public Hetman(int x, int y)
    {
        if(this.znak.contains(" ■ "))
        {
            this.znak = (Kolory.WHITE_BACKGROUND + " Q " + Kolory.RESET ); //dlaczego nie widzi klasy kolory?
        }
// dodac ifa dla przeciwnego koloru
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Hetman");
    }

    @Override
    public String getZnak() {
        return this.znak;
    }
}