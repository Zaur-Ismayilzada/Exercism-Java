import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Flattener{
    List<Object> singleton_list = Collections.singletonList(1);
    List<Object> array_list     = Arrays.asList(1);
	
	List<Object> flatten(List<Object> list){
		List<Object> res = new ArrayList<Object>();
		
		for (int i = 0; i < list.size(); i++){
			Object obj = list.get(i);
			if (obj == null){continue;}
			
			System.out.println(list.get(i).getClass().getName());
			
			if (obj.getClass() == list.getClass()){
				res.addAll(flatten((List<Object>)obj));
			}
			else if (obj.getClass() == singleton_list.getClass()){
				res.addAll(flatten((List<Object>)obj));
			}
			else if (obj.getClass() == array_list.getClass()){
				res.addAll(flatten((List<Object>)obj));
			}
			else{
				res.add(obj);
			}
		}
		
		return res;
	}
	
}