import java.util.List;
import java.util.ArrayList;

class NaturalNumber {

	private int number;
	
	public NaturalNumber (int number){
		
		if (number <= 0)
			throw new IllegalArgumentException("You must supply a natural number (positive integer)");
	
		this.number = number;
	}
	
	public Classification getClassification(){
		List<Integer> list = getFactors(number);
		
		int sum = 0;
		
		for (int a : list)
			sum += a;
		
		if (sum == number)
			return 	Classification.PERFECT;
		else if (sum > number)
			return Classification.ABUNDANT;
		else //if (sum < number)
			return Classification.DEFICIENT;
	}
	
	private List<Integer> getFactors(int number){
		List<Integer> list = new ArrayList<Integer>();
		int k = 1;
		
		while (k < number){
			if (number % k == 0)
				list.add(k);
			k++;
		}
		
		return list;
	}	
	

}
