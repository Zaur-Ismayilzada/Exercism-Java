import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
import java.util.function.BiFunction;

class ForthEvaluator {
    List<Integer> evaluateProgram(List<String> input) {
    	String preprocessed = preprocess(input);
    	
    	My_List my_input = new My_List();
    	my_input.add(preprocessed.split(" "));
    	
    	
    	Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();
    	
    	Map<String, String> op_names  = new HashMap<>();
        Stack<Integer> main_stack     = new Stack<Integer>();
        List<Integer> res             = new ArrayList<Integer>();
        
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> mul = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> div = (a, b) -> a / b;
        
        ops.put("+", add);
        ops.put("-", sub);
        ops.put("*", mul);
        ops.put("/", div);
        
        op_names.put("+", "Addition");
        op_names.put("-", "Subtraction");
        op_names.put("*", "Multiplication");
        op_names.put("/", "Division");
        
        while (!my_input.isEmpty()) {
        	String token = my_input.removeFirst().toLowerCase();
        	
        	if ("+-*/".contains(token)) {
        		String op = token;
        		
        		if (main_stack.size() < 2) {
        			throw new IllegalArgumentException(op_names.get(op) + " requires that the stack contain at least 2 values");
        		}
        		
        		
        		Integer b = main_stack.pop();
        		Integer a = main_stack.pop();
        		
        		if (op.equals("/") && b == 0)
        			throw new IllegalArgumentException("Division by 0 is not allowed");
        		
        		main_stack.push(ops.get(op).apply(a, b));
        		
        	}else if ("swap over".contains(token)) {
        		if (token.equals("swap")) {
        			if (main_stack.size() < 2) {
        				throw new IllegalArgumentException("Swapping requires that the stack contain at least 2 values");
        			}
        			
        			Integer a = main_stack.pop();
        			Integer b = main_stack.pop();
        			
        			main_stack.push(a);
        			main_stack.push(b);
        		}else if (token.equals("over")) {
        			if (main_stack.size() < 2) {
        				throw new IllegalArgumentException("Overing requires that the stack contain at least 2 values");
        			}
        			
        			Integer b = main_stack.pop();
        			Integer a = main_stack.pop();
        			
        			main_stack.push(a);
        			main_stack.push(b);
        			main_stack.push(a);
        		}
        		
        	}else if ("dup drop".contains(token)) {
        		if (token.equals("dup")) {
        			if (main_stack.size() < 1) {
        				throw new IllegalArgumentException("Duplicating requires that the stack contain at least 1 value");
        			}
        			
        			Integer a = main_stack.pop();
        			main_stack.push(a);
        			main_stack.push(a);
        		}else if (token.equals("drop")) {
        			if (main_stack.isEmpty()) {
        				throw new IllegalArgumentException("Dropping requires that the stack contain at least 1 value");
        			}
        			
        			main_stack.pop();
        		}
        		
        	}else if (is_numeric(token)) {
        		main_stack.push(Integer.parseInt(token));
        	}else
        		throw new IllegalArgumentException("No definition available for operator \"" + token + "\"");
        }
        
        res.addAll(main_stack);
        
        return res;
    }
    
    private String preprocess(List<String> input){
    	Map<String, String> map = new HashMap<String, String>();
    	
    	for (String temp : input) {
    		if (temp.startsWith(":")) {
    			temp = temp.substring(2, temp.length() - 2);
    			
    			int idx = temp.indexOf(' ');
    			
    			String op = temp.substring(0, idx).toLowerCase();
    			String to_be_defined = temp.substring(idx + 1).toLowerCase();
    			
    			if ((op.charAt(0) >= '0' && op.charAt(0) <= '9') || (op.startsWith("-")))
    				throw new IllegalArgumentException("Cannot redefine numbers");
    			
    			if (map.containsKey(to_be_defined))
    				to_be_defined = map.get(to_be_defined);
    			
    			for (String str : map.keySet()) {
    				while (to_be_defined.contains(str)) {
    					int i = to_be_defined.indexOf(str);
    					to_be_defined = to_be_defined.substring(0, i) + 
    									map.get(str)                  + 
    							        to_be_defined.substring(i + str.length());
    				}
    			}
    			
    			map.put(op, to_be_defined);
    		}
    	}
    	
    	String[] tokens = input.getLast().split(" ");
    	
    	String res = "";
    	
    	for (String token : tokens) {
    		token = token.toLowerCase();
    		if (map.containsKey(token)) {
    			res += map.get(token) + " ";
    		}else {
    			res += token + " ";
    		}
    		
    	}
    	
    	return res.substring(0, res.length() - 1);
    }
    
    private boolean is_numeric(String token) {
    	try {
    		Integer a = Integer.parseInt(token);
    	}catch(NumberFormatException e) {
    		return false;
    	}
    	
    	return true;
    }
}

class My_List{
	Node root;
	
	My_List(){root = null;}
	
	void add(String value) {
		Node temp = root;
		
		if (temp == null) {
			root = new Node(value);
			return;
		}
		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new Node(value);
	}
	
	void add(String[] values) {
		for (int i = 0; i < values.length; i++) {
			add(values[i]);
		}
	}
	
	int size() {
		Node temp = root;
		
		if (temp == null)
			return 0;
		
		int count = 1;
		
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	@Override
	public String toString() {
		if (size() == 0)
			return "()";
		
		String res = "(";
		
		Node temp = root;
		
		while (temp.next != null) {
			res += temp.value + ",";
			temp = temp.next;
		}
		
		res = res.substring(0, res.length() - 1) + ")";
		
		return res;
	}
	
	boolean isEmpty() {
		return size() == 0;
	}
	
	String removeFirst() {
		if (size() == 0)
			throw new EmptyStackException();
		
		String res = root.value;
		root = root.next;
		
		return res;
	}
	
	
	class Node{
		String value;
		Node next;
		
		Node(String value){
			this.value = value;
			next       = null;
		}
	}
}
