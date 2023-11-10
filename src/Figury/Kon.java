package Figury;

import Figury.Figura;

public class Kon extends Figura
{
    public int x;
    public int y;
    public Kon(int x, int y)
    {
        this.znak = " N ";
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Koń");
    }

    @Override
    public String getZnak() {
        return this.znak;
    }
}