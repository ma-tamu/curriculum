public class Drink {

    private final String code;
    private final String name;
    private final Integer price;

    public Drink(final String code, final String name, final int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void displayMenu() {
        System.out.println(name + " " + price);
    }

    public void selectMenu() {
        System.out.println(name + ":" + code);
    }
}
