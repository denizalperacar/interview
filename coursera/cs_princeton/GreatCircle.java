public class GreatCircle {
    public static void main(String[] argv) {
        double x1 = Double.parseDouble(argv[0]);
        double y1 = Double.parseDouble(argv[1]); 
        double x2 = Double.parseDouble(argv[2]);
        double y2 = Double.parseDouble(argv[3]);
        double r = 6371000.0;
        System.out.println(
            2.0*r*
            Math.asin(
                Math.sqrt(
                    Math.pow(Math.sin(Math.toRadians((x2 - x1)/2.0)), 2.0) +
                    Math.cos(Math.toRadians(x1)) * 
                    Math.cos(Math.toRadians(x2)) *
                    Math.pow(Math.sin(Math.toRadians((y2 - y1)/2.0)), 2.0)))/1000.0);
    }
}
