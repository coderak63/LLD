package TicTacToe;

public class Board {
    char board[];

    Board(){
        board = new char[9];
        for(int i=0;i<9;i++){
            board[i]=(char)('1'+i);
        }

    }

    public void printBoard(){
        for(int i=0;i<9;i++){
            System.out.print(this.board[i]);

            if(i==2 || i==5 || i==8)
                System.out.println();
            else
                System.out.print(" | ");
        }
    }

    public boolean insertInBoard(int pos,char c){
        if(!(pos>=1 && pos<=9)){
            System.out.println("Please choose between 1 to 9");
            return false;
        }
        if(this.board[pos-1]=='X'||this.board[pos-1]=='O'){
            System.out.println("Please choose another position, this position is already occupied.");
            return false;
        }
            
        
        this.board[pos-1] = c;
        printBoard();
        return true;
    }

    public boolean checkForWin(){
        if(this.board[0]==this.board[1] && this.board[1]==this.board[2])
            return true;

        if(this.board[3]==this.board[4] && this.board[4]==this.board[5])
            return true;

        if(this.board[6]==this.board[7] && this.board[7]==this.board[8])
            return true;

        if(this.board[0]==this.board[3] && this.board[3]==this.board[6])
            return true;

        if(this.board[1]==this.board[4] && this.board[4]==this.board[7])
            return true;

        if(this.board[2]==this.board[5] && this.board[5]==this.board[8])
            return true;

        if(this.board[0]==this.board[4] && this.board[4]==this.board[8])
            return true;

        if(this.board[2]==this.board[4] && this.board[4]==this.board[6])
            return true;

        return false;
    }

    public boolean checkForTie(){
        for(int i=0;i<9;i++){
            if(!(this.board[i]=='X'||this.board[i]=='O')){
                return false;
            }
        }
        return true;
    }
}
