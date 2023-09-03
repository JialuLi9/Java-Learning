public class Oven extends Kitchenware{
    private boolean convection;

    public Oven(double price, int quantity, int wattage, String color, String brand, boolean convection){
        super.Kitchenware(price, quantity, wattage , color, brand);
        this.convection = convection;
    }

    public double sellUnits(int amount) {
        return super.sellUnits(amount);
    }

    public String toString(){
        String format = String.format("%s Oven ", getBrand());
        if (convection) {
            format += String.format("with convection (%s, %d watts)", getColor(), getWattage());
        }
        else {
            format += String.format("(%s, %d watts)", getColor(), getWattage());
        }
        return format;

    }
    /*public static void main(String args[]) {
        Oven t1 = new Oven(25, 10, 50, "Black", "Danby", false);
        System.out.println(t1.toString());
    }*/
}
