class CryptoSquare {

    private String plaintext;

    CryptoSquare(String plaintext) {
        String plain = "";

        for (int i = 0; i < plaintext.length(); i++){
            char temp = plaintext.charAt(i);
            if (Character.isLetter(temp) || Character.isDigit(temp))
                plain += Character.toLowerCase(temp);
        }

        this.plaintext = plain;
    }

    String getCiphertext() {
        if (plaintext.isEmpty())
            return "";

        int   len   = plaintext.length();
        int[] sides = get_sides(len);
        int   col   = sides[0];
        int   row   = sides[1];
        int   idx   = 0;

        char[][] square = new char[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (idx < len)
                    square[i][j] = plaintext.charAt(idx);
                else
                    square[i][j] = ' ';

                idx++;
            }
        }

        String res = "";

        for (int j = 0; j < col; j++){
            String temp = "";

            for (int i = 0; i < row; i++){
                temp += square[i][j];
            }

            res += temp + " ";
        }

        return res.substring(0, res.length() - 1);
    }

    private int[] get_sides(int len){
        int c = 1;
        int r = 1;

        while (r * c < len){
            if (c > r)
                r++;
            else
                c++;
        }

        return new int[]{c, r};
    }
}
