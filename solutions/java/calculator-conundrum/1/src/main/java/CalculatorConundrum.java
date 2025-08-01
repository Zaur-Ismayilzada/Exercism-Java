class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null)throw new IllegalArgumentException("Operation cannot be null");

        if (operation.isEmpty())throw new IllegalArgumentException("Operation cannot be empty");

        if (!is_valid(operation))throw new IllegalOperationException("Operation '" + operation + "' does not exist");

        String res = "";
        res += operand1;
        res += " " + operation;
        res += " " + operand2;
        res += " = ";

        if (operation.equals("*")){
            res += operand1 * operand2;
        }else if (operation.equals("+")){
            res += operand1 + operand2;
        }else{
            try{
                res += operand1 / operand2;
            }catch(ArithmeticException exp){
                throw new IllegalOperationException("Division by zero is not allowed", exp);
            }
        }
         return res;
    }

    private boolean is_valid(String operation){
        if (operation.length() != 1)return false;

        char chr = operation.charAt(0);

        return chr == '*' || chr == '+' || chr == '/';
    }
}
