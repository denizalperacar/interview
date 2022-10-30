public class GeneralizedHarmonic {

    public static void main(String[] args) {
        // generalized harmonic function H(n, r) = \sum_{i=1}^{n}{\frac{1}{i^r}}
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0;
        
        for (int ind = 1; ind <= n; ind++) {
            h += 1 / Math.pow(ind, r);
        }

        System.out.println(h);

    }

}