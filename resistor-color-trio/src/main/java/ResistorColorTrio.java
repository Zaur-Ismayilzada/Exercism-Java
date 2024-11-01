import java.util.Map;

class ResistorColorTrio {
    Map<String, Integer> m = Map.of(
        "black", 0,
        "brown", 1,
        "red", 2,
        "orange", 3,
        "yellow", 4,
        "green", 5,
        "blue", 6,
        "violet", 7,
        "grey", 8,
        "white", 9
    );

    String label(String[] colors) {
        int res = 0;

        res += m.get(colors[0]) * 10;
        res += m.get(colors[1]);

        int factor = (int)Math.pow(10.0, (double)m.get(colors[2]));
        String label = "";

        if (factor == 1000000000){
            factor = 1;
            label  = "giga";
        }

        res *= factor;

        if (res >= 1000000){
            res   /= 1000000;
            label  = "mega";
        }else if (res >= 1000){
            res   /= 1000;
            label  = "kilo";
        }

        return res + " " + label + "ohms";
    }
}
