import java.util.ArrayList;
import java.util.List;

class FlowerFieldBoard {
	
	char[][] board;

    FlowerFieldBoard(List<String> boardRows) {
    	board = make_board(boardRows);
    	
    	enumerate(board);
    }

    List<String> withNumbers() {
        List<String> res = new ArrayList<String>();
        
        if (board.length == 0)
        	return res;
        
        for (int i = 0; i < board.length; i++) {
        	String temp = "";
        	
        	for (int j = 0; j < board[i].length; j++)
        		temp += board[i][j];
        	
        	res.add(temp);
        }
        
        return res;
    }
    
    private char[][] make_board(List<String> rows){
    	if (rows.isEmpty())
    		return new char[][]{};
    	
    	char[][] res = new char[rows.size()][rows.get(0).length()];
    	
    	for (int i = 0; i < res.length; i++) {
    		for (int j = 0; j < res[i].length; j++)
    			res[i][j] = rows.get(i).charAt(j);
    	}
    	   	
    	return res;
    }
    
   private void enumerate(char[][] board) {
	   for (int row = 0; row < board.length; row++) {
		   for (int col = 0; col < board[row].length; col++) {
			   if (board[row][col] == '*')
				   continue;
			   
			   int count = 0;
			   
			   if (row - 1 >= 0) {
				   if (board[row - 1][col] == '*')
					   count++;
				   
				   if (col - 1 >= 0 && board[row - 1][col - 1] == '*')
					   count++;
				   
				   if (col + 1 < board[row].length && board[row - 1][col + 1] == '*')
					   count++;   
			   }
			   
			   if (row + 1 < board.length) {
				   if (board[row + 1][col] == '*')
					   count++;
				   
				   if (col - 1 >= 0 && board[row + 1][col - 1] == '*')
					   count++;
				   
				   if (col + 1 < board[row].length && board[row + 1][col + 1] == '*')
					   count++; 
			   }
			   
			   if (col - 1 >= 0 && board[row][col - 1] == '*')
				   count++;
			   
			   if (col + 1 < board[row].length && board[row][col + 1] == '*')
				   count++;
			   
			   if (count == 0)
				   continue;
			   
			   board[row][col] = (char)(count + '0');
		   }
	   }
   }

}