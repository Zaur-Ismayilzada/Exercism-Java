public class House{
	
	String[] defs = {"This is the house that Jack built.",
	                 "This is the malt ",
					 "This is the rat ",
					 "This is the cat ",
					 "This is the dog ",
					 "This is the cow with the crumpled horn ",
					 "This is the maiden all forlorn ",
					 "This is the man all tattered and torn ",
					 "This is the priest all shaven and shorn ",
					 "This is the rooster that crowed in the morn ",
					 "This is the farmer sowing his corn ",
					 "This is the horse and the hound and the horn "};
					 
	String[] refs = {"that lay in the house that Jack built.",
	               "that ate the malt ",
				   "that killed the rat ",
				   "that worried the cat ",
				   "that tossed the dog ",
				   "that milked the cow with the crumpled horn ",
				   "that kissed the maiden all forlorn ",
				   "that married the man all tattered and torn ",
				   "that woke the priest all shaven and shorn ",
				   "that kept the rooster that crowed in the morn ",
				   "that belonged to the farmer sowing his corn "};
	
	public String verse(int start){
		String result = "";
		
		start--;
		
		result += defs[start];
		
		start--;
		
		for (int i = start; i >= 0; i--)
			result += refs[i];
		
		return result;
	}
	
	public String verses(int start, int end){
		String result = "";
		
		for (int i = start; i <= end; i++){
			result += verse(i);
			if (i != end)
				result += "\n";
		}
		
		return result;
	}
	
	public String sing(){
		String result = "";
		
		result += defs[0] + "\n";
		
		result += verses (2, 12);
		
		return result;
	}
}