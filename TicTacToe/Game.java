package TicTacToe;

import java.util.Scanner;
import TicTacToe.Board;

public class Game {
    Board board;
    

    Game(){
        board = new Board();
        System.out.println("Game is ready to play: ");
        board.printBoard();
    }

    public void play(){
        boolean gameOver = false;
        char currentPlayer = 'X';
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            System.out.println("Current Player is : "+currentPlayer);
            System.out.println("Choose a position between 1 to 9");
            
            boolean isInserted = false;
            while(!isInserted){
                int pos = sc.nextInt();
                isInserted = board.insertInBoard(pos, currentPlayer);
            }

            if(board.checkForWin()){
                gameOver = true;
                System.out.println("!!! Game Over !!!");
                System.out.println("Result: Player "+currentPlayer+" is winner!");
            }else if(board.checkForTie()){
                gameOver = true;
                System.out.println("!!! Game Over !!!");
                System.out.println("Result: Tie");
            }else{
                currentPlayer = (currentPlayer == 'X')?'O':'X';
            }

        }

        sc.close();

    }


    public static void main(String[] args){
        Game tictactoe = new Game();
        tictactoe.play();
        
    }
}
