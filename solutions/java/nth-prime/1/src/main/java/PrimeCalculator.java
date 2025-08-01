class PrimeCalculator {

    private int[] primes;

    PrimeCalculator(){
        int[] temp = new int[120000];

        for (int i = 0; i < temp.length; i++)
            temp[i] = i + 2;

        int factor = 2;

        for (int i = 0; i < temp.length; i++){
            if (temp[i] != 0){
                factor = 2;
                while (factor * temp[i] - 2 < temp.length){
                    temp[factor * temp[i] - 2] = 0;
                    factor++;
                }    
            }
        }

        int count = 0;

        for (int num : temp){
            if (num != 0)
                count++;
        }

        primes = new int[count];

        int k  = 0;

        for (int i = 0; i < temp.length; i++){
            if (temp[i] != 0){
                primes[k] = temp[i];
                k++;
            }
        }
    }

    int nth(int nth) {
        if (nth < 1)throw new IllegalArgumentException();
        return primes[nth - 1];
    }

}
