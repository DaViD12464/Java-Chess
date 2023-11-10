public class Pion extends Figura
{

    public Pion()
    {
        this.znak = 'o';
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