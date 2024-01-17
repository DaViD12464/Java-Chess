public class Goniec extends Figura {

    public Goniec(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        // nie mozna zbic wlasnej figury
        if (this.sameColor(Board.getPiece(x, y)) == true) {
            return false;
        }
        // nieprawidlowy ruch dla gonca
        if (Math.abs(getX() - x) != Math.abs(getY() - y)) {
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
            return Kolory.WHITE_BOLD+"B"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"B"+Kolory.RESET;
    }

    @Override
    public boolean canMove() {

        int originX = this.getX();
        int originY = this.getY();

        // reset x i y do oryginalnej pozycji po kazdej petli while
        int x = originX;
        int y = originY;

        // gora-lewo
        while ((--x) >= 0 && (--y) >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = originX;
        y = originY;
        // gora-prawo
        while ((++x) <= 7 && (--y) >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = originX;
        y = originY;
        // dol-lewo
        while ((--x) >= 0 && (++y) <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        x = originX;
        y = originY;
        // dol-prawo
        while ((++x) <= 7 && (++y) <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }
        return false;
    }

}