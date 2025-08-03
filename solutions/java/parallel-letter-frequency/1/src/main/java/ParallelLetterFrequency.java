import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ParallelLetterFrequency {
	
	List<String> texts;

    ParallelLetterFrequency(String[] texts) {
        this.texts = List.of(texts);
    }

    Map<Character, Integer> countLetters() {
        Map<Character, Integer> map = new HashMap<>();
        
        map = texts.parallelStream().map(text -> count(text)).flatMap(m -> m.entrySet().stream()).collect(
        		Collectors.toMap(
        				Map.Entry::getKey,
        				Map.Entry::getValue,
        				Integer::sum
        				)
        		);
        
        return map;
    }
    
    Map<Character, Integer> count(String sentence){
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < sentence.length(); i++) {
    		char temp = Character.toLowerCase(sentence.charAt(i));
    		
    		if (Character.isLetter(temp)) {
    			if (map.containsKey(temp)) {
    				int _count = map.get(temp);
    				map.put(temp, _count + 1);
    			}else map.put(temp, 1);
    		}else continue;
    	}
    	
    	return map;
    }

}

