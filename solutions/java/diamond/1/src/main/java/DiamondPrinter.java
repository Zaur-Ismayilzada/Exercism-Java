import java.util.List;
import java.util.ArrayList;

class DiamondPrinter {
	
	private char[] arr;
	
    public List<String> printToList(char a) {
		int len = a - 64;
        List<String> list = new ArrayList<String>();
		arr               = new char[len * 2 - 1];
		int temp          = len;
		
		while (len != 0){
			plain (arr);
			
			arr[len - 1]          = (char) (a - len + 1);
			arr[arr.length - len] = (char) (a - len + 1);
			
			len--;
			list.add (toString (arr));
		}
		
		while (len < temp - 1){
			plain (arr);
			
			arr[len + 1]                    = (char) (a - len - 1);
			arr[arr.length - 1 - (len + 1)] = (char) (a - len - 1);
			
			len++;
			list.add (toString (arr));
		}
		
        return list;
    }
	
	private void plain (char[] arr){
		for (int i = 0; i < arr.length; i++)
			arr[i] = ' ';
	}
	
	private String toString (char[] arr){
		String str = "";
		
		for (int i = 0; i < arr.length; i++)
			str += arr[i];
		
		return str;
	}

}
