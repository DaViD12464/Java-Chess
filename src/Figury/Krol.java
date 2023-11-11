package Figury;


public class Krol extends Figura
{
    public int x;
    public int y;
    public Krol(int x, int y)
    {
        if ((x + y)%2==0)
        {
            this.znak = 'K';
        }
        this.x = x;
        this.y = y;
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