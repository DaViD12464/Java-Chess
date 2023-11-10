import java.util.Scanner;

public class  PlayerTurn
{
    private String whiteplayer;
    private String blackplayer;

    public void playerturn(String whiteplayer, String blackplayer)
    {
        this.whiteplayer = whiteplayer;
        this.blackplayer = blackplayer;
        Boolean whiteplayerturn = true;
        Boolean blackplayerturn = false;
        next_turn(whiteplayerturn,blackplayerturn);
    }

    public void next_turn( Boolean whiteplayerturn, Boolean blackplayerturn)
    {
        if(whiteplayerturn)
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.WHITE_BOLD +whiteplayer +", twoja tura!"+Kolory.RESET);
            Scanner scanner = new Scanner(System.in);
            String ruch = scanner.nextLine();
            //dodac metode obslugujaca poruszanie figurami - do ktorej przekazemy wartosc ruch (ta klasa !musi wyswietlic konsole po wykonaniu)
            //if(/*metodaporuszania*/ == true)
            if(ruch != null)    //tymczasowe do czasu wprowadzenia ruchow
            {
                whiteplayerturn = false;
                blackplayerturn = true;
                next_turn(whiteplayerturn, blackplayerturn);
            }
        }

        if(blackplayerturn)
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.RED_BOLD +blackplayer +", twoja tura!"+Kolory.RESET);
            Scanner scanner = new Scanner(System.in);
            String ruch = scanner.nextLine();
            //dodac metode obslugujaca poruszanie figurami - do ktorej przekazemy wartosc ruch
            //if(/*metodaporuszania*/ == true)
            if(ruch != null)    //tymczasowe do czasu wprowadzenia ruchow
            {
                whiteplayerturn = true;
                blackplayerturn = false;
                next_turn(whiteplayerturn, blackplayerturn);
            }
        }
    }
}
