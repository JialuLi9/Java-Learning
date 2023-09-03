public class Desktop extends Computer{
    private String profile;


    public Desktop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile){
        super.Computer(price, quantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }


    public double sellUnits(int amount) {
        return super.sellUnits(amount);
    }

    public String toString(){
        String format = String.format("%s Desktop PC with %.1fghz CPU, %dGB RAM, ", profile, getCpuSpeed(), getRAM());
        if (isSsd()) {
            format += String.format("%dGB SSD drive.", getStorage());
        }
        else {
            format += String.format("%dGB HDD drive.", getStorage());
        }
        return format;

    }

    /*test*/
    public static void main(String args[]){
        Desktop d1 = new Desktop(100.0, 10, 3.0, 16, false, 250, "Compact");
        System.out.println(d1.toString());
    }

}
