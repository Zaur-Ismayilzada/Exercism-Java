class RotationalCipher {
	
	private int shiftKey;
	
    RotationalCipher(int shiftKey) {
		this.shiftKey = shiftKey;
    }

    String rotate(String data) {
		String res  = "";
        int    temp = 0;
		
		for (int i = 0; i < data.length(); i++){
			char ch = data.charAt(i);
			if (Character.isLowerCase(ch)){
				temp = ch - 97;
				temp += shiftKey;
				
				if(temp >= 26)
					temp = 97 + temp % 26;
				else
					temp += 97;
				res += (char)temp;
			}else if (Character.isUpperCase(ch)){
				temp = ch - 65;
				temp += shiftKey;
				
				if(temp >= 26)
					temp = 65 + temp % 26;
				else
					temp += 65;
				res += (char)temp;				
			}else
				res += ch;
		}
		return res;
    }

}


