public class Goniec extends Figura
{
    public Goniec()
    {
        this.znak = 'B';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Goniec");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }
}