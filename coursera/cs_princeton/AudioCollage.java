public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {

        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }

        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {

        double[] b = new double[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[i] = a[a.length - i - 1];
        } 
        return b;

    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {

        double c[] = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        int l = Math.max(a.length, b.length);
        double[] c = new double[l];

        for (int i = 0; i < l; i++) {
            if (i > a.length - 1) c[i] = b[i];
            else if (i > b.length - 1) c[i] = a[i];
            else c[i] = a[i] + b[i];
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int l = (int) (a.length / alpha);
        double[] b = new double[l];

        for (int i = 0; i < l; i++) {
            b[i] = a[(int) Math.floor(i * alpha)];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        String[] wav_files = {"beatbox", "buzzer", "cow", "harp", "piano"};
        
        double[] s1 = StdAudio.read(wav_files[0] + ".wav");
        double[] s2 = StdAudio.read(wav_files[1] + ".wav");
        double[] s3 = StdAudio.read(wav_files[2] + ".wav");
        double[] s4 = StdAudio.read(wav_files[3] + ".wav");
        double[] s5 = StdAudio.read(wav_files[4] + ".wav");

        double[] out = changeSpeed(amplify(merge(merge(merge(mix(s1, reverse(s2)), s3), s4), s5), 0.5), 0.55);
        StdAudio.play(out);
    }
    
}
