import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Game {

    public static String fileName = "historia.txt";
    public static PrintWriter zapis;

    // TODO en passant
    public static void main(String[] args) throws FileNotFoundException{
        Scanner moveChoice = new Scanner(System.in);

        while (true) {
            zapis = new PrintWriter(fileName);
            Board.startGame();

            int turns = 0;
            Color color;

            while (true) {
                Board.printBoard();
                // sprawdz czy szach
                if (turns % 2 == 0) {
                    color = Color.BIALY;
                } else
                    color = Color.CZARNY;

                if (Board.staleMate(color)) {
                    System.out.println(Kolory.YELLOW_UNDERLINED+"Gra skończona, szachmat"+Kolory.RESET);
                    break;
                }
                if (Board.checkForCheck(color)) {
                    if (Board.mate(color)) {

                        System.out.printf(Kolory.YELLOW_UNDERLINED+"Szachmat, %s wygrywa! \n", color == Color.BIALY ? "Czarny" : "Bialy");
                        break;
                    }
                    System.out.printf(Kolory.YELLOW_UNDERLINED+"%s został zaszachowany! \n", color == Color.BIALY ? "Bialy" : "Czarny");
                }

                // wybierz ruch
                System.out.printf("%s twoja tura! \n"+Kolory.RESET, color == Color.BIALY ? Kolory.WHITE_BOLD+"Bialy" : Kolory.RED_BOLD+"Czarny");

                String move = moveChoice.nextLine();
                // zrób ruch
                if(move.equals("poddanie"))
                {
                    System.out.printf(Kolory.RED_UNDERLINED+"%s czy na pewno chcesz poddać rozgrywkę? T/N \n"+Kolory.RESET, color == Color.BIALY ? "Bialy" : "Czarny");
                    if (moveChoice.next().equalsIgnoreCase("T"))
                    {
                        System.out.printf(Kolory.YELLOW_UNDERLINED+"Poddanie, %s wygrywa! \n", color == Color.BIALY ? "Czarny" : "Bialy");
                    zapis.close();
                    System.exit(0);
                    }
                    else continue;
                }
                    if (Board.processMove(move, color) == 0) {
                        turns++;
                        zapis.println(move);
                    } else {
                        System.out.println(Kolory.RED_UNDERLINED+"Niedozwolony ruch."+Kolory.RESET);
                    }

            }
            zapis.close();
            System.out.println(Kolory.CYAN_UNDERLINED+"Czy chcesz zagrać jeszcze raz T/N"+Kolory.RESET);
            if (moveChoice.next().equalsIgnoreCase("T"))
            {
                zapis = new PrintWriter(fileName);
            }
            else
            {
                zapis = new PrintWriter(fileName);
                System.exit(0);
            }
        }
    }

}