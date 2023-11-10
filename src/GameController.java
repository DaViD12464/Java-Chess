import java.io.IOException;

public class GameController{
    public GameController()
            throws IOException
    {
        String whiteplayer;
        String blackplayer;

        Szachownica szachownica = new Szachownica(); // zainicjalizowanie szachownicy

        whiteplayer = Players.add_players("Podaj imię gracza białymi figurami:"); //pobranie gracza białych figur
        blackplayer = Players.add_players("Podaj imię gracza czarnymi figurami:"); //pobranie gracza czarnych figur

        Rozstawienie.rozstawFigury(szachownica.getSzachownica());

        PlayerTurn playerTurn = new PlayerTurn();  // zainicjalizowanie gry od tury białych
        playerTurn.playerturn(whiteplayer, blackplayer, szachownica);




        
    }
}
