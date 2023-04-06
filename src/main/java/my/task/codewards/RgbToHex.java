package my.task.codewards;

public class RgbToHex {
    public static int colour(int color) {
        if (Math.max(color, 255) > 255) return 255;
        else if (Math.min(color, 0) < 0) return 0;
        return color;
    }

    public static void rgb(int r, int g, int b) {
        int RGBr = colour(r);
        int RGBg = colour(g);
        int RGBb = colour(b);
        System.out.printf("%02X%02X%02X%n", RGBr, RGBg, RGBb);
    }

    public static void main(String[] args) {

       RgbToHex.rgb(0, 0, 0);
       RgbToHex.rgb(1, 2, 3);
       RgbToHex.rgb(255, 255, 255);
       RgbToHex.rgb(254, 253, 252);
       RgbToHex.rgb(255, 255, 300);
       RgbToHex.rgb(-20, 275, 125);
        RgbToHex.rgb(174, -49, 4);
    }
}