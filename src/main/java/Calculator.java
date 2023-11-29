import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static List<Product> products = new ArrayList<>();
    static double calculator = 0.0;
    static int people = -1;

    public static void addProduct (Product product) {
        products.add(product);
        calculator += product.getPrice();
    }

    public static int getProductsSize () {
        return products.size();
    }

    public static int getPeople () {
        return people;
    }

    public static void setPeople (int p) {
        people = p;
    }
    public static String getProductInfo (int i) {
        return products.get(i).toString();
    }

    public static double getCheckGuest () {
        return calculator / (double)people;
    }

}
