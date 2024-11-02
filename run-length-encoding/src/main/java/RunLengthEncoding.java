class RunLengthEncoding {

    String encode(String data) {
        if (data.length() < 1)return data;

        String res = "";

        char temp  = data.charAt(0);
        int  count = 1;

        for (int i = 1; i < data.length(); i++){
            if (data.charAt(i) != temp){
                if (count == 1)res += temp;
                else res  += count + "" + temp;
        
                temp  = data.charAt(i);
                count = 1;
            }else count++;
    
        }

        if (count == 1)res += temp;
        else res += count + "" + temp;



        return res;
    }

    String decode(String data) {
        int    idx   = 0;
        String count = "";
        String res   = "";

        while (idx < data.length()){
            if (!Character.isDigit(data.charAt(idx))){
                if (!count.isEmpty()){
                    int temp = Integer.parseInt(count);
                    count    = "";
                    while (temp != 0){
                        res += data.charAt(idx);
                        temp--;
                    }
                }else res += data.charAt(idx);
            }else count += data.charAt(idx);

            idx++;
        }

        return res;
    }

}