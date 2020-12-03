package Day_17.Task_2;

public class Task_2 {
    public static void main(String[] args) {
        ChessPiece[][] config2000 = {
            {ChessPiece.ROOK_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_BLACK, ChessPiece.KING_BLACK, ChessPiece.EMPTY},
            {ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK, ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK},
            {ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.KNIGHT_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY,  ChessPiece.PAWN_BLACK, ChessPiece.EMPTY},
            {ChessPiece.QUEEN_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
            {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_BLACK, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
            {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY},
            {ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.QUEEN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE},
            {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.KING_WHITE, ChessPiece.EMPTY},
        };

        ChessBoard board = new ChessBoard(config2000);
        board.print();
    }
}
