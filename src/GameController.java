import Figury.*;
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

        PlayerTurn playerTurn = new PlayerTurn();
        playerTurn.playerturn(whiteplayer, blackplayer);


        public static void rozstawFigury(char[][] szachownica)
        {

            szachownica[0][0] = new Wieza(0, 0).getZnak();
            szachownica[0][1] = new Kon(0, 2).getZnak();
            szachownica[0][2] = new Goniec(0, 1).getZnak();
            szachownica[0][3] = new Hetman(0, 3).getZnak();
            szachownica[0][4] = new Krol(0, 4).getZnak();
            szachownica[0][5] = new Goniec(0, 5).getZnak();
            szachownica[0][6] = new Kon(0, 6).getZnak();
            szachownica[0][7] = new Wieza(0, 7).getZnak();

            for (int j = 0; j < 8; j++) {
                szachownica[1][j] = new Pion(1, j).getZnak();
            }
        }
        
    }
}
