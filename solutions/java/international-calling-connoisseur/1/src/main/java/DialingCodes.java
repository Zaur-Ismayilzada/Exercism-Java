import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
	Map<Integer, String> map;
	
	public DialingCodes() {
		map = new HashMap<Integer, String>();
	}

    public Map<Integer, String> getCodes() {
    	return map;
    }

    public void setDialingCode(Integer code, String country) {
    	if (map.containsKey(code)) {
    		map.remove(code);
    	}
    	
    	map.put(code, country);
    }

    public String getCountry(Integer code) {
    	return map.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
    	if (!map.containsKey(code) && !map.containsValue(country))
    		map.put(code, country);
    }

    public Integer findDialingCode(String country) {
    	for (Map.Entry<Integer, String> entry : map.entrySet()) {
    		Integer code = entry.getKey();
    		String  coun = entry.getValue();
    		if (coun.equals(country))
    			return code;
    	}
    	
    	return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
    	if (map.containsKey(code)) {
        	map.remove(code);
        	map.put(code, country);   		
    	}else if (map.containsValue(country)) {
    		for (Map.Entry<Integer, String> entry : map.entrySet()) {
    			Integer _code   = entry.getKey();
    			String _country = entry.getValue();
    			
    			if (_country.equals(country)) {
    				map.remove(_code);
    				map.put(code, country);
    			}
    		}
    	}
    }
}
