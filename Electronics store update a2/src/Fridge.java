public class Fridge extends Kitchenware{
    private boolean hasFreezer;
    public Fridge(double price, int quantity, int wattage, String color, String brand, boolean hasFreezer){
        super.Kitchenware(price, quantity, wattage , color, brand);
        this.hasFreezer = hasFreezer;
    }
    public double sellUnits(int amount) {
        return super.sellUnits(amount);
    }

    public String toString(){
        String format = String.format("%s Fridge ", getBrand());
        if (hasFreezer) {
            format += String.format("with Freezer (%s, %d watts)", getColor(), getWattage());
        }
        else {
            format += String.format("(%s, %d watts)", getColor(), getWattage());
        }
        return format;

    }

    public static void main(String args[]){
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", false);
        System.out.println(f1.toString());
    }
}
