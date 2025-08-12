import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class WordSearcher {
    Map<String, Optional<WordLocation>> search(final Set<String> words, final char[][] grid) {
    	Map<String, Optional<WordLocation>> res = new HashMap<>();
    	
    	
        for (String word : words) {
        	//check row-wise
        	for (int i = 0; i < grid.length; i++){
        		String row_str = get_word_from_grid_row(grid[i]);
        		
        		int idx = row_str.indexOf(word);
        		
        		if (idx != -1) {
        			int start = idx + 1;
        			int end   = word.length() + idx;
        			WordLocation wl = new WordLocation(new Pair(start, i + 1), new Pair(end, i + 1));
        			
        			res.put(word, Optional.of(wl));
        		}
        	}
        	
        	//check row-wise reversed
        	
        	for (int i = 0; i < grid.length; i++) {
        		String row_str = get_word_from_grid_row_reversed(grid[i]);
        		
        		int idx = row_str.indexOf(word);
        		
        		if (idx != -1) {
        			int start = row_str.length() - idx;
        			int end   = start - word.length() + 1;
        			WordLocation wl = new WordLocation(new Pair(start, i + 1), new Pair(end, i + 1));
        			
        			res.put(word, Optional.of(wl));
        		}
        	}
        	
        	//check col-wise
        	for (int col = 0; col < grid[0].length; col++) {
        		String col_str = get_word_from_grid_col(grid, col);
        		
        		int idx = col_str.indexOf(word);
        		
        		if (idx != -1) {
        			int start = idx + 1;
        			int end   = idx + word.length();
        			WordLocation wl = new WordLocation(new Pair(col + 1, start), new Pair(col + 1, end));
        			
        			res.put(word, Optional.of(wl));
        		}
        	}
        	
        	//check col-wise reversed
        	for (int col = 0; col < grid[0].length; col++) {
        		String col_str = get_word_from_grid_col_reversed(grid, col);
        		
        		int idx = col_str.indexOf(word);
        		
        		if (idx != -1) {
        			int start = col_str.length() - idx;
        			int end   = start - word.length() + 1;
        			WordLocation wl = new WordLocation(new Pair(col + 1, start), new Pair(col + 1, end));
        			
        			res.put(word, Optional.of(wl));
        		}
        	}
        	
        	//for diagonal check
        	if (!res.containsKey(word)) {
        		for (int row = 0; row < grid.length; row++) {
        			for (int col = 0; col < grid[0].length; col++) {
        				Point p = get_diagonal(word, grid, row, col);
        				
        				if (p == null)continue;
        				
        				
        				WordLocation wl = new WordLocation(new Pair(p.y1 + 1, p.x1 + 1), new Pair(p.y2, p.x2));
        				
        				res.put(word, Optional.of(wl));
        			}
        		}
        	}
        	
        	if (!res.containsKey(word))
        		res.put(word, Optional.empty());
        }
        
        return res;
    }
    
    private String get_word_from_grid_row(char[] grid) {
    	String res = "";
    	
    	for (char chr : grid)
    		res += chr;
    	
    	return res;
    }
    
    private String get_word_from_grid_row_reversed(char[] grid) {
    	String res = "";
    	
    	for (int i = grid.length - 1; i >= 0; i--) {
    		res += grid[i];
    	}
    	
    	return res;
    }
    
    private String get_word_from_grid_col(char[][] grid, int col) {
    	String res = "";
    	
    	for (char[] row : grid)
    		res += row[col];
    	
    	return res;
    }
    
    private String get_word_from_grid_col_reversed(char[][] grid, int col) {
    	String res = "";
    	
    	for (int i = grid.length - 1; i >= 0; i--)
    		res += grid[i][col];
    	
    	return res;
    }
    
    private Point get_diagonal(String word, char[][] grid, int row, int col) {
    	int len = word.length() - 1;
    	
    	//top left
    	if (row - len >= 0 && col - len >= 0) {
    		String str = "";
    		int    l   = len;
    		int   row_ = row;
    		int   col_ = col;
    		
    		while (l >= 0) {
    			str += grid[row_][col_];
    			row_--;
    			col_--;
    			l--;
    		}
    		
    		row_ += 2;
    		col_ += 2;
    		
    		if (word.equals(str)) {
    			return new Point(row, col, row_, col_);
    		}
    	}
    	
    	//top right
    	if (row - len >= 0 && col + len < grid[0].length) {
    		String str = "";
    		int    l   = len;
    		int   row_ = row;
    		int   col_ = col;
    		
    		while (l >= 0) {
    			str += grid[row_][col_];
    			row_--;
    			col_++;
    			l--;
    		}
    		
    		row_ += 2;
    		
    		
    		if (word.equals(str)) {
    			return new Point(row, col, row_, col_);
    		}
    	}
    	
    	//bottom left
    	if (row + len < grid.length && col - len >= 0) {
    		String str = "";
    		int    l   = len;
    		int   row_ = row;
    		int   col_ = col;
    		
    		while (l >= 0) {
    			str += grid[row_][col_];
    			row_++;
    			col_--;
    			l--;
    		}
    		
    		col_ += 2;
    		
    		if (word.equals(str)) {
    			return new Point(row, col, row_, col_);
    		}
    	}
    	
    	//bottom right
    	if (row + len < grid.length && col + len < grid[0].length) {
    		String str = "";
    		int    l   = len;
    		int   row_ = row;
    		int   col_ = col;
    		
    		while (l >= 0) {
    			str += grid[row_][col_];
    			row_++;
    			col_++;
    			l--;
    		}
    		
    		if (word.equals(str)) {
    			return new Point(row, col, row_, col_);
    		}
    	}
    	
    	
    	return null;
    }
}

class Point{
	int x1, x2, y1, y2;
	
	Point(int x1, int y1, int x2, int y2){
		this.x1    = x1;
		this.x2    = x2;
		this.y1    = y1;
		this.y2    = y2;
	}
}