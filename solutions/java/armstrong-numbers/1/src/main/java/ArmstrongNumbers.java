class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String str = Integer.toString(numberToCheck);
		int    sum = 0;
		
		for (int i = 0; i < str.length(); i++){
			int temp = Character.getNumericValue (str.charAt(i));
			sum += (int) Math.pow ((double)temp, (double)str.length());
		}
		
		return sum == numberToCheck;
    }

}
