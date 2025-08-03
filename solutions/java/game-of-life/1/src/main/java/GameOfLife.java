class GameOfLife {
    public int[][] tick(int[][] matrix){
        if (matrix.length == 0)
        	return new int[][]{};
        	
        int[][] res = new int[matrix.length][matrix.length];
        
        for (int row = 0; row < matrix.length; row++) {
        	for (int col = 0; col < matrix.length; col++) {
        		int _count = count(row, col, matrix);
        		res[row][col] = 0;
        		
        		if (matrix[row][col] == 0) {
        			if (_count == 3)
        				res[row][col] = 1;
        		}else if (matrix[row][col] == 1) {
        			if (_count == 2 || _count == 3)
        				res[row][col] = 1;
        		}
        	}
        }
        
        return res;
    }
    
    private int count(int row, int col, int[][] matrix) {
    	int res = 0;
    	
    	if (col - 1 >= 0 && matrix[row][col - 1] == 1)
    		res++;
    	
    	if (col + 1 < matrix.length && matrix[row][col + 1] == 1)
    		res++;
    	
    	if (row - 1 >= 0) {
    		if (matrix[row - 1][col] == 1)
    			res++;
    		
        	if (col - 1 >= 0) {
        		if (matrix[row - 1][col - 1] == 1)
        			res++;
        	}
        	
        	if (col + 1 < matrix.length) {
        		if (matrix[row - 1][col + 1] == 1)
        			res++;
        	}
    	}
    	
    	if (row + 1 < matrix.length) {
    		if (matrix[row + 1][col] == 1)
    			res++;
    		
        	if (col - 1 >= 0) {
        		if (matrix[row + 1][col - 1] == 1)
        			res++;
        	}
        	
        	if (col + 1 < matrix.length) {
        		if (matrix[row + 1][col + 1] == 1)
        			res++;
        	}
    	}
    	
    	return res;	
    }
}
