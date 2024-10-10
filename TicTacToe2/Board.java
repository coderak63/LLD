package TicTacToe2;

public class Board {
    int size;
    PlayingSymbol[][] board;

    Board(int size){
        this.size = size;
        this.board = new PlayingSymbol[size][size];
    }

}
