public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversions = 0;
        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i]; 
        }
        
        int start = 1;
        int j;
        int temp;

        while (start < a.length) {
            j = start;
            if (arr[start-1] < arr[start]) start ++;
            while ((j < arr.length) && arr[j - 1] > arr[j] ) {
                inversions++;
                // flip
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                // increment carrier index
                j++;
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        int[] permutation = new int[n];
        int ind = 0;
        int low = 0;
        int high = n-1;

        while (ind < n) {
            if ( high < k) {
                permutation[ind] = high;
                k -= high;
                high -= 1;
            }
            else {
                permutation[n - (int) k - 1] = high;
                low = high - (int) k;
                break;
            }
            ind++;
        }

        for (int i = 0; i < low; i++) permutation[ind + i] = i;
        for (int i = low + 1; i <= high; i++) permutation[ind + i] = i - 1;
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permutation = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(permutation[i] + " ");
        }
    }
}
