public class PangramChecker {

	private String getPlane (String input){
		String res = "";
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++)
			if(Character.isLetter(input.charAt(i)))
				res += input.charAt(i);
		return res;
	}
	
    public boolean isPangram(String input) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		if(input.isEmpty())
			return false;
		
		input = getPlane (input);
		
		for (int i = 0; i < alphabet.length(); i++)
			if(input.indexOf(alphabet.charAt(i)) == -1)
				return false;
		return true;
    }
}