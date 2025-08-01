import java.util.List;
import java.util.ArrayList;

public class Allergies{
    
	private int[] scores = {1, 2, 4, 8, 16, 32, 64, 128};
	private int score;
	public Allergies(int score){
		this.score = score;
	} 
	
	public boolean isAllergicTo(Allergen all){
		
		int temp = score;
		int val  = scores[getValue(all)];
		for(int i = scores.length - 1; i >= 0; i--){
			if (temp == val)
				return true;
			if (scores[i] == val && temp > val)
				return true;	
			if (scores[i] <= temp)
				temp -= scores[i];
		}
		
		return false;
	}
	
	public List<Allergen> getList(){
		List<Allergen> list = new ArrayList<Allergen>();
		
		int temp = score;
		
		if (temp >= 256)
			temp %= 256;		
		
		for (int i = scores.length - 1; i >= 0; i--){
			if(temp >= scores[i]){
				temp -= scores[i];
				list.add(getAll(scores[i]));
			}
		}
		
		return reverse(list);
	}
	
	private Allergen getAll(int val){
		switch(val){
			case 1   : return Allergen.EGGS;
			case 2   : return Allergen.PEANUTS;
			case 4   : return Allergen.SHELLFISH;
			case 8   : return Allergen.STRAWBERRIES;
			case 16  : return Allergen.TOMATOES;
			case 32  : return Allergen.CHOCOLATE;
			case 64  : return Allergen.POLLEN;
			case 128 : return Allergen.CATS;
		}
        return Allergen.CATS;
	}
	
	private List<Allergen> reverse(List<Allergen> list){
		List<Allergen> result = new ArrayList<Allergen>();
		
		for(int i = list.size() - 1; i >= 0; i--)
			result.add(list.get(i));
		
		return result;
	}
	
	private int getValue(Allergen all){
		switch(all){
			case EGGS         : return 0;
			case PEANUTS      : return 1;
			case SHELLFISH    : return 2;
			case STRAWBERRIES : return 3;
			case TOMATOES     : return 4;
			case CHOCOLATE    : return 5;
			case POLLEN       : return 6;
			case CATS         : return 7;
		}
		return -1;		
	}
	
}
