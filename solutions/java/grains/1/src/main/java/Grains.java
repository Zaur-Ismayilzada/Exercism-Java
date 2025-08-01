import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square <= 0 || square > 64)
			throw new IllegalArgumentException ("square must be between 1 and 64");
			
		BigInteger a = new BigInteger("2");
		return a.pow (square - 1);
    }

    BigInteger grainsOnBoard() {
		BigInteger a = grainsOnSquare (64);
		
		return a.multiply(new BigInteger("2")).subtract(new BigInteger("1"));
    }

}
