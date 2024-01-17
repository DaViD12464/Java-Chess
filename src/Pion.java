public class Pion extends Figura {

    public Pion(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    boolean isFirstMove = true;

    @Override
    public boolean possibleMove(int x, int y) {
        // TODO en passant

        if (this.getColor() == Color.BIALY) {

            // 2 pola do przodu
            if (this.isFirstMove && this.getY() - y == 2 && this.getX() - x == 0
                    && Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
                this.isFirstMove = false;
                return true;
            }
            // 1 pole do przodu
            if (this.getY() - y == 1 && this.getX() - x == 0 && Board.getPiece(x, y) == null) {
                this.isFirstMove = false;
                return true;
            }

            // skos
            if (this.getY() - y == 1 && Math.abs(this.getX() - x) == 1 && Board.getPiece(x, y) != null
                    && !this.sameColor(Board.getPiece(x, y))) {
                this.isFirstMove = false;
                return true;
            }
        }

        if (this.getColor() == Color.CZARNY) {
            // 2 pola do przodu
            if (this.isFirstMove && this.getY() - y == -2 && this.getX() - x == 0
                    && Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
                this.isFirstMove = false;
                return true;
            }
            // 1 pole do przodu
            if (this.getY() - y == -1 && this.getX() - x == 0 && Board.getPiece(x, y) == null) {
                this.isFirstMove = false;
                return true;
            }

            // skos (bicie)
            if (this.getY() - y == -1 && Math.abs(this.getX() - x) == 1 && Board.getPiece(x, y) != null
                    && !this.sameColor(Board.getPiece(x, y))) {
                this.isFirstMove = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor() == Color.BIALY) {
            return Kolory.WHITE_BOLD+"o"+Kolory.RESET;
        }
        return Kolory.RED_BOLD+"o"+Kolory.RESET;
    }

    @Override
    public boolean canMove() {
        int x = this.getX();
        int y = this.getY();

        if (this.getColor() == Color.CZARNY) {

            if (this.testMove(x, y - 1)) {
                return true;
            }

            if (this.testMove(x, y - 2)) {
                return true;
            }

            if (this.testMove(x - 1, y - 1)) {
                return true;
            }

            if (this.testMove(x + 1, y - 1)) {
                return true;
            }

        }
        if (this.getColor() == Color.CZARNY) {

            if (this.testMove(x, y + 1)) {
                return true;
            }

            if (this.testMove(x, y + 2)) {
                return true;
            }

            if (this.testMove(x - 1, y - 1)) {
                return true;
            }

            if (this.testMove(x + 1, y + 1)) {
                return true;
            }
        }

        return false;
    }

}