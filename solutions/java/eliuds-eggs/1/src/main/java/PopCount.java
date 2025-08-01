public class PopCount {
    public int eggCount(int number) {
        int res = 0;
        
        while (number > 0){
            int rightBit = number & 1;

            if (rightBit == 1){
                res++;
            }
            
            number = number >> 1;
        }

        return res;
    }
}
