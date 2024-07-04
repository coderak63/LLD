package SnakeLadderGame;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    public static void main(String[] args) {
        Board board = new Board();
        board.addLadder(new Ladder(5,15));
        board.addLadder(new Ladder(13,57));
        board.addLadder(new Ladder(4,45));

        board.addSnake(new Snake(15, 2));
        board.addSnake(new Snake(25, 14));
        board.addSnake(new Snake(8, 5));
        board.addSnake(new Snake(34, 22));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Abhishek"));
        players.add(new Player("Rahul"));
        players.add(new Player("Pradip"));

        Game snakeLadderGame = new Game(board, players);
        snakeLadderGame.play();
    }
}
