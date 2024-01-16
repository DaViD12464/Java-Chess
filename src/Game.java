
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
                // check for check
                if (turns % 2 == 0) {
                    color = Color.BIALY;
                } else
                    color = Color.CZARNY;

                if (Board.staleMate(color)) {
                    System.out.println("Gra skończona, szachmat");
                    break;
                }
                if (Board.checkForCheck(color)) {
                    if (Board.mate(color)) {

                        System.out.printf("Szachmat, %s wygrywa! \n", color == Color.BIALY ? "Czarny" : "Bialy");
                        break;
                    }
                    System.out.printf("%s został zaszachowany! \n", color == Color.BIALY ? "Bialy" : "Czarny");
                }

                // move choice
                System.out.printf("%s twoja tura! \n", color == Color.BIALY ? "Bialy" : "Czarny");

                String move = moveChoice.nextLine();
                // process move
                if (Board.processMove(move, color) == 0) {
                    turns++;
                } else {
                    System.out.println("Niedozwolony ruch.");
                }

            }
            System.out.println("Czy chcesz zagrać jeszcze raz T/N");
            if (moveChoice.next().equals("T")) {continue;
            } else
                System.exit(0);
        }
    }

}