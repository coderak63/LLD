package SnakeLadderGame;

public class Player {
    String name;
    private int playerPosition;

    Player(String name){
        this.name=name;
        this.playerPosition=0;
    }

    public void setPlayerPosition(int x){
        this.playerPosition=x;
    }

    public int getPlayerPosition(){
        return this.playerPosition;
    }
}
