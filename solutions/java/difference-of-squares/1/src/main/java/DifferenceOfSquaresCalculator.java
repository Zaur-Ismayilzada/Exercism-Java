class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
		if (input == 1)
			return 1;
		if (input == 0)
			return 0;
			
		int sum = (input) * (input + 1) / 2;
		return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
    	if (input == 1)
	   		return 1;
		if (input == 0)
			return 0;
		return input * input  + computeSumOfSquaresTo(input - 1);
    }

    int computeDifferenceOfSquares(int input) {
         return (int) Math.abs(computeSquareOfSumTo(input) - computeSumOfSquaresTo(input)); 
    }

}
