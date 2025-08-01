import java.util.List;
import java.util.ArrayList;

public class BaseConverter{
	
	private int   base;
	private int[] series;
	
	public BaseConverter(int base, int[] series){
	
		if (base < 2)
			throw new IllegalArgumentException("Bases must be at least 2.");
		if (!negativValid(series))
			throw new IllegalArgumentException("Digits may not be negative.");
		if (!baseValid(base, series))
			throw new IllegalArgumentException("All digits must be strictly less than the base.");
		
		this.base = base;
		this.series = series;
	}
	
	public List<Integer> convertToBase(int base){
	
		List<Integer> list = new ArrayList<Integer>();
		
		if (base < 2)
			throw new IllegalArgumentException("Bases must be at least 2.");
		if (series.length == 0)
			{list.add(0); return list;}
		/*
		this.base ile 10-a cevirecek, sonra base-e bole-bole gedecek
		*/
		
		int base_10 = 0;
		int k       = 0;
		
		for (int i = series.length - 1; i >= 0; i--){
			base_10 += series[i] * (int)(Math.pow(this.base, k));
			k++;
		}
		
		if (base_10 == 0)
			{list.add(0); return list;}
		
		while(base_10 >= base){
			list.add(base_10 % base);
			base_10 /= base;
		}
		
		list.add(base_10);
		
		return reverse(list);
	}
	
	private boolean negativValid(int[] series){
		for (int i = 0; i < series.length; i++)
			if (series[i] < 0)
				return false;
		return true;
	}
	
	private boolean baseValid(int base, int[] series){
		for (int i = 0; i < series.length; i++)
			if (series[i] >= base)
				return false;
		return true;
	}
	
	private List<Integer> reverse(List<Integer> list){
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = list.size() - 1; i >= 0; i--)
			result.add(list.get(i));
		
		return result;
	}
}