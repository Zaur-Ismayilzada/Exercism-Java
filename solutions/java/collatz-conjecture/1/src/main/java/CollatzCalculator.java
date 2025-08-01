class CollatzCalculator {
	
	private int count = 0; 
	
    int computeStepCount(int start) {
		if (start <= 0)
			throw new IllegalArgumentException ("Only natural numbers are allowed");
        if (start == 1)
			return count;
		if (start % 2 == 0)
			{count++; return computeStepCount (start / 2);}
		if (start % 2 == 1)
			{count++; return computeStepCount (3 * start + 1);}
		return count;
    }

}
