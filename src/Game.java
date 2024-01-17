
import java.util.Scanner;

public class Game {

    // TODO en passant
    public static void main(String[] args) {
        Scanner moveChoice = new Scanner(System.in);

        while (true) {
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

                // move choice
                System.out.printf("%s twoja tura! \n"+Kolory.RESET, color == Color.BIALY ? Kolory.WHITE_BOLD+"Bialy" : Kolory.RED_BOLD+"Czarny");

                String move = moveChoice.nextLine();
                // process move
                if (Board.processMove(move, color) == 0) {
                    turns++;
                } else {
                    System.out.println(Kolory.RED_UNDERLINED+"Niedozwolony ruch."+Kolory.RESET);
                }

            }
            System.out.println(Kolory.CYAN_UNDERLINED+"Czy chcesz zagrać jeszcze raz T/N"+Kolory.RESET);
            if (moveChoice.next().equals("T")) {continue;
            } else
                System.exit(0);
        }
    }

}