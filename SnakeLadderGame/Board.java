package SnakeLadderGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int[] board;
    List<Snake> snakes;
    List<Ladder> ladders;

    Board(){
        this.board = new int[101];
        for(int i=0;i<101;i++)
            this.board[i]=0;

        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public void addSnake(Snake snake){
        if(this.board[snake.head]!=0){
            System.out.println("Ladder or Snake already exists at this position!");
            return;
        } 

        this.board[snake.head]= snake.tail - snake.head;
        snakes.add(snake);
    }

    public void addLadder(Ladder ladder){
        if(this.board[ladder.startPos]!=0){
            System.out.println("Ladder or Snake already exists at this position!");
            return;
        } 

        this.board[ladder.startPos]=ladder.endPos - ladder.startPos;
        ladders.add(ladder);
    }
}
