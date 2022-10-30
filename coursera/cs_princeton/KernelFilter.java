public class KernelFilter {

    private static Picture periodicPad(Picture picture, int padding) {
        int height = picture.height() + 2 * padding;
        int width = picture.width() + 2 * padding;

        Picture pic = new Picture(width, height);

        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                pic.set(i + padding, j + padding, picture.get(i, j));
            }
        }

        // pad height
        for (int i = 0; i < padding; i++) {
            for (int j = 0; j < picture.height(); j++) {
                pic.set(
                    i, j + padding, 
                    picture.get(picture.width() + i - padding, j)
                );
                pic.set(
                    picture.width() + i + padding, j + padding, 
                    picture.get(i, j)
                );
            }
        }

        // pad height
        for (int i = 0; i < padding; i++) {
            for (int j = 0; j < picture.width(); j++) {
                pic.set(
                    j + padding, i, 
                    picture.get(j, picture.height() + i - padding)
                );
                pic.set(
                    j + padding, picture.height() + i + padding, 
                    picture.get(j, i)
                );
            }
        }

        return pic;
    }

    private static Picture crossCorrelation(Picture pic, int[][] kernel){

        Picture data = periodicPad(pic, (kernel.length - 1) / 2);
        Picture result = new Picture(pic);
        double[] channelSum = new double[3];
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                // zero channelSum
                for (int m = 0; m < 3; m++) {
                    channelSum[m] = 0.;
                }
                // do convolution channelwise
                for (int k = 0; k < kernel.length; k++) {
                    for (int l = 0; l < kernel[k].length; l++) {

                        channelSum[0] += kernel[k][l] * data.get().getRed();
                        channelSum[1] += kernel[k][l] * data.get().getGreen();
                        channelSum[2] += kernel[k][l] * data.get().getBlue();

                    }
                }
                result.setRGB(i, j, Color());
            }
        }

        return result;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        return picture;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String fileName = args[0];
        Picture pic = new Picture(fileName);
        int[][] kernel = {{0, 0, 0},{0,1,0},{0,0,0}};
        crossCorrelation(pic, kernel).show();
    }

}
