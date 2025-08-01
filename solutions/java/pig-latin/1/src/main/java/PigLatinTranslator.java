class PigLatinTranslator{ 
	public String translate(String text){
		if (text.contains(" ")){
			String[] strs = text.split(" ");

			for (int i = 0; i < strs.length; i++){
				strs[i] = translate(strs[i]);
			}

			String res = "";

			for (String s : strs){
				res += s + " ";
			}

			return res.substring(0, res.length() - 1);
		}

		//rule 1
		if (text.startsWith("xr") || text.startsWith("yt") || startsWithVowel(text)){
			return text + "ay";
		}

		//rule 4
		if ((startsWithConsonant(text) && text.length() == 2 && text.charAt(1) == 'y')){
			return Character.toString(text.charAt(1)) + Character.toString(text.charAt(0)) + "ay";
		}

		//rule 2, 3, 4
		if (startsWithConsonant(text)){
			for (int i = 0; i < text.length(); i++){
				if (text.charAt(i) == 'y' && startsWithConsonant(text.substring(0, i))){
					return text.substring(i, text.length()) + text.substring(0, i) + "ay";
				}

				if ((i + 2 < text.length()) && (text.substring(i, i + 2).equals("qu"))){
					return text.substring(i + 2, text.length()) + text.substring(0, i + 2) +  "ay";
				}

				if (isVowel(text.charAt(i))){
					return text.substring(i, text.length()) + text.substring(0, i) +  "ay";
				}
			}
		}


		return "";
	}

	private boolean startsWithVowel(String text){
		if (text.isEmpty())return false;

		char chr = text.charAt(0);
		return isVowel(chr);
	}

	private boolean isVowel(char chr){
		return chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u';
	}

	private boolean startsWithConsonant(String text){
		if (text.isEmpty())return false;
		return !startsWithVowel(text);
	}

	private boolean isConsonant(char chr){
		return !isVowel(chr);
	}

}