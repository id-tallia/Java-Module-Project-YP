public class Formatter {
    public static String formatPrice(double price) {
        int p = round(price) % 100;
        if ((p > 10) && (p < 20)) {
            return "рублей";
        }

        p %= 10;
        switch (p) {
            case (1):
                return "рубль";
            case (2) :
            case (3) :
            case (4) :
                return "рубля";
            default:
                return "рублей";
        }
    }

    public static int round (double d) {
        return (int)Math.floor(d);
    }
}
