public class Wieza extends Figura
{

    public Wieza()
    {
        this.znak = 'R';
    }

    public void ruch()
    {
        System.out.println("ruszam się - Wieża");
    }

    @Override
    public char getZnak() {
        return this.znak;
    }
}
