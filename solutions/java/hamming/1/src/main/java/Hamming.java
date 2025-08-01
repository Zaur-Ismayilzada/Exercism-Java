public class Hamming {
	private String leftStrand, rightStrand;
	
    public Hamming(String leftStrand, String rightStrand) {
		if (!(leftStrand.isEmpty() && rightStrand.isEmpty())){
			if (leftStrand.isEmpty())
				throw new IllegalArgumentException ("left strand must not be empty.");
			if (rightStrand.isEmpty())
				throw new IllegalArgumentException ("right strand must not be empty.");
	        if (leftStrand.length() != rightStrand.length())
				throw new IllegalArgumentException ("leftStrand and rightStrand must be of equal length.");
		}	
        this.leftStrand  = leftStrand;
		this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
		if (leftStrand.isEmpty() && rightStrand.isEmpty())
			return 0;
			
		int count = 0;
		
		for (int i = 0; i < leftStrand.length(); i++){
			if (leftStrand.charAt(i) != rightStrand.charAt(i))
				count++;
		}
		
		return count;
    }
}