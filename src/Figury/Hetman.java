package Figury;

import Figury.Figura;

public class Hetman extends Figura
{
    public int x;
    public int y;
    public Hetman(int x, int y)
    {
        this.znak = 'Q';
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Hetman");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }
}