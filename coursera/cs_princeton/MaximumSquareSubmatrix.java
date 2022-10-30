public class MaximumSquareSubmatrix {
    
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a){

        int[][] mat = new int[a.length + 2][a[0].length + 2];
        int max = 0;
        for (int j = 1; j < (mat.length - 1); j++){
            for (int i = 1; i < (mat[j - 1].length - 1); i++) {
                if (a[i - 1][j - 1] == 0) mat[i][j] = 0;
                else {
                    // incrementation
                    // mat[i][j] = Math.min(Math.min(a[i][j - 1], a[i][j]), a[i - 1][j]);
                    // history
                    mat[i][j] += Math.min(Math.min(mat[i - 1][j], mat[i - 1][j - 1]), mat[i][j - 1]) + 1;
                    if (mat[i][j] > max) max = mat[i][j];
                }       
            }
        }
        if (max == 0) return 0;
        else return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        
        int n = StdIn.readInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = StdIn.readInt();
            }
        } 
        StdOut.println(size(mat));
    }

}
