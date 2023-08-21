public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] board;
	private char[] symbols = new char[2];
	

	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	
	public Board() {
		board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				board[i][j] = '_';
			}
		}
	}
	
	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++){
			System.out.print("| ");
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	
	
	public boolean containsWin() {
		// Check for patterns of 4 horizontally
		for (int i = 0; i<NUM_OF_COLUMNS ; i++){
			for (int j = 0; j<NUM_OF_ROW-3; j++){
				if (board[j][i] != '_'){
					if (this.board[j][i] == this.board[j+1][i] && this.board[j][i] == this.board[j+2][i] && this.board[j][i] == this.board[j+3][i]){
						return true;
					}  
				}         
			}
		}
		
		// Check for patterns of 4 vertically
		for (int i = 0; i<NUM_OF_COLUMNS-3 ; i++ ){
			for (int j = 0; j<NUM_OF_ROW; j++){
				if (board[j][i] != '_'){
					if (this.board[j][i] == this.board[j][i+1] && this.board[j][i] == this.board[j][i+2] && this.board[j][i] == this.board[j][i+3]){
						return true;
					} 
				}          
			}
		}

		// Check for upwards diagonal patterns of 4
    	for (int i=0; i<NUM_OF_COLUMNS-3; i++){
        	for (int j=3; j<NUM_OF_ROW; j++){
				if (board[j][i] != '_'){
            		if (board[j][i] == board[j-1][i+1] &&  board[j][i] == board[j-2][i+2] && board[j][i] == board[j-3][i+3]){
                		return true;
					}
				}
        	}
    	}
    	// Check for downwards diagonal patterns of 4
    	for (int i=0; i<NUM_OF_COLUMNS-3; i++){
        	for (int j=0; j<NUM_OF_ROW-3; j++){
				if (board[j][i] != '_'){
            		if (board[j][i] == board[j+1][i+1] && board[j][i] == board[j+2][i+2] && board[j][i] == board[j+3][i+3]){
                		return true;
					}
				}
        	}
    	}

  		return false;
	}
	
	public boolean isTie() {
		
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				if (board[i][j] == '_' && containsWin() == false){
					return false;
				} 
			}
		}
		
		return true;
	}
	
	
	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				board[i][j] = '_';
			}
		}
	}

	public void saveMove(int row, int column, char symbol){
		board[row][column] = symbol;
		if(symbols[0] == '\u0000'){
			symbols[0] = symbol;
		}
		else if(symbols[1] == '\u0000'){
			symbols[1] = symbol;
		}

	}

	public char getMove(int row, int column){
		return board[row][column];
	}
	

	public boolean winningMove(int move, char symbol){
		Board copy_board = new Board();
		

		int row = 0;
		//Make a copy of the board
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				copy_board.board[i][j] = board[i][j];
			}
		}
		//Check for empty spot in the column to place the symbol
		for(int y = 0; y < 6; y++){
            if (copy_board.getMove(y,move) == '_'){
            row = y;
            }
        }
		//Place the move into the new copy board
		copy_board.saveMove(row,move,symbol);

		//After the move was placed onto the board,check if it now contains a win, if it does, return true
		if (copy_board.containsWin() == true){
			return true;
		}
		return false;
		

	}

	public boolean enemywinningMove(int move,char symbol){
		Board copy_board = new Board();
		char enemy_symbol ;
		//Figure out what the enemy symbol is by the AI knowing it's own symbol
		if (symbols[0] == symbol){
			enemy_symbol = symbols[1];
		}
		else{
			enemy_symbol = symbols[0];
		}

		int row = 0;
		//Make a copy of the board
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j<NUM_OF_COLUMNS;j++){
				copy_board.board[i][j] = board[i][j];
			}
		}
		//Check for empty spot in the column to place the symbol
		for(int y = 0; y < 6; y++){
            if (copy_board.getMove(y,move) == '_'){
            row = y;
            }
        }
		//Place the move into the new copy board
		copy_board.saveMove(row,move,enemy_symbol);

		//After the move was placed onto the board,check if it now contains a win, place the move on the actual board
		if (copy_board.containsWin() == true){
			return true;
		}
		return false;
		
		


		
	}
	
}
