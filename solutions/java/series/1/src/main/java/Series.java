import java.util.List;
import java.util.ArrayList;

class Series{
	
	private String series;
	private List<String> list;
	
	public Series (String series){
		this.series = series;
		list = new ArrayList<String>();
	}
	
	public List<String> slices (int digit) throws IllegalArgumentException{
		String temp = "";
		
		if (digit > series.length())
			throw new IllegalArgumentException("Slice size is too big.");
		if (digit <= 0)
			throw new IllegalArgumentException("Slice size is too small.");
		
		while (digit <= series.length()){
			temp = series.substring(0, digit);
			list.add(temp);
			series = series.substring(1);
		}
		
		return list;
	}
}
