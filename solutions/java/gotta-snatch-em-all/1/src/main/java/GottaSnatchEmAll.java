import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> res = new HashSet<String>();

        for (String str : cards){
            res.add(str);
        }

        return res;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.containsAll(theirCollection))return false;

        if (theirCollection.isEmpty() || myCollection.isEmpty())return false;

        for (String str : myCollection){
            if (!theirCollection.contains(str))
                return true;
        }
        
        return false;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        List<String> first = new ArrayList(collections.get(0));
        Set<String>  res   = new HashSet<String>();

        for (int idx_s = 0; idx_s < first.size(); idx_s++){
            String temp  = first.get(idx_s);
            boolean flag = true; 
            for (int idx_l = 1; idx_l < collections.size(); idx_l++){
                if (!collections.get(idx_l).contains(temp)){
                    flag = false;
                    break;
                }
            }

            if (flag){
                res.add(temp);
            }else{
                flag = true;
            }
        }

        return res;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> res = new HashSet<String>();

        for (Set<String> s : collections){
            for (String str : s)res.add(str);
        }

        return res;
    }
}
