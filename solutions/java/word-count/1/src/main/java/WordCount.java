import java.util.Map;
import java.util.HashMap;

public class WordCount{
	
	private String getPlain(String str){
		String result = "";
		
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if (i != 0 && i != str.length() - 1 && 
			    ch == '\'' && Character.isLetter(str.charAt(i-1)) &&
				Character.isLetter(str.charAt(i+1)))
				 result += ch;
			else if (Character.isLetter(ch) || Character.isDigit(ch))
				result += Character.toLowerCase(ch);
			else
				result += " ";
		}
		
		return result;
	}
	
	public Map<String, Integer> phrase(String str){
		str = getPlain(str);
		String[] arr = str.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < arr.length; i++){
			if (arr[i].trim().isEmpty())
				continue;
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else{
				int temp = map.get(arr[i]);
				map.put(arr[i], temp + 1);
			}
		}
		
		return map;
	}
	
} 
