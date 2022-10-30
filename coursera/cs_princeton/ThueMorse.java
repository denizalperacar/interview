public class ThueMorse {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        boolean[] seq = new boolean[n];
        
        for (int i = 1; i < n; i++) {
            for (int j = (int) Math.pow(2, i - 1); j < (int) Math.pow(2, i) && j < n; j++) {
                seq[j] = ! seq[j - (int) Math.pow(2, i - 1)];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (seq[i] == seq[j]) {
                    System.out.print("+  "); 
                }
                else {
                    System.out.print("-  "); 
                }
            }
            System.out.println();
        }
    }
}
