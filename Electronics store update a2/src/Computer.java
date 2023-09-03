public class Computer extends Product{
    private double cpuSpeed;
    private int RAM;
    private boolean ssd;
    private int storage;


    public void Computer(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage) {
        super.Product(price, quantity);
        this.cpuSpeed=cpuSpeed;
        this.RAM=ram;
        this.ssd = ssd;
        this.storage=storage;
    }

    public double getCpuSpeed() {return cpuSpeed;}

    public int getRAM() {return RAM;}

    public boolean isSsd() {return ssd;}

    public int getStorage() {return storage;}



}
