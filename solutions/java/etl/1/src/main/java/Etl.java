import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        
        for (Map.Entry<Integer, List<String>> mp : old.entrySet()){
            Integer      key   = mp.getKey();
            List<String> value = mp.getValue();

            for (int i = 0; i < value.size(); i++){
                result.put(value.get(i).toLowerCase(), key);
            } 
        }

        return result;
    }
}
