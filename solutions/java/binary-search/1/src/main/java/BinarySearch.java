import java.util.List;
public class BinarySearch{
	
	private List<Integer> list;
	
	public BinarySearch(List<Integer> list){
		this.list = list;
	} 
	
	public int indexOf(int num)throws ValueNotFoundException {
		int first = 0;
		int last  = list.size() - 1;
		int mid   = (last + first) / 2;

        if (list.isEmpty())
            throw new ValueNotFoundException ("Value not in array");
        
		while(last != mid && first != mid){
			int temp = list.get(mid);
			
			if(temp == num)
				return mid;
			if(temp > num)
				last = mid - 1;
			else if(temp < num)
				first = mid + 1;
			mid = (last + first) / 2;
		}
		
		if (list.get(mid) == num)
			return mid;
		
		throw new ValueNotFoundException ("Value not in array");
	}
}