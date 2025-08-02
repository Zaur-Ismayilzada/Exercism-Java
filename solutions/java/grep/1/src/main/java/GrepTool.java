import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
    	String res = "";
    	
    	if (flags.contains("-i"))
    		pattern = pattern.toLowerCase();
    	
    	List<String> lines = new ArrayList<String>();
    	
    	for (int i = 0; i < files.size(); i++) {
	    	
	    	try {
				lines = Files.readAllLines(Path.of(files.get(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	int line_count = 0;
	    	
	    	for (String line : lines) {
	    		String prepend = "";
	    		String for_i_case = line;
	    		line_count++;
	    		
	    		if (flags.contains("-i"))
	    			line = line.toLowerCase();
	    		
	    		
	    		if (line.contains(pattern)) {
	    			if (flags.contains("-v"))
	    				continue;
	    			
	    			if (flags.contains("-l")) {
	    				if (!res.contains(files.get(i)))
	    					res += files.get(i) + "\n";
	    				continue;
	    			}
	    			
	    			if (files.size() > 1)
	    				prepend += files.get(i) + ":";
	    			
	    			if (flags.contains("-n"))
	    				prepend += line_count + ":";
	    			
	    			if (flags.contains("-x") && !line.equals(pattern))
	    				continue;
	    			
	    			if (flags.contains("-i"))
	    				line = for_i_case;
	    			
	    			res += prepend + line + "\n";
	    		}else if (flags.contains("-v")) {
	    			if (files.size() > 1)
	    				prepend += files.get(i) + ":";
	    			res += prepend + line + "\n";
	    		}
	    	}
    	}
    	
    	if (!res.isEmpty())
    		res = res.substring(0, res.length() - 1);
    	
    	return res;
    }

}