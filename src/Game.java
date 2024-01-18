
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Game {

    public static String fileName = "historia.txt";
//    public static File plik = new File(fileName);
    public static PrintWriter zapis;


    public Game() throws FileNotFoundException {
    }

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
                // zsrób ruch
                if(move.equals("end"))
                {
                    zapis.close();
                    System.exit(0);
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
            if (moveChoice.next().equals("T"))
            {
                zapis = new PrintWriter(fileName);
                continue;
            }
            else
            {
                System.exit(0);
            }
        }
    }

}