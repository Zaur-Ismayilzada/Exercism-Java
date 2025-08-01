import java.util.List;
import java.util.ArrayList;

class Person implements Comparable<Person>{
	String name;
	int grade;
	
	Person(String name, int grade){
		this.name  = name;
		this.grade = grade;
	}
	
	public int compareTo(Person other){
		if (this.grade != other.grade){
			if (this.grade > other.grade)
				return 1;
			else
				return -1;
		}
		else if (!this.name.equals(other.name)){
			return this.name.compareTo(other.name);
		}
		
		return 0;
	}
	
}


public class School{
	
	private List<Person> rost = new ArrayList<Person>();
	
	public void add(String name, int grade_num){
		rost.add(new Person(name, grade_num));
	}
	
	public List<String> roster(){
		sort(rost);
		
		List<String> result = new ArrayList<String>();
		
		for (Person p : rost)
			result.add(p.name);
			
		return result;
	}
	
	public List<String> grade(int grade_num){
		sort(rost);
		
		List<String> result = new ArrayList<String>();
		
		for (Person p : rost)
			if (p.grade == grade_num)
				result.add(p.name);
			
		return result;
	}
	
	void sort(List<Person> list){
		boolean changed = false;
		
		do{
			changed = false;
			for (int i = 0; i < list.size() - 1; i++){
				if (list.get(i).compareTo(list.get(i + 1)) > 0){
					Person temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					changed = true;
				}
			}
		}while(changed);
	}
}