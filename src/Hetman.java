public class Hetman extends Figura {

    public Hetman(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        // nie mozna zbic wlasnej figury
        if (this.sameColor(Board.getPiece(x, y)) == true) {
            return false;
        }
        // zderzenie/blokada
        if (Board.isPathClear(getX(), getY(), x, y) != true) {
            return false;
        }
        // goniec
        if (Math.abs(getX() - x) == Math.abs(getY() - y)) {
            return true;
        }
        // wieza
        if (Math.abs(getX() - x) != 0 && Math.abs(getY() - y) == 0
                || Math.abs(getX() - x) == 0 && Math.abs(getY() - y) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor() == Color.BIALY) {
            return Kolory.WHITE_BOLD+"Q"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"Q"+Kolory.RESET;
    }

    @Override
    public boolean canMove() {

        int x = this.getX();
        int y = this.getY();
                    //skosy
        // gora-lewo
        while ((--x) >= 0 && (--y) >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();
        // gora-prawo
        while ((++x) <= 7 && (--y) >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();
        // dol-lewo
        while ((--x) >= 0 && (++y) <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();
        // dol-prawo
        while ((++x) <= 7 && (++y) <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();
        // lewo
        while ((--x) >= 0 && y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();
        // prawo
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