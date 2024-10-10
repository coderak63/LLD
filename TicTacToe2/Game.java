package TicTacToe2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Queue<Player> players;
    Board board;

    Game(){
        players = new LinkedList<Player>();
        players.add(new Player("P1", new PlayingSymbolX()));
        players.add(new Player("P2", new PlayingSymbolO()));

        board = new Board(3);
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        while(!gameOver){
            Player currentPlayer = players.remove();
            players.add(currentPlayer);
            // print current player
            // print board
            // take input from current player-> i,j
            // check if position is empty to fill
            // if empty, fill the position and check for win or tie and declare if so
            // if not, again take input for another player

        }
    }
}
