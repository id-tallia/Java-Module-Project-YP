public class Product {

    String name;
    double price;

    Product (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice () {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f %s", this.name, this.price, Formatter.formatPrice(this.price));
    }
}
