class Acronym {

	private String phrase;
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        String res = "";
		phrase = phrase.toUpperCase();
		
		
		res += phrase.charAt(0);
		
		for (int i = 1; i < phrase.length(); i++){
			char prev = phrase.charAt(i - 1);
			char curr = phrase.charAt(i);
			
			if ((prev == ' ' || prev == '-' || prev == '_') && 
			    (curr != ' ' && curr != '-' && curr != '_'))
				res += curr;
		}
		
		return res;
    }

}
