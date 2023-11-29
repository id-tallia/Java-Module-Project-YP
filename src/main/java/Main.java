import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);
    static String sScanner;

    public static void main(String[] args) {
        System.out.println("Калькулятор счёта");
        guests();
        goods();
        check();
        scanner.close();
    }

    static void guests () {
        do {
            System.out.println("Введите количество гостей, минимум двое");
            sScanner = scanner.next();
            if (isNumber(sScanner) == 0) {
                Calculator.setPeople(Integer.parseInt(sScanner));
            }
            if (Calculator.getPeople() <= 1) {
                System.out.println("Некорректное значение");
            } else {
                break;
            }
        } while (true);
    }

    static void goods () {
        String name;
        double price;

        do {
            System.out.println("\nВведите название товара или \"Завершить\", если все товары добавлены");
            name = scanner.next();
            if (name.trim().equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите его стоимость. (рубли.копейки)");
            do {
                sScanner = scanner.next();
                price = isNumber(sScanner) != -1 ? Double.parseDouble(sScanner) : -1.0;
                if (price < 0.0) {
                    System.out.println("Некорректное значение. Повторите ввод");
                } else {
                    break;
                }
            } while (true);
            Calculator.addProduct(new Product(name, price));
            System.out.println("Добавлен товар: " + name);
        } while (true);
    }

    static void check () {
        //товаров нет
        if (Calculator.getProductsSize() == 0) {
            System.out.println("\nТовары не добавлены");
            return;
        }

        System.out.println("\nДобавленные товары:");
        for (int i = 0; i < Calculator.getProductsSize(); i++) {
            System.out.println(Calculator.getProductInfo(i));
        }
        System.out.format("%s %.2f %s","\nСумма на каждого гостя равна", Calculator.getCheckGuest(), Formatter.formatPrice(Calculator.getCheckGuest()));
    }

    static int isNumber (String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return -1; //не число
        }

        try {
            Integer.parseInt(s);
            return 0; //целое
        } catch (NumberFormatException e) {
        }

        return 1; //дробное
    }
}