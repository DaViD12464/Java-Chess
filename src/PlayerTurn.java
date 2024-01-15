import java.util.Scanner;

public class  PlayerTurn
{
    private String whiteplayer;
    private String blackplayer;
    String kolejka = "bialy";

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
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.WHITE_BOLD_BRIGHT +whiteplayer +", twoja tura!"+Kolory.RESET);
            szachownica.wyswietl();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if( metodaporuszania.ruch(input.toUpperCase(), szachownica, kolejka))
            {
                whiteplayerturn = false;
                blackplayerturn = true;
                kolejka = "czarny";
                next_turn(whiteplayerturn, blackplayerturn, szachownica);
            }
            else next_turn(whiteplayerturn, blackplayerturn, szachownica);
        }

        if(blackplayerturn)
        {
            System.out.println(Kolory.BLACK_BACKGROUND + Kolory.RED_BOLD +blackplayer +", twoja tura!"+Kolory.RESET);

            szachownica.wyswietl();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(metodaporuszania.ruch(input.toUpperCase(), szachownica, kolejka))
            {
                whiteplayerturn = true;
                blackplayerturn = false;
                String kolejka = "bialy";
                next_turn(whiteplayerturn, blackplayerturn, szachownica);
            }
            else next_turn(whiteplayerturn, blackplayerturn, szachownica);

        }
    }
}
