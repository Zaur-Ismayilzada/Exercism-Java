class Scrabble {
	private String word;
    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int sum = 0;
		
		if(word.isEmpty())
			return 0;
		
		for (int i = 0; i < word.length(); i++){
			switch(Character.toLowerCase(word.charAt(i))) {
				case 'a' : sum += 1; break;
				case 'e' : sum += 1; break;
				case 'i' : sum += 1; break;
				case 'o' : sum += 1; break;
				case 'u' : sum += 1; break;
				case 'l' : sum += 1; break;
				case 'n' : sum += 1; break;
				case 'r' : sum += 1; break;
				case 's' : sum += 1; break;
				case 't' : sum += 1; break;
				
				case 'd' : sum += 2; break;
				case 'g' : sum += 2; break;
				
				case 'b' : sum += 3; break;
				case 'c' : sum += 3; break;
				case 'm' : sum += 3; break;
				case 'p' : sum += 3; break;
				
				case 'f' : sum += 4; break;
				case 'h' : sum += 4; break;
				case 'v' : sum += 4; break;
				case 'w' : sum += 4; break;
				case 'y' : sum += 4; break;
				
				case 'k' : sum += 5; break;
				
				case 'j' : sum += 8; break;
				case 'x' : sum += 8; break;
				
				case 'q' : sum += 10; break;
				case 'z' : sum += 10; break;
			}
		}
		
		return sum;
    }

}
