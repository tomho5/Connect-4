import java.util.Random;
public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board){
        Random random = new Random();
        int move = -3;
        int row = 0;
        for(int i = 0; i < 7; i++){
            //Check for empty spot in the column to place the symbol, then the AI checks if a winning move for itself is available then it would make that move.
		    for(int y = 0; y < 6; y++){
                if (board.getMove(y,i) == '_'){
                row = y;
                }
            }
            if (board.winningMove(i,symbol) == true){
                move = i;
            }
        }

        if(move != -3){
            for(int y = 0; y < 6; y++){
                if (board.getMove(y,move) == '_'){
                row = y;}
                }
            board.saveMove(row,move,symbol);
        }
        else{
            //Now it checks if the enemy has one or more winning moves and if they do, the AI will attempt to block one of the winning moves.
            for(int i = 0; i < 7; i++){
                
                if(board.enemywinningMove(i,symbol) == true){
                    move = i;
                }
            }
            if(move != -3){
                for(int y = 0; y < 6; y++){
                    if (board.getMove(y,move) == '_'){
                    row = y;}
                    }
                board.saveMove(row,move,symbol);
            }
            else{
                //Else the AI would just place it's symbol randomly on the board
                move = random.nextInt(7);
               
                //Check if row is available to store the input on the board
                boolean available;
                available = false;
                
                while(available == false){
                    move = random.nextInt(7);
                    for(int y = 0; y < 6; y++){
                        if (board.getMove(y,move) == '_'){
                        row = y;
                        available = true;
                        }
                    }
                    

                    
                }
                board.saveMove(row,move,symbol);
                
                
                
            }
            board.saveMove(row,move,symbol);
        }
        
    
            
      

    }

  
    
}
