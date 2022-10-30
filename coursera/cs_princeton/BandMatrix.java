public class BandMatrix {
    
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        String s = "";
        for (int ind1 = 0; ind1 < n; ind1++) {
            s = "";   
            for (int ind2 = 0; ind2 < n; ind2++) {
                if (Math.abs(ind1 - ind2) <= width) {
                    s += "*";
                }
                else {
                    s += "0";
                }
                if (ind2 < n-1) {
                    s += "  ";
                }
            }
            System.out.println(s);
        }
    } 
}
