import java.util.function.BiFunction;
import java.util.Map;
import java.util.HashMap;

class WordProblemSolver {

    Map<String, BiFunction<Integer, Integer, Integer>> map;

    WordProblemSolver(){
        map = new HashMap<String, BiFunction<Integer, Integer, Integer>>();

        map.put("plus",       this::add);
        map.put("minus",      this::sub);
        map.put("multiplied", this::mul);
        map.put("divided",    this::div);
    }

    int solve(final String wordProblem) {
        if (wordProblem.length() <= 8)
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        
        String main = wordProblem.substring(8, wordProblem.length() - 1).replace(" by ", " ");

        String[] parsed = main.split(" ");

        int res = 0;
        int b   = 0;

        String operator = "";

        boolean num = false; 
        boolean op  = false;

        for (int i = 0; i < parsed.length; i++){
            if (num){
                //assign to b
                if (!is_integer(parsed[i]))
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");

                b   = Integer.parseInt(parsed[i]);
                num = false;
                res = map.get(operator).apply(res, b);
                op  = true;

            }else if (op){
                if (!is_operator(parsed[i]))
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");

                op       = false;
                num      = true;
                operator = parsed[i];
            }else{
                //assign to res
                if (!is_integer(parsed[i]))
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");

                res = Integer.parseInt(parsed[i]);
                op  = true;
            }
        }

        if (num)
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        
        return res;

    }

    boolean is_integer(String str){
        return str.startsWith("-") || Character.isDigit(str.charAt(0));
    }

    boolean is_operator(String str){
        return str.equals("plus")       ||
               str.equals("minus")      ||
               str.equals("multiplied") ||
               str.equals("divided");
    }

    int add(int a, int b){
        return a + b;
    }

    int sub(int a, int b){
        return a - b;
    }

    int div(int a, int b){
        return a / b;
    }

    int mul(int a, int b){
        return a * b;
    }
}
