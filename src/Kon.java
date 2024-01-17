public class Kon extends Figura {

    public Kon(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        // nie mozna zbic wlasnej figury
        if (this.sameColor(Board.getPiece(x, y)) == true) {
            return false;
        }

        if (Math.abs(this.getY() - y) == 2 && Math.abs(this.getX() - x) == 1
                || Math.abs(this.getY() - y) == 1 && Math.abs(this.getX() - x) == 2) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        if (this.getColor() == Color.BIALY) {
            return Kolory.WHITE_BOLD+"N"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"N"+Kolory.RESET;
    }

    @Override
    public boolean canMove() {

        int x = this.getX();
        int y = this.getY();

        // lewo&gora
        if (this.testMove(x - 2, y - 1)) {
            return true;
        }
        if (this.testMove(x - 1, y - 2)) {
            return true;
        }

        // prawo&gora
        if (this.testMove(x + 2, y - 1)) {
            return true;
        }
        if (this.testMove(x + 1, y - 2)) {
            return true;
        }

        // lewo&dol
        if (this.testMove(x - 2, y + 1)) {
            return true;
        }
        if (this.testMove(x - 1, y + 2)) {
            return true;
        }

        // prawo&dol
        if (this.testMove(x + 2, y + 1)) {
            return true;
        }
        if (this.testMove(x + 1, y + 2)) {
            return true;
        }

        return false;
    }

}