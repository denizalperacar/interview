public class ShannonEntropy {
    
    public static void main(String[] args) {
        double h = 0.0;
        int[] count = new int[Integer.parseInt(args[0])];
        int c = 0;
        double p;
        while (!StdIn.isEmpty()) {
            count[StdIn.readInt() - 1] += 1;
            c += 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                p = (double) count[i] / c;
                h -= p * Math.log(p) / Math.log(2);
            }
        }
        StdOut.printf("%.4f\n", h);
    }    


}
