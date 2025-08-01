import java.util.Map;
import java.util.HashMap;
class NucleotideCounter{
	
	private String str;
	private Map<Character, Integer> map;
	
	public NucleotideCounter (String str){
		if (!isValid (str))
			throw new IllegalArgumentException();
	
		this.str = str;
		map = new HashMap<Character, Integer>();
	}
	
	private boolean isValid (String str){
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if (ch != 'A' && ch != 'C' && 
			    ch != 'G' && ch != 'T')
				return false;
		}
		return true;
	}
	
	public Map<Character, Integer> nucleotideCounts(){
		
		map.put ('A', 0);
		map.put ('C', 0);
		map.put ('G', 0);
		map.put ('T', 0);
		
		if (str.isEmpty())
			return map;
		
		char ch;
		int  count;
		
		for (int i = 0; i < str.length(); i++){
			ch = str.charAt(i);
			
			count = map.get(ch);
			count++;
	    	map.put (ch, count);	
		}

        return map;
	}
}
