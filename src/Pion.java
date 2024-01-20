public class Pion extends Figura {

    public Pion(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    Pion pieceleft = null;
    Pion pieceright = null;

    boolean isFirstMove = true;
    boolean enPassant = false;

    private void checkEnPassant(int x, int y) {

        switch(x) {
            case 7:
                pieceleft =  (Pion) Board.getPiece(x - 1, y);
                pieceright = null;
                break;
            case 0:
                pieceright = (Pion) Board.getPiece(x + 1, y);
                pieceleft = null;
                break;
            case 1: case 2: case 3: case 4: case 5: case 6:
                pieceleft = (Pion) Board.getPiece(x - 1, y);
                pieceright = (Pion) Board.getPiece(x + 1, y);
                break;
            }
            if (pieceright != null && pieceright.getColor() != this.getColor()){
                System.out.println("En passant możliwe do wykonania w lewo (figura do bicia po lewej).");
                System.out.println(pieceleft);
                System.out.println(pieceright);
                enPassant = true;
            }
            if(pieceleft != null && pieceleft.getColor() != this.getColor()) {
                System.out.println("En passant możliwe do wykonania w prawo. (figura do bicia po prawej).");
                System.out.println(pieceleft);
                System.out.println(pieceright);
                enPassant = true;
            }
    }
/*
    public int enpassant(int x, int y){

    }
        if(enPassant == true & pieceleft.sameColor(Board.getPiece(x-1,y))){
            pieceleft.move(x+1, )
        }
        if (this.move(x+1, y-1, null) == 0 && this.move(6, 7, null) == 0) {
            Board.setPiece(rook.getX(), rook.getY(), null);
            Board.setPiece(5, 7, rook);
            return 0;
    }

*/
    @Override
    public boolean possibleMove(int x, int y) {
        // TODO en passant

        if (this.getColor() == Color.BIALY) {

            // 2 pola do przodu
            if (this.isFirstMove && this.getY() - y == 2 && this.getX() - x == 0
                    && Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
                checkEnPassant(x,y);
                this.isFirstMove = false;
                this.enPassant = false;
                return true;
            }
            // 1 pole do przodu
            if (this.getY() - y == 1 && this.getX() - x == 0 && Board.getPiece(x, y) == null) {
                this.isFirstMove = false;
                this.enPassant = false;
                return true;
            }

            // skos(bicie)
            if (this.getY() - y == 1 && Math.abs(this.getX() - x) == 1 && Board.getPiece(x, y) != null
                    && !this.sameColor(Board.getPiece(x, y))) {
                this.isFirstMove = false;
                this.enPassant = false;
                return true;
            }

            // En passant dla białych
            if (this.enPassant == true) {
                if ((Board.getPiece(x - 1, y) instanceof Pion) || Board.getPiece(x + 1, y) instanceof Pion) {
                    ((Pion) Board.getPiece(x, y - 1)).enPassant = false;
                    this.isFirstMove = false;
                    this.enPassant = false;
                    return true;
                }
            }

        }

        if (this.getColor() == Color.CZARNY) {
            // 2 pola do przodu
            if (this.isFirstMove && this.getY() - y == -2 && this.getX() - x == 0
                    && Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
                checkEnPassant(x,y);
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

            // En passant dla czarnych
            if (y == this.getY() - 1 && Math.abs(x - this.getX()) == 1) {
                if (Board.getPiece(x, y + 1) instanceof Pion && ((Pion) Board.getPiece(x, y + 1)).enPassant) {
                    //Board.movePiece(this.getX(), y, x, y + 1);
                    ((Pion) Board.getPiece(x, y + 1)).enPassant = false; // Wyłącz en passant po wykonaniu ruchu
                    return true;
                }
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