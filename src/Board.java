import java.util.ArrayList;


public class Board {
    public static ArrayList<Figura> CZARNY = new ArrayList<Figura>();
    public static ArrayList<Figura> BIALY = new ArrayList<Figura>();
    public static final int SIZE = 8;

    static Figura board[][] = new Figura[8][8];

    static void printBoard() {
        System.out.println(Kolory.GOLD+"    a   b   c   d   e   f   g   h"+Kolory.RESET);

        System.out.println(Kolory.GOLD+"  ---------------------------------"+ Kolory.RESET);
        int count = 8;
        for (int i = 0; i < 8; i++) {
            System.out.print(Kolory.GOLD+count + " "+ Kolory.RESET);
            System.out.print(Kolory.GOLD+"| "+ Kolory.RESET);
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(Kolory.GOLD+"  | "+ Kolory.RESET);
                } else {
                    System.out.print(board[i][j] +Kolory.GOLD+" | "+ Kolory.RESET);
                }
            }
            System.out.print(Kolory.GOLD+count+ Kolory.RESET);
            count--;
            System.out.println();
            System.out.println(Kolory.GOLD+"  ---------------------------------"+ Kolory.RESET);
        }

        System.out.println(Kolory.GOLD+"    a   b   c   d   e   f   g   h"+ Kolory.RESET);
        System.out.println();
    }

    static void startGame() {
        System.out.println(Kolory.GREEN_BOLD+"  ---------------------------------");
        System.out.println("Jak grać:");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Ruch pionkiem: Wpisz \"pion\" a po nim oznaczenie kolumny. \nDla przykładu: \"pionA a3\"");
        System.out.println("Dla gońców, koni i wież wpisz: \"Q\" lub \"K\" aby określić czy poruszasz się figurą po stronie królowej czy króla.");
        System.out.println("Następnie wpisz spację i pole na które chcesz się udać. \nDla przykładu: \"goniecK c4\"");
        System.out.println("Pionki są automatycznie zastępowane przez wybrana figure (wyświetli się prośba o podanie jednej z figur [kon,wieza,krolowa,goniec].");
        System.out.println("Nowe figury mają przypisywaną kolumnę od pionka. \nDla przykładu: \"krolowaH\"");
        System.out.println("Aby wykonać roszadę wpisz \"roszada\", następnie spację i \"Q\" lub \"K\" aby wybrać stronę w którą ma się wykonać roszada. \nDla przykładu: \"roszada Q\"");
        System.out.println("Można poddać grę wcześniej wpisując \"poddanie\" jako ruch.");
        System.out.println("------------------------------------------------------------------"+Kolory.RESET);

        // CZARNY
        new Wieza(Color.CZARNY, "wiezaQ", 0, 0);
        new Kon(Color.CZARNY, "konQ", 1, 0);
        new Goniec(Color.CZARNY, "goniecQ", 2, 0);
        new Hetman(Color.CZARNY, "krolowa", 3, 0);
        new Krol(Color.CZARNY, "krol", 4, 0);
        new Goniec(Color.CZARNY, "goniecK", 5, 0);
        new Kon(Color.CZARNY, "konK", 6, 0);
        new Wieza(Color.CZARNY, "wiezaK", 7, 0);

        new Pion(Color.CZARNY, "pionA", 0, 1);
        new Pion(Color.CZARNY, "pionB", 1, 1);
        new Pion(Color.CZARNY, "pionC", 2, 1);
        new Pion(Color.CZARNY, "pionD", 3, 1);
        new Pion(Color.CZARNY, "pionE", 4, 1);
        new Pion(Color.CZARNY, "pionF", 5, 1);
        new Pion(Color.CZARNY, "pionG", 6, 1);
        new Pion(Color.CZARNY, "pionH", 7, 1);

        // BIALY
        new Wieza(Color.BIALY, "wiezaQ", 0, 7);
        new Kon(Color.BIALY, "konQ", 1, 7);
        new Goniec(Color.BIALY, "goniecQ", 2, 7);
        new Hetman(Color.BIALY, "krolowa", 3, 7);
        new Krol(Color.BIALY, "krol", 4, 7);
        new Goniec(Color.BIALY, "goniecK", 5, 7);
        new Kon(Color.BIALY, "konK", 6, 7);
        new Wieza(Color.BIALY, "wiezaK", 7, 7);

        new Pion(Color.BIALY, "pionA", 0, 6);
        new Pion(Color.BIALY, "pionB", 1, 6);
        new Pion(Color.BIALY, "pionC", 2, 6);
        new Pion(Color.BIALY, "pionD", 3, 6);
        new Pion(Color.BIALY, "pionE", 4, 6);
        new Pion(Color.BIALY, "pionF", 5, 6);
        new Pion(Color.BIALY, "pionG", 6, 6);
        new Pion(Color.BIALY, "pionH", 7, 6);
    }

    // set piece to provided coordinates
    public static void setPiece(int x, int y, Figura piece) {
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
        board[y][x] = piece;
    }

    // check spot on board
    public static Figura getPiece(int x, int y) {
        return board[y][x];
    }

    // match String piece from user with Piece on board
    public static Figura getPiece(String piece, Color color) {

        if (color == Color.BIALY) {

            for (int i = 0; i < BIALY.size(); i++) {
                Figura p = BIALY.get(i);
                if (p.matchID(piece)) {
                    return p;
                }
            }
        }

        else if (color == Color.CZARNY) {

            for (int i = 0; i < CZARNY.size(); i++) {
                Figura p = CZARNY.get(i);
                if (p.matchID(piece)) {
                    return p;
                }
            }
        }

        return null;

    }

    public static boolean isPathClear(int x1, int y1, int x2, int y2) {

        int xDistance = x2 - x1;
        int yDistance = y2 - y1;
        int xDir = 0;
        int yDir = 0;
        int size = 0;

        if (xDistance < 0) {
            xDir = -1;
        } else if (xDistance > 0) {
            xDir = 1;
        }

        if (yDistance < 0) {
            yDir = -1;
        } else if (yDistance > 0) {
            yDir = 1;
        }

        if (xDistance != 0) {
            size = Math.abs(xDistance) - 1;
        } else {
            size = Math.abs(yDistance) - 1;
        }
        // zmiany na x i y

        for (int i = 0; i < size; i++) {
            x1 += xDir;
            y1 += yDir;

            if (getPiece(x1, y1) != null) {
                return false;
            }
        }
        return true;

    }

    static int processMove(String move, Color color) {

        String[] splitStr = move.split(" ");
        String piece = splitStr[0];

        if (piece.equals("roszada")) {
            Krol king = (Krol) getPiece("krol", color);
            assert king != null;
            return king.roszada(splitStr[1]);
        }

        // figura wybrana do wykonania ruchu
        Figura p = getPiece(piece, color);
        if (p == null) {
            System.out.println(Kolory.RED_UNDERLINED+"nieprawidłowa figura, proszę wprowadzić figurę."+Kolory.RESET);
            return -1;
        }

        String coordinates = splitStr[1];
        if (coordinates.length() != 2) {
            System.out.println(Kolory.RED_UNDERLINED+"Nieprawidłowe pole, proszę spróbować jeszcze raz."+Kolory.RESET);
            return -1;
        }

        int file = coordinates.charAt(0) - 'a'; // y
        int rank = 7 - (coordinates.charAt(1) - '1'); // x

        if (rank < 0 || rank > 7 || file < 0 || file > 7) {
            System.out.println(Kolory.RED_UNDERLINED+"Nieprawidłowe pole, proszę spróbować jeszcze raz."+Kolory.RESET);
            return -1;
        }

        // figura na miejscu docelowym
        Figura other = getPiece(file, rank);

        return p.move(file, rank, other);

    }

    public static boolean checkForCheck(Color color) {

        Figura king = getPiece("krol", color);

        if (color == Color.BIALY) {
            for (int i = 0; i < CZARNY.size(); i++) {
                Figura p = CZARNY.get(i);
                if (p.possibleMove(king.getX(), king.getY())) {
                    return true;
                }
            }
        }

        else if (color == Color.CZARNY) {
            for (int i = 0; i < BIALY.size(); i++) {
                Figura p = BIALY.get(i);
                if (p.possibleMove(king.getX(), king.getY())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean mate(Color color) {

        if (color == Color.BIALY) {
            for (int i = 0; i < BIALY.size(); i++) {
                Figura p = BIALY.get(i);
                if (p.canMove()) {
                    return false;
                }
            }
        } else if (color == Color.CZARNY) {
            for (int i = 0; i < CZARNY.size(); i++) {
                Figura p = CZARNY.get(i);
                if (p.canMove()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean staleMate(Color color) {

        // niewystarczajace matierialy - koniec gry
        Figura konK = getPiece("konK", color);
        Figura konQ = getPiece("konQ", color);
        Figura goniecK = getPiece("goniecK", color);
        Figura goniecQ = getPiece("goniecQ", color);

        if (BIALY.size() == 2 && CZARNY.size() == 2) {
            if (BIALY.contains(goniecK) || BIALY.contains(goniecQ) || BIALY.contains(konK)
                    || BIALY.contains(konQ)) {
                return true;
            }
            if (CZARNY.contains(goniecK) || CZARNY.contains(goniecQ) || CZARNY.contains(konK)
                    || BIALY.contains(konQ)) {
                return true;
            }

        }
        if (BIALY.size() == 1 && BIALY.get(0) instanceof Krol && CZARNY.size() == 1 && CZARNY.get(0) instanceof Krol) {
            return true;
        }

        // no legal moves stalemate
        if (mate(color) == true && checkForCheck(color) == false) {
            return true;
        }

        return false;

    }

}