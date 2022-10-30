public class Ramanujan {
    
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long h = (int) Math.pow(n, 1./ 3.) + 1;
        long small = 1;
        long large = h;
        int count = 0;
        
        while (small < large) {

            if (Math.pow(small, 3) + Math.pow(large, 3) == n){ 
                count++;
                small++;
            }
            else if (Math.pow(small, 3) + Math.pow(large, 3) < n) small++;
            else large--;
        }

        if (count > 1) return true;
        else return false;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }

}
