package Figury;

abstract class Figura
{
    public char znak;

    public abstract void ruch();
    public static void dodajDoPliku()
    {
        System.out.println("dodaje do pliku");
    }

    public char getZnak() {
        return znak;
    }

}
