import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class HighScores {

    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        Integer max = Integer.MIN_VALUE;

        for (Integer num : highScores){
            if (max.compareTo(num) < 0){
                max = num;
            }
        }

        return max;
    }

    List<Integer> personalTopThree() {
        if (highScores.size() <= 3){
            Collections.sort(highScores, Collections.reverseOrder()); return highScores;
        }

        List<Integer> res = new ArrayList<Integer>();

        List<Integer> max_indices = new ArrayList<Integer>();
        int           max_index   = -1;

        while (res.size() != 3){
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < highScores.size(); i++){
                if (highScores.get(i).compareTo(max) > 0 && !max_indices.contains(i)){
                    max       = highScores.get(i);
                    max_index = i;
                }
            }

            max_indices.add(max_index);
            res.add(max);
        }

        return res;
    }

}
