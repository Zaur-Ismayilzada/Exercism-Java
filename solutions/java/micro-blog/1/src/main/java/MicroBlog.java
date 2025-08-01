class MicroBlog {
    public String truncate(String input) {
		int count = 0;
		int i = 0;
		for (; i < input.length() && count != 5; i++){
			char chr = input.charAt(i);
			if (Character.isLowSurrogate(chr)){
				count++;
			}
			else if (Character.isHighSurrogate(chr)){
				continue;
			}
			else{
				count++;
			}
		}
		
		return input.substring(0, i);
    }
}
