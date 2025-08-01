import java.util.Arrays;

class LuhnValidator {

    boolean isValid(String candidate) {
        //System.out.println(candidate);
        if (containsOtherChars(candidate))return false;

        candidate = getPlain(candidate);
        //System.out.println(candidate);

        int length = candidate.length();

        if (length <= 1)return false;

        int[] arr = toArray(candidate);

        boolean flag = false;

        //double
        for (int i = arr.length - 1; i >= 0; i--){
            if (flag){
                int temp = arr[i] * 2;
                if (temp > 9)temp -= 9;

                arr[i] = temp;
                flag   = false;
            }
            else if (!flag)flag = true;
        }

        int sum = 0;
        //sum 
        for (int a : arr)
            sum += a;


        //System.out.println(Arrays.toString(arr));
        //System.out.println(sum);
        return sum % 10 == 0;

    }

    private int[] toArray(String str){
        int[] result = new int[str.length()];

        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);

            if (Character.isDigit(chr)){
                result[i] = Character.getNumericValue(chr);
            }
        }

        return result;
    }

    private boolean containsOtherChars(String str){
        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);

            if (!Character.isDigit(chr) && !Character.isWhitespace(chr))
                return true;
        }

        return false;
    }

    private String getPlain(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);
            if (Character.isDigit(chr))
                res += chr;
        }

        return res;
    }

}
