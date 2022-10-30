public class Birthday {
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long trials = Long.parseLong(args[1]);
        long numPeaple[] = new long[n + 1];
        int date;
        boolean flag = true;
        int num = 0;

        for (long t = 0; t < trials; t++) {
            boolean[] bd = new boolean[n];
            flag = true;
            num = 0;
            while (flag) {
                date = (int) (Math.random() * n);
                if (!bd[date]) {
                    bd[date] = true;
                }
                else {
                    numPeaple[num] += 1;
                    flag = false;
                }
                num++;
            }
        }

        long sum = 0;
        for (int t = 0; t < n + 1; t++) {
            sum += numPeaple[t];
            System.out.println((t + 1) + " " + (numPeaple[t]) + " " + ((double) sum / trials));
            if (((double) sum / trials) >= 0.5) break;
        }
    }
}
