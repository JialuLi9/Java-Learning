public class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public void Product(double price, int quantity){
        this.price = price;
        this.stockQuantity = quantity;
        this.soldQuantity = 0;

    }

    public double getPrice() {
        return price;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public double sellUnits(int amount){
        if (stockQuantity>=amount){
            stockQuantity -= amount;
            soldQuantity += amount;
            return amount*price;
        }
        else{
            return 0;
        }
    }


}
