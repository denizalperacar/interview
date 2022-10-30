public class Minesweeper {
    
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        
        boolean[][] mines = new boolean[m][n];
        int[][] grid = new int[m][n];

        int ele_x;
        int ele_y;

        int h = 0;
        while (h < k) {
            ele_x = (int) (Math.random() * m);
            ele_y = (int) (Math.random() * n);
            if (!(mines[ele_x][ele_y])) {
                mines[ele_x][ele_y] = true;
                
                for (int j = -1; j < 2; j++) {
                    for (int l = -1; l < 2; l++) {
                        if ((ele_x + j >= 0 && ele_x + j < m) && (ele_y + l >= 0 && ele_y + l < n)) {
                            grid[ele_x + j][ele_y + l] += 1;
                        }
                    }
                }
                h += 1;
            }
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) System.out.print("*  ");
                else {
                    System.out.print(grid[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
