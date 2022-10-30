public class DiscreteDistribution {
    
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] s = new int[a.length + 1];
        int ind;
        double r;

        // intialize a
        for (ind = 0; ind < a.length; ind++) {
            a[ind] = Integer.parseInt(args[ind+1]);
        } 

        // calculate the cumulative prob.
        s[0] = 0;
        for (ind = 0; ind < a.length; ind++) {
            s[ind + 1] = a[ind] + s[ind];
        } 

        for (ind = 0; ind < m; ind++) {
            r = (Math.random() * (s[s.length - 1]));
            for (int ind2 = 1; ind2 < s.length; ind2++) {
                if ( s[ind2 -1 ] < r && r < s[ind2] ) {
                    System.out.print(ind2 + " ");
                }
            }

        }
        System.out.println();

    }

}
