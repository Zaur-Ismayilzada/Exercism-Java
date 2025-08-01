import java.util.List;
import java.util.ArrayList;

class HandshakeCalculator {
	
	//public enum Signal{WINK, DOUBLE_WINK, CLOSE_YOUR_EYES, JUMP;}
	
    public List<Signal> calculateHandshake(int number) {
         List<Signal> list = new ArrayList<Signal>();
		 boolean reverse = false;
		 
		 while (number != 0){
		 	if (number >= 16)
				{
					if (reverse)
						reverse = false;
					else
						reverse = true;
					number -= 16;
				}
			else if (number >= 8)
				{list.add(Signal.JUMP); number -= 8;}
			else if (number >= 4)
				{list.add(Signal.CLOSE_YOUR_EYES); number -= 4;}
			else if (number >= 2)
				{list.add(Signal.DOUBLE_BLINK); number -= 2;}
			else if (number >= 1)
				{list.add(Signal.WINK); number--;}
		 }
		 
		 if (!reverse)
		 	list = reverse_list (list);
		 
		 return list;
    }
	
	private List<Signal> reverse_list (List<Signal> list){
		List<Signal> result = new ArrayList<Signal>();
		
		for (int i = list.size() - 1; i >= 0; i--)
			result.add(list.get(i));
		return result;
	}
}
