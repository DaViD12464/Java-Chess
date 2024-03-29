public class Krol extends Figura {

    public Krol(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }


    boolean isFirstMove = true;

    @Override
    public boolean possibleMove(int x, int y) {
        // nie mozna zbic wlasnej figury
        if (this.sameColor(Board.getPiece(x, y)) == true) {
            return false;
        }
        // przekatne
        else if (Math.abs(getX() - x) == 1 && Math.abs(getY() - y) == 1) {
            return true;
        }
        // gora-dol-lewo-prawo
        else if (Math.abs(getX() - x) == 1 && Math.abs(getY() - y) == 0
                || Math.abs(getX() - x) == 0 && Math.abs(getY() - y) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor() == Color.BIALY) {
            return Kolory.WHITE_BOLD+"K"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"K"+Kolory.RESET;
    }

    public int roszada(String side) {
        Wieza rook = (Wieza) Board.getPiece("wieza" + side, this.getColor());
        int originX = this.getX();
        int originY = this.getY();

        if (this.isFirstMove != true || rook.isFirstMove != true) {
            System.out.println(Kolory.CYAN_UNDERLINED+"Nie można wykonać roszady, jeśli król lub wieża wykonał/a ruch."+Kolory.RESET);
            return -1;
        }
        if (Board.isPathClear(this.getX(), this.getY(), rook.getX(), rook.getY()) != true) {
            System.out.println(Kolory.CYAN_UNDERLINED+"Nie można wykonać roszady po linii szachu."+Kolory.RESET);
            return -1;
        }

        if (this.getColor() == Color.BIALY) {

            if (side.equals("K")) {
                // nie mozna wykonac roszady po linii szachu
                if (this.move(5, 7, null) == 0 && this.move(6, 7, null) == 0) {
                    Board.setPiece(rook.getX(), rook.getY(), null);
                    Board.setPiece(5, 7, rook);
                    return 0;
                } else {
                    Board.setPiece(this.getX(), this.getY(), null);
                    Board.setPiece(originX, originY, this);
                    return -1;
                }
            }

            else if (side.equals("Q")) {
                if (this.move(3, 7, null) == 0 && this.move(2, 7, null) == 0) {
                    Board.setPiece(rook.getX(), rook.getY(), null);
                    Board.setPiece(3, 7, rook);
                    return 0;
                } else {
                    Board.setPiece(this.getX(), this.getY(), null);
                    Board.setPiece(originX, originY, this);
                    return -1;
                }
            }
        }

        if (this.getColor() == Color.CZARNY) {
            if (side.equals("K")) {
                if (this.move(5, 0, null) == 0 && this.move(6, 0, null) == 0) {
                    Board.setPiece(rook.getX(), rook.getY(), null);
                    Board.setPiece(5, 0, rook);
                    return 0;
                } else {
                    Board.setPiece(this.getX(), this.getY(), null);
                    Board.setPiece(originX, originY, this);
                    return -1;
                }
            }

            else if (side.equals("Q")) {
                if (this.move(3, 0, null) == 0 && this.move(2, 0, null) == 0) {
                    Board.setPiece(rook.getX(), rook.getY(), null);
                    Board.setPiece(3, 0, rook);
                    return 0;
                } else {
                    Board.setPiece(this.getX(), this.getY(), null);
                    Board.setPiece(originX, originY, this);
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean canMove() {
        int x = this.getX();
        int y = this.getY();

        // ruchy po przekatnych
        // top left
        if (this.testMove(x - 1, y - 1)) {
            return true;
        }
        // top right
        if (this.testMove(x + 1, y - 1)) {
            return true;
        }
        // bottom left
        if (this.testMove(x - 1, y + 1)) {
            return true;
        }
        // bottom right
        if (this.testMove(x + 1, y + 1)) {
            return true;
        }

        // ruchy po osiach
        // left
        if (this.testMove(x - 1, y)) {
            return true;
        }
        // right
        if (this.testMove(x + 1, y)) {
            return true;
        }
        // down
        if (this.testMove(x, y + 1)) {
            return true;
        }
        // up
        if (this.testMove(x, y - 1)) {
            return true;
        }
        return false;
    }

}