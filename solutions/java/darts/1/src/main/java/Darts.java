class Darts {
	
	private double x, y;
	
    Darts(double x, double y) {
        this.x = x;
		this.y = y;
    }

    int score() {
        double res = Math.sqrt (x * x + y * y);
		
		if (res <= 1.0)
			return 10;
		else if (res > 1.0 && res <= 5.0)
			return 5;
		else if (res > 5.0 && res <= 10.0)
			return 1;
		return 0;
    }

}
