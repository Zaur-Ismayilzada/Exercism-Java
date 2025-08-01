import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



class Matrix {

	private List<List<Integer>> values = new ArrayList<List<Integer>>();
	
    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<MatrixCoordinate>();
		
		for (int i = 0; i < values.size(); i++){
			int max = rowMax(i);
			for (int j = 0; j < values.get(i).size(); j++){
				int min = colMin(j);
				
				if (values.get(i).get(j) == max &&
				    values.get(i).get(j) == min)
					result.add(new MatrixCoordinate(i + 1, j + 1));
			}
		}
		
		return result;
    }
	
	private int rowMax (int row){
		int max = -1;
		
		List<Integer> temp = values.get(row);
		
		for (int i = 0; i < temp.size(); i++)
			if (max < temp.get(i))
				max = temp.get(i);
		
		return max;
	}
	
	private int colMin (int col){
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < values.size(); i++){
			int temp = values.get(i).get(col);
			
			if (min > temp)
				min = temp;
		}
		
		return min;
	}
}
