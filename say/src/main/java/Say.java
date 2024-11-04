public class Say {

    public String say(long number) {
        if (number < 0)throw new IllegalArgumentException("negative is invalid");

        String number_str = Long.toString(number);

        if (number_str.length() > 12)throw new IllegalArgumentException("too big");
        
        String[] nums     = {"", " thousand ", " million ", " billion "};
        int      k        = 0;
        String   res      = "";

        while (number_str.length() >= 3){
            String temp = "";

            temp       = number_str.substring(number_str.length() - 3);
            number_str = number_str.substring(0, number_str.length() - 3);
            temp       = (temp.charAt(0) >= '1' && temp.charAt(0) <= '9' ? zero_to_ninety_nine(temp.substring(0, 1)) + " hundred " : "") + 
                         zero_to_ninety_nine(temp.substring(1));
            res        = temp + (!temp.isEmpty() ? nums[k] : "") + res;
            k         += 1;
        }

        if (!number_str.isEmpty())
            res = zero_to_ninety_nine(number_str) + nums[k] + res;

        return res.trim();
    }

    private String zero_to_ninety_nine(String number_str){
        String  res   = "";
        boolean tenth = number_str.length() == 2 ? true : false;
        boolean teen  = false;

        if (tenth && number_str.charAt(0) == '1')
            teen = true;

        res += get_say(number_str.charAt(0), tenth, teen);

        if (tenth){
            if (number_str.charAt(1) == '0')
                return res;
            else
                if (!res.isEmpty())
                    res += "-";

                res += get_say(number_str.charAt(1), false, teen);
        }

        return res;

    }

    private String get_say(char digit, boolean tenth, boolean teen){
        switch (digit){
            case '1':
                if (tenth)
                    return "";
                else if (teen)
                    return "eleven";
                else
                    return "one";
            case '0':
                if (tenth)
                    return "";
                else
                    return "zero";  
            case '2':
                if (tenth)
                    return "twenty";
                else if (teen)
                    return "twelve";
                else
                    return "two";
            case '3':
                if (tenth)
                    return "thirty";
                else if (teen)
                    return "thirteen";
                else
                    return "three";
            case '4':
                if (tenth)
                    return "forty";
                else if (teen)
                    return "fourteen";
                else
                    return "four";
            case '5':
                if (tenth)
                    return "fifty";
                else if (teen)
                    return "fifteen"; 
                else
                    return "five";
            case '6':
                if (tenth)
                    return "sixty";
                else if (teen)
                    return "sixteen";
                else
                    return "six";
            case '7':
                if (tenth)
                    return "seventy";
                else if (teen)
                    return "seventeen";
                else
                    return "seven";
            case '8':
                if (tenth)
                    return "eighty";
                else if (teen)
                    return "eighteen";
                else
                    return "eight";
            case '9':
                if (tenth)
                    return "ninety";
                else if (teen)
                    return "nineteen";
                else
                    return "nine";
        }

        return "-";
    }
}
