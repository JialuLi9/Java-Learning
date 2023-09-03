public class Laptop extends Computer{
    private
    double screenSize;

    public Laptop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize){
        super.Computer(price, quantity, cpuSpeed, ram, ssd, storage);
        this.screenSize=screenSize;
    }

    public double sellUnits(int amount) {
        return super.sellUnits(amount);
    }

    public String toString(){
        String format = String.format("%.1f inch Laptop PC with %.1fghz CPU, %dGB RAM, ", screenSize, getCpuSpeed(), getRAM());
        if (isSsd()) {
            format += String.format("%dGB SSD drive.", getStorage());
        }
        else {
            format += String.format("%dGB HDD drive.", getStorage());
        }
        return format;

    }


    public static void main(String args[]){
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        System.out.println(l1.toString());
    }


}
