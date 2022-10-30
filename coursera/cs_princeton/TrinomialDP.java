public class TrinomialDP {
    
    // Returns the trinomial coefficients T(n, k)
    public static long trinomial(int n, int k) {
        // add the base cases
        if (n == 0 && k == 0) {
            return 1;
        }
        else if (k < -n || k > n) {
            return 0;
        }
        
        long[] coef = new long[2 * n + 3];
        coef[1] = 1; 
        coef[2] = 1; 
        coef[3] = 1;

        for (int i = 2; i <= n; i++) {
            long[] temp = new long[2 * i + 3];
            for (int j = 1; j < 2 * i + 3; j++) {
                temp[j] = coef[j];
                if (j > 2) {
                    coef[j - 1] = temp[j - 3] + temp[j - 2] + temp[j - 1];
                }
            }
        }
        return coef[n + k + 1];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
