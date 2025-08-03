class StateOfTicTacToe {
    public GameState determineState(String[] board) {
    	
    	boolean x_win = win('X', board);
    	boolean o_win = win('O', board);
    	int     x_num = count('X', board);
    	int     o_num = count('O', board);
    	int     __num = count(' ', board);
    	
    	if (o_num > x_num)
    		throw new IllegalArgumentException("Wrong turn order: O started");
    	
    	if (x_num - o_num >= 2)
    		throw new IllegalArgumentException("Wrong turn order: X went twice");
    	
    	if (x_win && o_win)
    		throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
    	
    	if (x_win)
    		return GameState.WIN;
    	if (o_win)
    		return GameState.WIN;
    	
    	if (__num == 0)
    		return GameState.DRAW;
    	
    	return GameState.ONGOING;
    }
    
    private boolean win(Character chr, String[] board) {
    	String win_strike = "" + chr + chr + chr;
    	
    	if (board[0].charAt(0) == chr &&
    		board[1].charAt(1) == chr &&
    		board[2].charAt(2) == chr)
    		return true;
    	
    	if (board[0].charAt(2) == chr &&
    		board[1].charAt(1) == chr &&
    		board[2].charAt(0) == chr)
    		return true;
    	
    	if (board[0].equals(win_strike) ||
    		board[1].equals(win_strike) ||
    		board[2].equals(win_strike))
    		return true;
    	
    	if (board[0].charAt(0) == chr &&
    		board[1].charAt(0) == chr &&
    		board[2].charAt(0) == chr)
    		return true;
    	
    	if (board[0].charAt(1) == chr &&
        	board[1].charAt(1) == chr &&
        	board[2].charAt(1) == chr)
        		return true;
    	
    	if (board[0].charAt(2) == chr &&
        	board[1].charAt(2) == chr &&
        	board[2].charAt(2) == chr)
        		return true;
    		
    	
    	
    	return false;
    }
    
    private int count(Character chr, String[] board) {
    	int res = 0;
    	for (String temp : board) {
    		for (int i = 0; i < temp.length(); i++) {
    			if (temp.charAt(i) == chr)
    				res++;
    		}
    	}
    	
    	return res;
    }
}