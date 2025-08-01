class TwelveDays {
	
	private String[] wishes = {"a Partridge in a Pear Tree.",
	                            "two Turtle Doves",
								"three French Hens",
								"four Calling Birds",
								"five Gold Rings",
								"six Geese-a-Laying",
								"seven Swans-a-Swimming",
								"eight Maids-a-Milking",
								"nine Ladies Dancing",
								"ten Lords-a-Leaping",
								"eleven Pipers Piping",
								"twelve Drummers Drumming"};
								
	private String[] days     = {"first",
							   "second",
							   "third",
							   "fourth",
							   "fifth",
							   "sixth",
							   "seventh",
							   "eighth",
							   "ninth",
							   "tenth",
							   "eleventh",
							   "twelfth"};
	
    String verse(int verseNumber) {
        verseNumber--;
		String result = "";
		int k         = verseNumber;
		
		result += "On the " + days[verseNumber] + " day of Christmas my true love gave to me: ";
		
		for (int i = 0; i <= verseNumber; i++){
			if (i == verseNumber)
				{
					if (verseNumber > 0)
						return result + "and " + wishes[k] + '\n';
					else
						return result + wishes[k] + '\n';
				}
			
			result += wishes[k] + ", ";
			k--;
		}
		
		
		return result;
    }

    String verses(int startVerse, int endVerse) {
     	String result = "";
		
		for (int i = startVerse; i <= endVerse; i++){
			if (i == endVerse)
				return result + verse (i);
				
			result += verse (i) + '\n';
		}
		
		return result;   
    }
    
    String sing() {
        return verses (1, 12);
    }
}
