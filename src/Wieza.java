public class Wieza extends Figura {

    public Wieza(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    boolean isFirstMove = true;


    @Override
    public boolean possibleMove(int x, int y) {
        // nie mozna zbic wlasnej figury
        if (this.sameColor(Board.getPiece(x, y)) == true) {
            return false;
        }
        // nieprawidlowy ruch  dla wiezy
        if (Math.abs(getX() - x) != 0 && Math.abs(getY() - y) != 0) {
            return false;
        }

        if (Board.isPathClear(getX(), getY(), x, y)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor() == Color.BIALY) {
            return Kolory.WHITE_BOLD+"R"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"R"+Kolory.RESET;
    }

    @Override
    public boolean canMove() {
        int x = this.getX();
        int y = this.getY();

        // lewa
        while ((--x) >= 0 && y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = this.getX();
        y = this.getY();
        // prawa
        while ((++x) <= 7 && y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = this.getX();
        y = this.getY();
        // dol
        while (x >= 0 && (++y) <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = this.getX();
        y = this.getY();
        // gora
        while (x <= 7 && (--y) >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        return false;
    }

}