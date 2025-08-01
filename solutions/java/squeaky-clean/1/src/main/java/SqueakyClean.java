class SqueakyClean {
    static String clean(String identifier) {
		String result = "";
        for (int i = 0; i < identifier.length(); i++){
			char ch = identifier.charAt(i);
			if (ch == ' ')
				result += "_";
			else if (Character.isISOControl (ch))
				result += "CTRL";
			else if (ch == '-')
			{
				if (i - 1 >= 0 && i + 1 < identifier.length())
					result += Character.toUpperCase(identifier.charAt(i + 1));
					i += 1;
			}
			else if (ch >= 'α' && ch <= 'ω')
				continue;
			else if (Character.isLetter (ch))
				result += ch;
		}
		
		return result;
    }
}
