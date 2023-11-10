import java.util.Scanner;

public class  PlayerTurn
{
    private String whiteplayer;
    private String blackplayer;

    public void playerturn(String whiteplayer, String blackplayer, Szachownica szachownica)
    {
        this.whiteplayer = whiteplayer;
        this.blackplayer = blackplayer;
        Boolean whiteplayerturn = true;
        Boolean blackplayerturn = false;
        next_turn(whiteplayerturn,blackplayerturn, szachownica);
    }

    public void next_turn( Boolean whiteplayerturn, Boolean blackplayerturn, Szachownica szachownica)
    {
        if(whiteplayerturn)
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.WHITE_BOLD +whiteplayer +", twoja tura!"+Kolory.RESET);
            szachownica.wyswietl();
            Scanner scanner = new Scanner(System.in);
            String ruch = scanner.nextLine();
            //dodac metode obslugujaca poruszanie figurami)
            //if(/*metodaporuszania*/ == true)
            if(ruch != null)    //tymczasowe do czasu wprowadzenia ruchow
            {
                whiteplayerturn = false;
                blackplayerturn = true;
                next_turn(whiteplayerturn, blackplayerturn, szachownica);
            }
        }

        if(blackplayerturn)
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.RED_BOLD +blackplayer +", twoja tura!"+Kolory.RESET);
            szachownica.wyswietl();
            Scanner scanner = new Scanner(System.in);
            String ruch = scanner.nextLine();
            //dodac metode obslugujaca poruszanie figurami - do ktorej przekazemy wartosc ruch
            //if(/*metodaporuszania*/ == true)
            if(ruch != null)    //tymczasowe do czasu wprowadzenia ruchow
            {
                whiteplayerturn = true;
                blackplayerturn = false;
                next_turn(whiteplayerturn, blackplayerturn, szachownica);
            }
        }
    }
}
