class ComplexNumber{
	
	private double real;
	private double imag;
	
	public ComplexNumber (double real, double imag){
		this.real = real;
		this.imag = imag;
	} 
	
	public double getReal (){
		return real;
	}
	
	public double getImag (){
		return imag;
	}
	
	public ComplexNumber times (ComplexNumber z){
		double r, i;
		
		r = real * z.getReal() - imag * z.getImag();
		i = imag * z.getReal() + real * z.getImag();
		
		return new ComplexNumber(r, i);
	}
	
	public ComplexNumber add (ComplexNumber z){
		double r, i;
		
		r = real + z.getReal();
		i = imag + z.getImag();
		
		return new ComplexNumber(r, i);
	}

	public ComplexNumber minus (ComplexNumber z){
		double r, i;
		
		r = real - z.getReal();
		i = imag - z.getImag();
		
		return new ComplexNumber(r, i);
	}
	
	public ComplexNumber div (ComplexNumber z){
		double r, i;
		
		r = (real * z.getReal() + imag * z.getImag())  / (z.getImag() * z.getImag() + z.getReal() * z.getReal());
		i = (imag * z.getReal() - real * z.getImag())  / (z.getImag() * z.getImag() + z.getReal() * z.getReal());
		
		return new ComplexNumber (r, i);
	}
	
	public double abs (){
		return Math.sqrt (real * real + imag * imag);
	}
	
	public ComplexNumber conjugate (){
		return new ComplexNumber(real, -imag);
	}
	
	public ComplexNumber exponentialOf (){
		double r, i;
		
		r = Math.exp (real) * Math.cos(imag);
		i = Math.exp (real) * Math.sin(imag);
		
		return new ComplexNumber (r, i);
	}
	
}
