import java.util.List;
import java.util.ArrayList;

public class RelationshipComputer<T>{
	
	public Relationship computeRelationship(List<T> list1, List<T> list2){
		if (list1.size() > list2.size() && isSubList(list1, list2))
				return Relationship.SUPERLIST;
				
		if (list1.size() < list2.size() && isSubList(list2, list1))
				return Relationship.SUBLIST;
				
		if (list1.equals(list2))
			return Relationship.EQUAL;
			
		return Relationship.UNEQUAL;
	}
	
	private boolean isSubList(List<T> list1, List<T> list2){
		for (int i = 0; i < list1.size(); i++){
			if (list1.size() - i < list2.size())
				return false;
			if (list2.containsAll(list1.subList(i, i + list2.size())))
				return true;
		}
		
		return false;
	}
} 