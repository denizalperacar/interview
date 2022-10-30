public class Checkerboard {
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean flag_row = false;
        boolean flag_col;
        StdDraw.setScale(0, n);

        for ( int i = 0; i < n; i++) {
            flag_row = !flag_row;
            flag_col = flag_row;
            for (int j = 0; j < n; j++) {
                if (flag_col) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5); 
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
                flag_col = !flag_col;
            }
        }
    }
}
