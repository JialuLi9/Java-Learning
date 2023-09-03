public class Kitchenware extends Product{
    private int wattage;
    private String color;
    private String brand;

    public void Kitchenware(double price, int quantity, int wattage, String color, String brand){
        super.Product(price, quantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
    }

    public int getWattage() {
        return wattage;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
