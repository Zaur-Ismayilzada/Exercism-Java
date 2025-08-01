import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Tournament {
    private String table;
    private Map<String, Map<String, Integer>> teams;
    private Map<String, Integer> devastating_donkeys;
    private Map<String, Integer> allegoric_alaskans;
    private Map<String, Integer> blithering_badgers;
    private Map<String, Integer> courageous_californians;

    Tournament(){
        table = "Team                           | MP |  W |  D |  L |  P\n";

        devastating_donkeys     = new HashMap<String, Integer>();
        allegoric_alaskans      = new HashMap<String, Integer>();
        blithering_badgers      = new HashMap<String, Integer>();
        courageous_californians = new HashMap<String, Integer>();

        set_team(devastating_donkeys);
        set_team(allegoric_alaskans);
        set_team(blithering_badgers);
        set_team(courageous_californians);

        teams  = new HashMap<String, Map<String, Integer>>();

        teams.put("Devastating Donkeys",     devastating_donkeys);
        teams.put("Allegoric Alaskans",      allegoric_alaskans);
        teams.put("Blithering Badgers",      blithering_badgers);
        teams.put("Courageous Californians", courageous_californians);
    } 

    String printTable() {
        String base = "                               ";

        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();

        list.add(devastating_donkeys);
        list.add(allegoric_alaskans);
        list.add(blithering_badgers);
        list.add(courageous_californians);

        buble_sort(list);

        for (Map<String, Integer> elem : list){
            String temp = "";

            if (elem.get("MP") != 0){
                String name = get_name(elem);
                temp = name + " ".repeat(base.length() - name.length()) + "|";

                temp += "  " + Integer.toString(elem.get("MP")) + " |";
                temp += "  " + Integer.toString(elem.get("W"))  + " |";
                temp += "  " + Integer.toString(elem.get("D"))  + " |";
                temp += "  " + Integer.toString(elem.get("L"))  + " |";

                String p_val = Integer.toString(elem.get("P"));
                temp += (p_val.length() == 2 ? " " : "  ") + p_val  + "\n";

                table += temp;
            }
        }

        return table;
    }

    void applyResults(String resultString) {
        String[] results = resultString.split("\n");

        for (String result : results){
            int f_idx = result.indexOf(";");
            int l_idx = result.lastIndexOf(";");

            String team1 = result.substring(0, f_idx);
            String team2 = result.substring(f_idx + 1, l_idx);


            // updating mp value;
            int mp_value = teams.get(team1).get("MP");
            teams.get(team1).put("MP", mp_value + 1);

            mp_value = teams.get(team2).get("MP");
            teams.get(team2).put("MP", mp_value + 1);

            String res = result.substring(l_idx + 1);

            if (res.equals("draw")){
                // updating draw value
                int d_value = teams.get(team1).get("D");
                teams.get(team1).put("D", d_value + 1);

                d_value = teams.get(team2).get("D");
                teams.get(team2).put("D", d_value + 1);

                // updating point value
                int p_value = teams.get(team1).get("P");
                teams.get(team1).put("P", p_value + 1);

                p_value = teams.get(team2).get("P");
                teams.get(team2).put("P", p_value + 1);
            }else {
                String winner = "";
                String loser  = "";

                if (res.equals("win")){
                    winner = team1;
                    loser  = team2;
                }else{
                    winner = team2;
                    loser  = team1;
                }

                // updating win value
                int w_value = teams.get(winner).get("W");
                teams.get(winner).put("W", w_value + 1);

                // updating lose value
                int l_value = teams.get(loser).get("L");
                teams.get(loser).put("L", l_value + 1);

                // updating point value
                int p_value = teams.get(winner).get("P");
                teams.get(winner).put("P", p_value + 3);
            }
        }
    }

    void set_team(Map<String, Integer> map){
        map.put("MP", 0);
        map.put("W",  0);
        map.put("D",  0);
        map.put("L",  0);
        map.put("P",  0);
    }

    void buble_sort(List<Map<String, Integer>> list){
        boolean changed = true;

        while (changed){
            changed = false;

            for (int i = 0; i < list.size() - 1; i++){
                Map<String, Integer> a = list.get(i);
                Map<String, Integer> b = list.get(i + 1);

                if (a.get("P") < b.get("P")){
                    Collections.swap(list, i, i + 1);
                    changed = true;     
                }else if (a.get("P") == b.get("P")){
                    if (get_name(a).compareTo(get_name(b)) > 0){
                        Collections.swap(list, i, i + 1);
                        changed = true;
                    }
                }
            }
        }
    }

    String get_name(Map<String, Integer> map){
        for (Map.Entry<String, Map<String, Integer>> m : teams.entrySet()){
            if (m.getValue() == map)
                return m.getKey();
        }

        return "";
    }
}
