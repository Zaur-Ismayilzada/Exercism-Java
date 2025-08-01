import java.util.List;
import java.util.ArrayList;
class Sieve {
	private int maxPrime;
	
    Sieve(int maxPrime) {
        this.maxPrime =  maxPrime;
    }

    List<Integer> getPrimes() {
        int[] arr = new int[maxPrime + 1];
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = i;
		
		arr[1] = 0;
		
		int prime;
		int k;
		
		for (int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				prime = arr[i];
				k     = 2;
				while (k * prime < arr.length){
					arr[k* prime] = 0;
					k++;
				}
			}
		}
		
		for (int a : arr)
			if (a != 0)
				list.add(a);
				
		return list;
    }
}
