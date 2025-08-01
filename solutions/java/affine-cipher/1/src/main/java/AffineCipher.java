public class AffineCipher {
    
    public String encode(String text, int a, int b){
        int _gcd = gcd(a, 26);

        if (_gcd != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");

        String plain_text = get_plain(text);  
        String encoded    = "";

        for (int i = 0; i < plain_text.length(); i++){
            char temp = plain_text.charAt(i);

            if (Character.isLetter(temp))
                encoded += (char)(((a * (temp - 'a') + b) % 26) + 'a');
            else
                encoded += temp;
        }

        String res = "";
        int    k   = 0;

        while (k + 4 < encoded.length()){
            res += encoded.substring(k, k + 5) + " ";
            k   += 5;
        }

        if (k < encoded.length())
            res += encoded.substring(k);
        else
            return res.substring(0, res.length() - 1);

        return res;
    }

    public String decode(String text, int a, int b){
        int _gcd = gcd(a, 26);

        if (_gcd != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");

        int mmi = get_mmi(a);

        String res = "";

        for (int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);

            if (Character.isLetter(temp))
                res += (char)(mod(mmi * (temp - 'a' - b), 26) + 'a');
            else if (Character.isDigit(temp))
                res += temp;
        }

        return res;
    }

    private int gcd(int a, int b){
        if (b > a)
            return gcd(b, a);

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    private String get_plain(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);

            if (Character.isLetter(temp) || Character.isDigit(temp))
                res += Character.toLowerCase(temp);
        }

        return res;
    }

    private int get_mmi(int a){
        int k = 2;

        while (k * a % 26 != 1)k++;

        return k;
    }

    private int mod(int a, int b){
        if (a < 0){
            while (a < 0)
                a += b;
        }else
            return a % b;

        return a;
    }
}