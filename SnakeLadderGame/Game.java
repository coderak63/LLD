package SnakeLadderGame;

import java.util.List;
import java.util.Scanner;

public class Game {
    Board board;
    Dice dice;
    List<Player> players;

    Game(Board board, List<Player> players){
        this.board = board;
        this.dice = new Dice();
        this.players = players;
    }

    public void play(){
        boolean gameNotOver = true;
        Scanner sc = new Scanner(System.in);
        while(gameNotOver){
            for(int i=0;i<players.size();i++){
                System.out.println("Player"+(i+1)+" - "+players.get(i).name+": Current Position: "+players.get(i).getPlayerPosition());
                System.out.println("Press any key to roll the dice!");
                sc.nextLine();

                int outcome = this.dice.throwDice();
                System.out.println("Dice: "+outcome);

                changePlayerPositionOnBoard(players.get(i), outcome);
                
                boolean win = checkforWin(players.get(i));
                if(win){
                    System.out.println(players.get(i).name+" won!!!");
                    gameNotOver = false;
                    break;
                }
            }
        }
    }

    public void changePlayerPositionOnBoard(Player player,int outcome){
        int player_current_pos = player.getPlayerPosition();

        if((player_current_pos + outcome)>100){
            System.out.println("Play not allowed for this dice outcome!");
            System.out.println();
            return;
        }
        int player_new_pos = player_current_pos + outcome;
        System.out.println("Moved from: "+player_current_pos+" -> "+player_new_pos);

        if(board.board[player_new_pos]>0){
            System.out.println("Ladder from: "+player_new_pos+" -> "+(player_new_pos+board.board[player_new_pos]));
            player_new_pos += board.board[player_new_pos];
        }

        if(board.board[player_new_pos]<0){
            System.out.println("Snake from: "+player_new_pos+" -> "+(player_new_pos+board.board[player_new_pos]));
            player_new_pos += board.board[player_new_pos];
        }

        player.setPlayerPosition(player_new_pos);
        System.out.println("Final Position: "+player_new_pos);
        System.out.println();
    }

    public boolean checkforWin(Player player){
        return player.getPlayerPosition() == 100;
    }


}