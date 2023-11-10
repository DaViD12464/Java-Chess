package Figury;

public abstract class Figura
{
    public String znak;

    public abstract void ruch();
    public static void dodajDoPliku()
    {
        System.out.println("dodaje do pliku");
    }

    public String getZnak() {
        return znak;
    }

}
