package Figury;

import Figury.Figura;

public class Hetman extends Figura
{
    public Hetman()
    {
        this.znak = 'Q';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Figury.Hetman");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }
}