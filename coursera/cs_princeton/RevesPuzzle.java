public class RevesPuzzle {
    
    // Write a program RevesPuzzle.java that takes an integer command-line 
    // argument n and prints a solution to Reve’s puzzle. 
    // Assume that the the discs are labeled in increasing order of size 
    // from 1 to n and that the poles are labeled A, B, C, and D, 
    // with A representing the starting pole and D representing the destination pole

    public static String move(int high, int low, String from, String mid, String to) {
        
        if (high < low) return "";
        String output = "";
        output += move(high - 1, low, from, to, mid);
        output += "Move disc " + high + " from " + from + " to " + to + "\n";
        output += move(high - 1, low, mid, from, to);
        return output;
    }

    public static String reve(int n, String from, String to, String mid1, String mid2) {

        if (n < 1) return "";
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        String output = "";
        output += reve(k, from, mid1, to, mid2);
        output += move(n, k + 1, from, mid2, to);
        output += reve(k, mid1, to, from, mid2);
        return output;
    }
    
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        String output = "";
        output += reve(n, "A", "D", "B", "C");
        StdOut.print(output);
    }   
}
