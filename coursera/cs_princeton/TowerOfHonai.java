public class TowerOfHonai {
    
    public static String move(int n, boolean left) {
        String m;
        if (n == 0) return " ";
        if (left) m = n + "L";
        else m =  n + "R";
        return move(n-1, !left) + m + move(n-1, !left); 
    } 

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(move(n, false));
    }
}
