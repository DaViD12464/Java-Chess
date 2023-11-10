import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController{
    public GameController()
            throws IOException
    {
        System.out.println("Podaj imie gracza białymi pionkami:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String imiegraczBialy = reader.readLine();
        System.out.println("Podaj imie gracza czarnymi pionkami:");
        String imiegraczCzarny = reader.readLine();

        Szachownica szachownica = new Szachownica();

    }
}
