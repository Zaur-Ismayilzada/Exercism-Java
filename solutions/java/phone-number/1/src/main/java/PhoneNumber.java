public class PhoneNumber{
	
	private String number;
	
	public PhoneNumber(String number){
		
		if (containsLetter(number))
			throw new IllegalArgumentException("letters not permitted");
		
		if (containsPunctuation(number))
			throw new IllegalArgumentException("punctuations not permitted");
		
		String temp = getPlain(number);
		
		if (temp.length() < 10)
			throw new IllegalArgumentException("incorrect number of digits");
			
		if (temp.length() == 11 && !temp.startsWith("1"))
			throw new IllegalArgumentException("11 digits must start with 1");
		
		if (temp.length() > 11)
			throw new IllegalArgumentException("more than 11 digits");
		
		if (temp.length() == 10 && temp.startsWith("0"))
			throw new IllegalArgumentException("area code cannot start with zero");
			
		if (temp.length() == 10 && temp.startsWith("1"))
			throw new IllegalArgumentException("area code cannot start with one");
		
		if (temp.length() == 10 && temp.charAt(3) == '0')
			throw new IllegalArgumentException("exchange code cannot start with zero");

		if (temp.length() == 10 && temp.charAt(3) == '1')
			throw new IllegalArgumentException("exchange code cannot start with one");
			
		if (temp.length() == 11 && temp.charAt(1) == '0')
			throw new IllegalArgumentException("area code cannot start with zero");

		if (temp.length() == 11 && temp.charAt(1) == '1')
			throw new IllegalArgumentException("area code cannot start with one");

		if (temp.length() == 11 && temp.charAt(4) == '0')
			throw new IllegalArgumentException("exchange code cannot start with zero");

		if (temp.length() == 11 && temp.charAt(4) == '1')
			throw new IllegalArgumentException("exchange code cannot start with one");			

        if (temp.length() == 11)
		    this.number = temp.substring(1);
        else
            this.number = temp;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	private String getPlain(String number){
	
		String result = "";
		
		for (int i = 0; i < number.length(); i++){
		
			char ch = number.charAt(i);
			
			if (Character.isDigit(ch))
				result += ch;
		}
			
		return result;
	}
	
	private boolean containsLetter(String number){
		
		for (int i = 0; i < number.length(); i++){
		
			char ch = number.charAt(i);
			
			if (Character.isLetter(ch))
				return true;
		}
		
		return false;
	}
	
	private boolean containsPunctuation(String number){
		
		for (int i = 0; i < number.length(); i++){
		
			char ch = number.charAt(i);
			
			if (ch == '@' || ch == '!' || ch == ':')
				return true;
		}
		
		return false;
	}
	
}
