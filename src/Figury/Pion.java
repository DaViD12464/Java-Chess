package Figury;

import Figury.Figura;

public class Pion extends Figura
{
    public int x;
    public int y;

    public Pion(int x, int y)
    {
        this.znak = 'O';
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Pion");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }

}