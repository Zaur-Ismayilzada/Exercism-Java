class Atbash{
	
	private String getPlain (String str){
		str = str.toLowerCase();
		
		String res = "";
		
		for (int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			
			if (Character.isDigit(temp)  || 
                Character.isLetter(temp))
				res += temp;
		}
		return res;
	}
	
	public String encode (String str){
		str = getPlain (str);
		
		String res   = "";
		int    count = 0;
		
		for (int i = 0; i < str.length(); i++){
			if (count == 5){res += " "; count = 0;}

			char temp = str.charAt(i);
			
			if (Character.isLetter(temp)){
				int ch = (int)temp;
				ch -= 97;
				
				ch = 25 - ch;
			
				ch += 97;
				
				temp = (char)ch;
				
				res += temp;
			}else
				res += temp;

			count++;
		}
        return res;
		
	}
	
	public String decode (String str){
		str = getPlain (str);
		
		String res   = "";
		
		for (int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			
			if (Character.isLetter(temp)){
				int ch = (int)temp;
				ch -= 97;
				
				ch = 25 - ch;
			
				ch += 97;
				
				temp = (char)ch;
				
				res += temp;
			}else
				res += temp;
		}
        return res;	
	} 
}
