public class TrinomialBrute {
    
    // Returns the trinomial coefficient T(n, k)
    public static long trinomial(int n, int k) {

        // add the base cases
        if (n == 0 && k == 0) {
            return 1;
        }
        else if (k < -n || k > n) {
            return 0;
        }
        else {
            // compute the recursion
            return trinomial(n - 1, k + 1) + trinomial(n - 1, k) + trinomial(n - 1, k - 1);  
        }
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}