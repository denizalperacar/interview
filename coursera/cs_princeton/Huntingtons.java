public class Huntingtons {


    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna){
        int count = 0;
        String seq = "CAG";
        int index = 0;
        while (index < 600) {
            // dna.length() - seq.length()) {
            if (dna.substring(index, index + 3).equals(seq)) { 
                StdOut.println(index + " " + dna.substring(index, index + 3));
                count++;
                index += 2;
            }
            else index++;
        }
        return count;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) { 
        if (181 <= maxRepeats || maxRepeats <= 9) return "not human"; 
        else {      
            if (10 <= maxRepeats && maxRepeats <= 35) return "normal";
            else if (36 <= maxRepeats && maxRepeats <= 39) return "high risk";
            else return "Huntington\'s";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        
        String inp = StdIn.readAll();
        inp = removeWhitespace(inp);
        int maxRepeat = maxRepeats(inp);
        StdOut.println("max repeats = " + maxRepeat);
        StdOut.println(diagnose(maxRepeat));
        
    }   
}
