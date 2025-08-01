class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.isEmpty())
			return "";
			
		String result = "";
		
		for (int i = 0; i < dnaStrand.length(); i++){
			char ch = dnaStrand.charAt(i);
			
			switch (ch){
				case 'G' : result += 'C'; break;
				case 'C' : result += 'G'; break;
				case 'T' : result += 'A'; break;
				case 'A' : result += 'U'; break;
			}
		}
		
		return result;
    }

}
