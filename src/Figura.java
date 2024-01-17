import java.util.Scanner;
public abstract class Figura {

    private final Color color;

    private final String ID;

    private int x, y;

    public boolean isFirstMove;

    public Figura(Color color, String ID, int startX, int startY) {
        this.color = color;
        this.ID = ID;
        this.x = startX;
        this.y = startY;

        if (this.getColor() == Color.BIALY) {
            Board.BIALY.add(this);
        } else if (this.getColor() == Color.CZARNY) {
            Board.CZARNY.add(this);
        }
        Board.setPiece(x, y, this);
    }

    public String getID() {
        return this.ID;
    }

    public boolean matchID(String ID) {
        return this.ID.equals(ID);
    }

    public Color getColor() {
        return this.color;
    }

    public boolean sameColor(Figura otherPiece) {
        if (otherPiece == null) {
            return false;
        }
        return (this.color == otherPiece.getColor());
    }

    public int getX() {
        return this.x;
    }

    void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return this.y;
    }

    void setY(int newY) {
        this.y = newY;
    }

    public abstract boolean possibleMove(int x, int y);

    public int move(int x, int y, Figura other) {
        if (this.possibleMove(x, y) != true) {
            return -1;
        }

        Color color = this.getColor();
        int originX = this.getX();
        int originY = this.getY();

        //bicie
        if (this.getColor() == Color.BIALY) {
            Board.CZARNY.remove(other);
        } else {
            Board.BIALY.remove(other);
        }

        Board.setPiece(originX, originY, null);
        Board.setPiece(x, y, this);

        boolean isFirstMoveOG = this.isFirstMove;
        this.isFirstMove = false;

        if (Board.checkForCheck(color) == true) {
            if (other != null) {
                if (this.getColor() == Color.BIALY) {
                    Board.CZARNY.add(other);
                } else {
                    Board.BIALY.add(other);
                }
            }
            Board.setPiece(originX, originY, this);
            Board.setPiece(x, y, other);
            this.isFirstMove = isFirstMoveOG;

            return -1;
        }

        // zamiana pionka na figure
        if (this instanceof Pion && y == 0 || y == 7) {
            char file = this.getID().charAt(4);
            System.out.println(Kolory.CYAN_UNDERLINED+"Podaj na jaką figurę chcesz wymienić pionka:"+Kolory.RESET);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "krolowa":
                    if (this.getColor() == Color.BIALY && y == 0) {
                        Board.setPiece(x, y, null);
                        Board.BIALY.remove(this);
                        Hetman yasQueen = new Hetman(Color.BIALY, "krolowa" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do królowej!"+Kolory.RESET);
                    } else if (this.getColor() == Color.CZARNY && y == 7) {
                        Board.setPiece(x, y, null);
                        Board.CZARNY.remove(this);
                        Hetman yasQueen = new Hetman(Color.CZARNY, "krolowa" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do królowej!"+Kolory.RESET);
                    }
                    break;
                case "wieza":
                    if (this.getColor() == Color.BIALY && y == 0) {
                        Board.setPiece(x, y, null);
                        Board.BIALY.remove(this);
                        Wieza yasRook = new Wieza(Color.BIALY, "wieza" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do wieży!"+Kolory.RESET);
                    } else if (this.getColor() == Color.CZARNY && y == 7) {
                        Board.setPiece(x, y, null);
                        Board.CZARNY.remove(this);
                        Wieza yasRook = new Wieza(Color.CZARNY, "wieza" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do wieży!"+Kolory.RESET);
                    }
                    break;
                case "kon":
                    if (this.getColor() == Color.BIALY && y == 0) {
                        Board.setPiece(x, y, null);
                        Board.BIALY.remove(this);
                        Kon yasKnight = new Kon(Color.BIALY, "kon" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do konia!"+Kolory.RESET);
                    } else if (this.getColor() == Color.CZARNY && y == 7) {
                        Board.setPiece(x, y, null);
                        Board.CZARNY.remove(this);
                        Kon yasKnight = new Kon(Color.CZARNY, "kon" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do konia!"+Kolory.RESET);
                    }
                    break;
                case "goniec":
                    if (this.getColor() == Color.BIALY && y == 0) {
                        Board.setPiece(x, y, null);
                        Board.BIALY.remove(this);
                        Kon yasBishop = new Kon(Color.BIALY, "goniec" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do gońca!"+Kolory.RESET);
                    } else if (this.getColor() == Color.CZARNY && y == 7) {
                        Board.setPiece(x, y, null);
                        Board.CZARNY.remove(this);
                        Kon yasBishop = new Kon(Color.CZARNY, "goniec" + file, x, y);
                        System.out.println(Kolory.PURPLE_UNDERLINED+"Pionek został ulepszony do gońca!"+Kolory.RESET);
                    }
                    break;
            }
        }

        return 0;
    }

    public boolean testMove(int x, int y) {
        int originX = this.getX();
        int originY = this.getY();
        Figura other;
        boolean isFirst = this.isFirstMove;

        if (x >= 0 && y >= 0 && x <= 7 && y <= 7) {
            other = Board.getPiece(x, y);
            if (this.move(x, y, other) == 0) {
                // zbity pionek ustawienie na domyslna pozycje
                Board.setPiece(x, y, other);
                // wybrany pionek ustawienie na domyslna pozycje
                Board.setPiece(originX, originY, this);
                isFirstMove = isFirst;
                if (other != null) {
                    if (other.getColor() == Color.BIALY) {
                        Board.BIALY.add(other);
                    } else
                        Board.CZARNY.add(other);
                }
                return true;
            }
        }
        return false;
    }

    public String nullToString() {
        return "   ";
    }

    public abstract String toString();

    public abstract boolean canMove();
}