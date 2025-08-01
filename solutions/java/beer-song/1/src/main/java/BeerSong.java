public class BeerSong{
	
	public String sing(int bottles, int count){
		String a = " bottles of beer on the wall, ";
		String b = " bottles of beer.\n"; 
		String c = "Take one down and pass it around, ";
		String d = " bottles of beer on the wall.\n\n";
		String result = "";
		
		while (count > 0 && bottles >= 0){
			
			if (bottles == 0)
				{result += "No more bottles of beer on the wall, no more bottles of beer.\n" + "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n"; break;}
			
			else if (bottles == 1)
				result += "1 bottle of beer on the wall, 1 bottle of beer.\n" + "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
				
			else if (bottles == 2)
				result += "2 bottles of beer on the wall, 2 bottles of beer.\n" + "Take one down and pass it around, 1 bottle of beer on the wall.\n\n";
				
			else
				result += bottles + a + bottles + b + c + (bottles - 1) + d;
			
			bottles--;
			count--;
		}
		
		return result;
	}
	
	public String singSong(){
		return sing(99, 100);
	}
	
}