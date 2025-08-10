import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KindergartenGarden {
	
	String[] students = {"Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"};
	
	String garden;
	Map<String, String> classroom;
	
    KindergartenGarden(String garden) {
        this.garden = garden;
        
        classroom = get_classroom();;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> res = new ArrayList<>();
        
        String student_plants = classroom.get(student);
        
        for (int i = 0; i < student_plants.length(); i++) {
        	char temp = student_plants.charAt(i);
        	
        	if (temp != '\n') {
        		res.add(Plant.getPlant(temp));
        	}
        }
        
        
        return res;
    }
    
    private Map<String, String> get_classroom(){
    	Map<String, String> res = new HashMap<String, String>();
    	
    	String[] lines = garden.split("\n");
    	
    	String line_1 = lines[0];
    	String line_2 = lines[1];
    	int name_idx  = 0;
    	for (int i = 0; i < line_1.length(); i += 2) {
    		res.put(students[name_idx], line_1.substring(i, i + 2) + "\n" + line_2.substring(i, i + 2));
    		name_idx++;
    	}
    	
    	return res;
    }
}