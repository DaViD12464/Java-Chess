import Figury.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController{
    public GameController()
            throws IOException
    {
        Szachownica szachownica = new Szachownica();
//        Players gracze = new Players();
    }


    public static void stworzObiektyFigur()
    {

        Goniec goniecBialy1 = new Goniec(0,1);
        Goniec goniecBialy2 = new Goniec(0,5);
        Goniec goniecCzarny1 = new Goniec(8,1);
        Goniec goniecCzarny2 = new Goniec(8,5);

        Kon konBialy1 = new Kon(0,1);
        Kon konBialy2 = new Kon(0,7);
        Kon konCzarny1 = new Kon(8,2);
        Kon konCzarny2 = new Kon(8,7);

        Hetman hetmanBialy = new Hetman(0, 3);
        Hetman hetmanCzarny = new Hetman(8, 3);

        Krol krolBialy = new Krol(0,4);
        Krol krolCzarny = new Krol(8,4);

        Pion pionBialy1 = new Pion();
        Pion pionBialy2 = new Pion();
        Pion pionBialy3 = new Pion();
        Pion pionBialy4 = new Pion();
        Pion pionBialy5 = new Pion();
        Pion pionBialy6 = new Pion();
        Pion pionBialy7 = new Pion();
        Pion pionBialy8 = new Pion();

        Pion pionCzarny1 = new Pion();
        Pion pionCzarny2 = new Pion();
        Pion pionCzarny3 = new Pion();
        Pion pionCzarny4 = new Pion();
        Pion pionCzarny5 = new Pion();
        Pion pionCzarny6 = new Pion();
        Pion pionCzarny7 = new Pion();
        Pion pionCzarny8 = new Pion();
    }
}
