import java.util.List;
import java.util.ArrayList;

class SumOfMultiples {
	
	private int number;
	private int[] set;
	
    SumOfMultiples(int number, int[] set) {
        this.number = number;
		this.set    = set;
    }

    int getSum() {
		
		if (number == 1)
			return 0;
	
        List<Integer> list = new ArrayList<Integer>();
		int sum            = 0;
		
		for (int i = 0; i < set.length; i++){
			int factor = set[i];
			int k      = 1;
			
			while (k < number){
				if (factor != 0 && k % factor == 0 && !list.contains(k))
					list.add(k);
					
				k++;
			}
		}
		
		
		
		for (int a : list)
			sum += a;
			
		return sum;
    }
}
