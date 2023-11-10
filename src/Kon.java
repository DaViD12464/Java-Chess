public class Kon extends Figura
{
    public Kon()
    {
        this.znak = 'N';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Koń");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }
}