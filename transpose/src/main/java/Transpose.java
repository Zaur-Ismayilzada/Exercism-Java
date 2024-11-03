public class Transpose {
    public String transpose(String toTranspose) {
        if (toTranspose.isEmpty())return "";

        String[] words = toTranspose.split("\n");
        String   res   = "";

        int max_length = -1;

        boolean flag = false;

        for (String word : words){
            if (word.length() > max_length)
                max_length = word.length();
        }

        for (int i = max_length - 1; i >= 0; i--){
            String temp = "";
                   flag = false;
            for (int j = words.length - 1; j >= 0; j--){
                if (i < words[j].length()){
                    temp  = words[j].charAt(i) + temp;
                    flag  = true;
                }else{
                    if (flag)temp = " " + temp;
                }
            }
            temp = "\n" + temp;
            res  = temp + res;
        }

        return res.substring(1);
    }
}
