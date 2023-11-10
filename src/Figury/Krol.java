package Figury;

import Figury.Figura;

public class Krol extends Figura
{
    public Krol()
    {
        this.znak = 'K';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Król");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }

}