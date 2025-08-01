class IsogramChecker {

    boolean isIsogram(String phrase) {
        for (int i = 0; i < phrase.length(); i++){
			for (int j = i + 1; j < phrase.length(); j++){
				if (Character.isLetter (phrase.charAt(i)) &&
				    Character.isLetter (phrase.charAt(j)) &&
					Character.toLowerCase (phrase.charAt(i)) == 
					Character.toLowerCase (phrase.charAt(j)))
					return false;
			}
		}
		return true;
    }

}
