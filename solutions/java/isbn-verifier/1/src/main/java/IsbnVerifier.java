class IsbnVerifier {

    boolean isValid(String str) {
        str = getPlain(str);
		
		if (str.length() != 10)
			return false;
		
		int k   = 10;
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++){
			int temp;
			if(i == str.length() - 1 && str.charAt(i) == 'X')
				temp = 10;
			else
				temp = Character.getNumericValue(str.charAt(i));
			sum += k * temp;
			k--;
		}
		
		return sum % 11 == 0;
    }
	
	String getPlain(String str){
		String result = "";
		
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(i == str.length() - 1 && (Character.isDigit(ch) || ch == 'X'))
				result += ch;
			else if(ch == '-')
				continue;
			else if(!Character.isDigit(ch))
				return "";
			else
				result += ch;
		}
		return result;
	}

}
