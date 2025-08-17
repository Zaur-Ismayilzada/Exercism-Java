public class SquareRoot {
    public int squareRoot(int radicand) {
        int n = 0;
        int res = (int)(0.5 * (radicand / 2.0 + (radicand / (radicand / 2.0))));

        while (n != 20){
            res = (int)(0.5 * (res + radicand / res));
            n++;
        }

        return res;
    }
}
