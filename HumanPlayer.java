import  java.util.Scanner;
public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }


    public void makeMove(Board board){
        int move;
        Scanner reader = new Scanner(System.in);
        System.out.println(name + ", please input your move: ");
        move = Integer.parseInt(reader.next())-1;
        //Check if row is available to store the input on the board
        boolean available;
        int row = 0;
        available = false;

        for(int y = 0; y < 6; y++){
            if (board.getMove(y,move) == '_'){
            row = y;
            available = true;
            }
        }
        board.saveMove(row,move,symbol);
    
        while (available == false){
            System.out.println("This column is full, please select another column as input");
            System.out.println(name + ", please input another move: ");
            move = Integer.parseInt(reader.next())-1;
            for(int y = 0; y < 6; y++){
                if (board.getMove(y,move) == '_'){
                row = y;
                available = true;
                }
            }
        }
        board.saveMove(row,move,symbol);
        
    }
}

  

