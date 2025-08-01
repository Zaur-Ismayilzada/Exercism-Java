public class Bob{
	
	public String hey(String str){
		
		str = str.trim();

		if (str.isEmpty())
			return "Fine. Be that way!";	
		else if (isLetter(str) && isUpper(str) && str.endsWith("?"))
			return "Calm down, I know what I'm doing!";
		else if (str.endsWith("?"))
			return "Sure.";
		else if (isLetter(str) && isUpper(str))
			return "Whoa, chill out!";
		
		return "Whatever.";
	}
	
	private boolean isUpper (String str){
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if (Character.isLetter(ch) && !Character.isUpperCase(ch))
				return false;
		}
		
		return true;
	}
	
	private boolean isLetter (String str){
		boolean flag = false;
		for (int i = 0; i < str.length() - 1; i++)
			if (Character.isLetter(str.charAt(i)))
				flag = true;
		return flag;
	}
}