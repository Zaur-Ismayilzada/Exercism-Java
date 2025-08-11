import java.util.HashMap;
import java.util.Map;

class BracketChecker {
	String expression;
    BracketChecker(String expression) {
        this.expression = get_plain(expression);
    }

    boolean areBracketsMatchedAndNestedCorrectly() {        
        String main = new String(expression);
        
        
        
        return helper(main);
    }
    
    private boolean helper(String str) {
    	if (str.isEmpty())
    		return true;
    	
    	char temp = str.charAt(0);
    	
    	if (temp == ')' || temp == '}' || temp == ']')
    		return false;
    	
    	int idx = -1;
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	map.put('(', 0);
    	map.put('{', 0);
    	map.put('[', 0);
    	
    	map.put(temp, -1);
    	
    	char counter_temp = get_counter(temp);
    	
    	for (int i = 1; i < str.length(); i++) {
    		if (str.charAt(i) == temp) {
    			int count = map.get(temp);
    			
    			map.put(temp, count - 1);
    		}else if (str.charAt(i) == counter_temp) {
    			int count = map.get(temp);
    			
    			map.put(temp, count + 1);
    			
    			if (map.get(temp) == 0) {
    				idx = i;
    				break;
    			}
    		}
    	}
    	
    	if (idx == -1)
    		return false;
    	
    	return helper(str.substring(1, idx)) && helper(str.substring(idx + 1));
    }
    
    private char get_counter(char chr) {
    	switch(chr) {
    	case '(' : return ')';
    	case '{' : return '}';
    	case '[' : return ']';
    	}
    	
    	return '*';
    }

    
    private String get_plain(String expression) {
    	String res = "";
    	
    	for (int i = 0; i < expression.length(); i++) {
    		char temp = expression.charAt(i);
    		if (temp == '(' || temp == ')' ||
    			temp == '{' || temp == '}' ||
    			temp == '[' || temp == ']')
    			res += temp;
    	}
    	
    	return res;
    }

}