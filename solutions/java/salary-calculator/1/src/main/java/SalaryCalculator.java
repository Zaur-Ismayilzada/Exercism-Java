public class SalaryCalculator {
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return (daysSkipped > 5) ? 0.85 : 1.0;
    }

    public int multiplierPerProductsSold(int productsSold) {
       return (productsSold > 20) ? 13 : 10;
    }

    public double bonusForProductSold(int productsSold) {
        return multiplierPerProductsSold(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double result =  1000.0 * multiplierPerDaysSkipped(daysSkipped) + bonusForProductSold(productsSold);
		
		if (result > 2000.0)
			return 2000.0;
			
		return result;
    } 
}
