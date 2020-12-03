package Day_17.Task_2;

public class ChessBoard {
    private ChessPiece[][] config;

    public ChessBoard(ChessPiece[][] config) {
        this.config = config;
    }

    public void print() {
        for (int i = 0; i < config.length; i++) {
            for (int j = 0; j < config[i].length; j++) {
                System.out.print(config[i][j]);
            }
            System.out.print("\n");
        }
    }
}
