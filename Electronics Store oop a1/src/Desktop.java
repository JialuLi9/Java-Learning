public class Desktop {
    double CPU_speed;
    int RAM_amount;
    int amount_storage;
    boolean SSD_HDD;

    public Desktop(double CPU, int RAM, int storage, boolean SSD){
        CPU_speed = CPU;
        RAM_amount = RAM;
        amount_storage = storage;
        SSD_HDD = SSD;
    }

    public String toString(){
        String result = String.format("Desktop PC with %.1fghz CPU, %dGB RAM, %dGB ",CPU_speed,RAM_amount,amount_storage);
        if (SSD_HDD){
            result += "SSD drive.";
        }
        else{
            result += "HDD drive.";
        }
        return result;
    }

    /*public static void main(String[] args) {
        Desktop d1 = new Desktop(3.5,8,500,true);
        String re = d1.toString();
        System.out.println(re);
    }*/
}
