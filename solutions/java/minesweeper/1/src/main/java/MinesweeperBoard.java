import java.util.List;
import java.util.ArrayList;

public class MinesweeperBoard{
	
	private List<String> input;
	
	public MinesweeperBoard(List<String> input){
		this.input = input;
	}
	
	public List<String> withNumbers(){
		 List<String> result;
		 
		 if (input.isEmpty() || input.get(0).isEmpty())
		 	return input;
		 
		 char[][] arr = toArray(input);
		 
		 numberArr(arr);
		 
		 result = toList(arr);
		 return result;
	}
	
	private char[][] toArray(List<String> input){
		int row = input.size();
		int col = input.get(0).length();
		char[][] arr = new char[row][col];
		
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				arr[i][j] = input.get(i).charAt(j);
			}
		}
		
		return arr;
	}
	
	private void numberArr(char[][] arr){
		int temp = 0;
		int row  = arr.length;
		int col  = arr[0].length;
		 
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				if (arr[i][j] == '*') continue;
				
				if (i == 0 && j == 0){
					if (j + 1 < col && arr[i][j + 1] == '*')
						temp++;
					if (i + 1 < row && arr[i + 1][j] == '*')
						temp++;
					if (i + 1 < row && j + 1 < col && arr[i + 1][j + 1] == '*')
						temp++;
				}
				
				else if (i == row - 1 && j == 0){
					if (i - 1 >= 0  &&  arr[i - 1][j] == '*')
						temp++;
					if (j + 1 < col &&  arr[i][j + 1] == '*')
						temp++;
					if (i - 1 >= 0 && j + 1 < col && arr[i - 1][j + 1] == '*')
						temp++;
				}
				
				else if (i == 0 && j == col - 1){
					if (i + 1 < row &&  arr[i + 1][j] == '*')
						temp++;
					if (j - 1 >= 0  &&  arr[i][j - 1] == '*')
						temp++;
					if (i + 1 < row && j - 1 >= 0 && arr[i + 1][j - 1] == '*')
						temp++;			
				}
				
				else if (i == row - 1 && j == col - 1){
					if (i - 1 >= 0 &&  arr[i - 1][j] == '*')
						temp++;
					if (j - 1 >= 0 &&  arr[i][j - 1] == '*')
						temp++;
					if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == '*')
						temp++;					
				}
				
				else if (i == 0){
					if (j - 1 >= 0 &&  arr[i][j - 1] == '*')
						temp++;
					if (j - 1 >= 0 && i + 1 < row && arr[i + 1][j - 1] == '*')
						temp++;
					if (i + 1 < row && arr[i + 1][j] == '*')
						temp++;			
					if (i + 1 < row && j + 1 < col && arr[i + 1][j + 1] == '*')
						temp++;
					if (j + 1 < col && arr[i][j + 1] == '*')
						temp++;			
				}
				
				else if (i == row - 1){
					if (j - 1 >= 0 &&  arr[i][j - 1] == '*')
						temp++;
					if (j - 1 >= 0 && i - 1 >= 0 && arr[i - 1][j - 1] == '*')
						temp++;
					if (i - 1 >= 0 && arr[i - 1][j] == '*')
						temp++;			
					if (i - 1 >= 0 && j + 1 < col && arr[i - 1][j + 1] == '*')
						temp++;
					if (j + 1 < col && arr[i][j + 1] == '*')
						temp++;		
				}

				else if (j == 0){
					if (i - 1 >= 0 &&  arr[i - 1][j] == '*')
						temp++;
					if (j + 1 < col && i - 1 >= 0 && arr[i - 1][j + 1] == '*')
						temp++;
					if (j + 1 < col && arr[i][j + 1] == '*')
						temp++;			
					if (i + 1 < row && j + 1 < col && arr[i + 1][j + 1] == '*')
						temp++;
					if (i + 1 < row && arr[i + 1][j] == '*')
						temp++;		
				}

				else if (j == col - 1){
					if (i - 1 >= 0 &&  arr[i - 1][j] == '*')
						temp++;
					if (j - 1 >= 0 && i - 1 >= 0 && arr[i - 1][j - 1] == '*')
						temp++;
					if (j - 1 >= 0 && arr[i][j - 1] == '*')
						temp++;			
					if (i + 1 < row && j - 1 >= 0 && arr[i + 1][j - 1] == '*')
						temp++;
					if (i + 1 < row && arr[i + 1][j] == '*')
						temp++;		
				}
				
				else{
					if (i - 1 >= 0 && arr[i - 1][j] == '*')
						temp++;
					if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == '*')
						temp++;
					if (j - 1 >= 0 && arr[i][j - 1] == '*')
						temp++;
					if (i + 1 < row && j - 1 >= 0 && arr[i + 1][j - 1] == '*')
						temp++;
					if (i + 1 < row && arr[i + 1][j] == '*')
						temp++;
					if (i + 1 < row && j + 1 < col && arr[i + 1][j + 1] == '*')
						temp++;
					if (j + 1 < col && arr[i][j + 1] == '*')
						temp++;
					if (i - 1 >= 0 && j + 1 < col && arr[i - 1][j + 1] == '*')
						temp++;
				}
					
				if (temp != 0)
					arr[i][j] = toChar(temp);
				temp      = 0;
			}
		}
	}
	
	private char toChar(int num){
		switch(num){
			case 1: return '1';
			case 2: return '2';
			case 3: return '3';
			case 4: return '4';
			case 5: return '5';
			case 6: return '6';
			case 7: return '7';
			case 8: return '8';
			case 9: return '9';
		}
        return '0';
	}
	
	private List<String> toList(char [][] arr){
		List<String> result = new ArrayList<String>();
		
		String temp = "";
		
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				temp += arr[i][j];
			}
			result.add(temp);
			temp = "";
		}
		return result;
	}
	
}
