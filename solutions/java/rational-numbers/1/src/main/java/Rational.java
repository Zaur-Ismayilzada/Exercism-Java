class Rational {
	
	private int numerator, denominator;
	
    Rational(int numerator, int denominator) {
		
		int gcd = getGCD(Math.abs(numerator), Math.abs(denominator));
		
		numerator   /= gcd;
		denominator /= gcd;
		
		if (denominator < 0){
        	this.numerator   = -numerator;
			this.denominator = -denominator;
			return;
		}
		
		this.numerator = numerator;	
		this.denominator = denominator;
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }
	
	private int getGCD (int a, int b){
		if (b == 0)
			return a;
			
		int temp = a % b;
		return getGCD (b, temp);
	}
	
	public Rational abs (){
		return new Rational (Math.abs(numerator), Math.abs(denominator));
	}
	
	public Rational add (Rational r){
		int a = numerator * r.getDenominator() + r.getNumerator() * denominator;
		int b = denominator * r.getDenominator();
		return new Rational (a, b);
	}
	
	public Rational subtract (Rational r){
		int a = numerator * r.getDenominator() - r.getNumerator() * denominator;
		int b = denominator * r.getDenominator();
		return new Rational (a, b);
	}
	
	public Rational multiply (Rational r){
		int a = numerator * r.getNumerator();
		int b = denominator * r.getDenominator();
		return new Rational (a, b);
	}
	
	public Rational divide (Rational r){
		int a = numerator * r.getDenominator();
		int b = denominator * r.getNumerator();
		return new Rational (a, b);
	}
	
	public Rational pow (int n){
		int a, b;
		
		if (n >= 0){
			a = (int)(Math.pow (numerator , n));
			b = (int)(Math.pow (denominator, n));
		}
		else{
			a = (int)(Math.pow (denominator, Math.abs(n)));
			b = (int)(Math.pow (numerator, Math.abs(n)));
		}
		return new Rational (a, b);
	}
	
	public double exp (double num){
		double power = (double)numerator / (double)denominator;
		return (power >= 0) ? Math.ceil((Math.pow(num, power))) : (1 / (Math.pow(num, -power)));
	}

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
            && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }
}
