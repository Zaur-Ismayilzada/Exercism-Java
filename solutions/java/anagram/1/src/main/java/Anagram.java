import java.util.List;
import java.util.ArrayList;

public class Anagram{
	
	private String word;
	
	public Anagram (String word){
		this.word = word.toLowerCase();
	}
	
	public List<String> match (List<String> list){
		List<String> result = new ArrayList<String>();
		
		for (String str : list)
			if (equals(word, str.toLowerCase()))
				result.add(str);
				
		return result;
	}
	
	private boolean equals (String word, String str){
		if (word.equals(str))
			return false;
		if (word.length() != str.length())
			return false;
		
		for (int i = 0; i < word.length(); i++){
			int idx = str.indexOf(word.charAt(i));
			
			if (idx == -1)
				return false;
			else
				str = str.substring(0, idx) + str.substring(idx + 1);
		}
		 
		return true;
	}
} 
