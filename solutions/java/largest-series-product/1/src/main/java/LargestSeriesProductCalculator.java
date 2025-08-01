class LargestSeriesProductCalculator {

	private String number;
	
    LargestSeriesProductCalculator(String inputNumber) {
		
		if (!isValid(inputNumber))
			throw new IllegalArgumentException("String to search may only contain digits.");
	
        number = inputNumber;
    }
	
	private boolean isValid (String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		
		return true;
	}

    long calculateLargestProductForSeriesLength(int n) {
        long max = 0L;
		long tem = 0L;
		int  idx = 0;
		
		if (n > number.length())
			throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
		if (n < 0)
			throw new IllegalArgumentException("Series length must be non-negative.");
        if (n == 0 && number.isEmpty())
                return 1;
		
		
		for (int i = 0; i < number.length(); i++){
			if (number.length() - i < n)
				break;
				
			tem = 1L;
			idx = i;
			
			for (int j = 0; j < n; j++){
				tem *= Character.getNumericValue(number.charAt(idx));
				idx++;
			}
			
			if (max < tem)
				max = tem;
		}
		
		return max;
    }
}
