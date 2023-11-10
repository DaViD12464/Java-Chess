package Figury;

import Figury.Figura;

public class Wieza extends Figura
{
    public int x;
    public int y;

    public Wieza(int x, int y)
    {
        this.znak = " R ";
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Wieża");
    }

    @Override
    public String getZnak() {
        return this.znak;
    }
}
