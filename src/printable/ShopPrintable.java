package printable;

public class ShopPrintable implements Printable {
    private String name;

    public ShopPrintable(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Печать магазина: " + name);
    }
}