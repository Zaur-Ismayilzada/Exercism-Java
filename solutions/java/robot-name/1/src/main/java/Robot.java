import java.util.Random;
import java.util.ArrayList;

class Robot{
    private String name;
    private Random rand;
    private static ArrayList<String> list = new ArrayList<String>();

    public Robot(){
        rand = new Random();
        name = setName();
    }

    public String getName(){
        return name;
    }

    private String setName(){
        String res = "";
        int temp;

        for (int i = 0; i < 2; i++){
            temp = rand.nextInt(26);
            char ch = 65;
            ch += temp;
            res += ch;
        }

        for (int i = 0; i < 3; i++){
            temp = rand.nextInt(10);
            res += temp;
        }        
        
        if (list.contains(res))
            return setName();
        else
            list.add(res);
         
        return res;
    }

    public void reset(){
        name = setName();
    }
}
