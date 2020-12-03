package Day_17.Task_2;

public enum ChessPiece {
    KING_WHITE(100, "♔"), KING_BLACK(100, "♚"),
    QUEEN_WHITE(9, "♕"), QUEEN_BLACK(9, "♛"),
    BISHOP_WHITE(3.5, "♗"), BISHOP_BLACK(3.5, "♝"),
    KNIGHT_WHITE(3, "♘"), KNIGHT_BLACK(3, "♞"),
    ROOK_WHITE(5, "♖"), ROOK_BLACK(5, "♜"),
    PAWN_WHITE(1, "♙"), PAWN_BLACK(1, "♟"),
    EMPTY(-1, "_");

    private double value;
    private String stringVal;

    ChessPiece(double value, String stringVal) {
        this.value = value;
        this.stringVal = stringVal;
    }

    public double getValue() {
        return value;
    }

    public String getStringVal() {
        return stringVal;
    }

    @Override
    public String toString() {
        return stringVal;
    }
}
