package Figury;

public class Goniec extends Figura
{
    public int x;
    public int y;
    public Goniec(int x, int y)
    {
        this.znak = " B ";
        this.x = x;
        this.y = y;
    }

    public void ruch()
    {
        System.out.println("ruszam się - Figury.Goniec");
    }

    @Override
    public String getZnak() {
        return this.znak;
    }
}