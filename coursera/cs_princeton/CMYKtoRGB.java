public class CMYKtoRGB {

    public static void main(String[] argv) {
        double c = Double.parseDouble(argv[0]);
        double m = Double.parseDouble(argv[1]); 
        double y = Double.parseDouble(argv[2]);
        double k = Double.parseDouble(argv[3]);
        double white = 1 - k;
        double red = 255 * white * (1-c);
        double green = 255 * white * (1-m);
        double blue = 255 * white * (1-y);
        System.out.println("red   = "+  Math.round(red) + "\ngreen = " +  Math.round(green) + "\nblue  = " + Math.round(blue));
    }

}
