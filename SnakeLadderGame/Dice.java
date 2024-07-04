package SnakeLadderGame;

import java.util.Random;

public class Dice {
    Random rand;
    Dice(){
        rand = new Random();
    }
    
    public int throwDice(){
        // Generate random integers in range 0 to 5
        int rand_int = rand.nextInt(6);
        return rand_int+1;
    }
}
