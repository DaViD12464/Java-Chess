package Figury;

import Figury.Figura;

public class Pion extends Figura
{
    public int x;
    public int y;

    public Pion()
    {
        this.znak = 'o';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Figury.Pion");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }

}