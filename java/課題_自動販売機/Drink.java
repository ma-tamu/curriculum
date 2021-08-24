public class Drink {

    public String code;
    public String name;
    public Integer price;

    public Drink() {

    }

    public Drink(final String code, final String name, final int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // public void setCode(final String code) {
    // this.code = code;
    // }
    //
    // public void setName(final String name) {
    // this.name = name;
    // }
    //
    // public void setPrice(final int price) {
    // this.price = price;
    // }

    public String getCode() {
        return this.code;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setMenu() {
        System.out.println(name + " " + price);
    }
}
