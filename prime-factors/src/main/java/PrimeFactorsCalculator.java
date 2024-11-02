import java.util.List;
import java.util.ArrayList;
class PrimeFactorsCalculator{

	private long[] primes;

	PrimeFactorsCalculator(){
		primes = get_primes();
	}

	private long[] get_primes(){
		long[] temp = new long[1000000];

		//fill
		for (int i = 0; i < temp.length; i++){
			temp[i] = i + 2;
		}

		int factor = 2;

		for (int i = 0; i < temp.length; i++){
			if (temp[i] != 0){
				while (factor * (int)temp[i] - 2 < temp.length){
					temp[factor * (int)temp[i] - 2] = 0;
					factor++;
				}

				factor = 2;
			}
		}

		int count = 0;

		for (int i = 0; i < temp.length; i++){
			if (temp[i] != 0)count++;
		}

		long[] primes = new long[count];

		int k = 0;
		for (int i = 0; i < temp.length; i++){
			if (temp[i] != 0){primes[k] = temp[i]; k++;}
		}

		return primes;
	}
	
	public List<Long> calculatePrimeFactorsOf (long num){
		List<Long> list   = new ArrayList<Long>();

		for (int i = 0; i < primes.length; i++){
			while (true){
				if (num % primes[i] == 0){list.add(primes[i]); num /= primes[i];}
				else break;
			}
		}

		return list;
	}
} 
