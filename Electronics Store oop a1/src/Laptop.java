public class Laptop {
    double CPU_speed;
    int RAM_amount;
    int amount_storage;
    boolean SSD_HDD;
    int screen_size;

    public Laptop(double CPU, int RAM, int storage, boolean SSD, int scr_size){
        CPU_speed = CPU;
        RAM_amount = RAM;
        amount_storage = storage;
        SSD_HDD = SSD;
        screen_size = scr_size;
    }

    public String toString(){
        String result = String.format("%d\" Laptop PC with %.1fghz CPU, %dGB RAM, %dGB ",screen_size,CPU_speed,RAM_amount,amount_storage);
        if (SSD_HDD){
            result += "SSD drive.";
        }
        else{
            result += "HDD drive.";
        }
        return result;
    }

    public static void main(String[] args) {
        Laptop d1 = new Laptop(3.5,8,500,true,15);
        String re = d1.toString();
        System.out.println(re);
    }
}
