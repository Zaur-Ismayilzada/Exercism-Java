import java.util.List;
import java.util.ArrayList;

public class PascalsTriangleGenerator {
	
	public int[][] generateTriangle(int row){
		if (row == 0)
			return new int[][]{};
			
		List<Integer>[] arr_list = new ArrayList[row];

		for (int i = 0; i < row; i++)
			arr_list[i] = new ArrayList<Integer>();
        
		arr_list[0].add(1);
		
		if (row > 1)
			{arr_list[1].add(1); arr_list[1].add(1);}
		else
			return toArray(arr_list);
		
		for (int i = 2; i < row; i++){
			arr_list[i].add(1);
			
			for (int j = 1; j < i; j++){
				arr_list[i].add(arr_list[i - 1].get(j) + arr_list[i - 1].get(j - 1));
			}
			
			arr_list[i].add(1);
		}
		
		return toArray(arr_list);
	}
	
	private int[][] toArray(List<Integer>[] arr){
		int[][] result = new int[arr.length][];
		
		for (int i = 0; i < result.length; i++){
			result[i] = new int[arr[i].size()];
			
			for (int j = 0; j < result[i].length; j++){
				result[i][j] = arr[i].get(j);
			}
			
		}
		
		return result;
	}
}