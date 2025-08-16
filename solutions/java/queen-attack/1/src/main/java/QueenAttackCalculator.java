class QueenAttackCalculator {
	
	Queen queen1;
	Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) {
    	if (queen1 == null || queen2 == null)
    		throw new IllegalArgumentException("You must supply valid positions for both Queens.");
    	
    	if (queen1.row == queen2.row && queen1.col == queen2.col)
    		throw new IllegalArgumentException("Queens cannot occupy the same position.");
    	
    	
        this.queen1 = queen1;
        this.queen2 = queen2;
        
        
    }

    boolean canQueensAttackOneAnother() {
        if (queen1.row == queen2.row || queen1.col == queen2.col)
        	return true;
        
        if (queen2.row < queen1.row && queen2.col < queen1.col)
        	return first_diagonal(queen1, queen2);
        
        if (queen2.row < queen1.row && queen2.col > queen1.col)
        	return second_diagonal(queen1, queen2);
        
        if (queen2.row > queen1.row && queen2.col < queen1.col)
        	return third_diagonal(queen1, queen2);
        
        if (queen2.row > queen1.row && queen2.col > queen1.col)
        	return fourth_diagonal(queen1, queen2);
        
        return false;
    }
    
    private boolean first_diagonal(Queen q1, Queen q2) {
    	int row = q2.row;
    	int col = q2.col;
    	
    	while (row < q1.row && col < q1.col) {
    		row++;
    		col++;
    	}
    	
    	return row == q1.row && col == q1.col;
    }
    
    private boolean second_diagonal(Queen q1, Queen q2) {
    	int row = q2.row;
    	int col = q2.col;
    	
    	while (row < q1.row && col > q1.col) {
    		row++;
    		col--;
    	}
    	
    	return row == q1.row && col == q1.col;
    }
    
    private boolean third_diagonal(Queen q1, Queen q2) {
    	int row = q2.row;
    	int col = q2.col;
    	
    	while (row > q1.row && col < q1.col) {
    		row--;
    		col++;
    	}
    	
    	return row == q1.row && col == q1.col;
    }
    
    private boolean fourth_diagonal(Queen q1, Queen q2) {
    	int row = q2.row;
    	int col = q2.col;
    	
    	while (row > q1.row && col > q1.col) {
    		row--;
    		col--;
    	}
    	
    	return row == q1.row && col == q1.col;
    }
}