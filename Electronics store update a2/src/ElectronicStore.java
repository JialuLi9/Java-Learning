import java.util.Scanner;
public class ElectronicStore {
    final int MAX_PRODUCTS = 10;
    String name;
    double revenue;

    //an array of electronic store products
    Product storeProduct[];

    public ElectronicStore(String name) {
        final int MAX_PRODUCTS = 10;
        this.name = name;
        this.revenue = 0;
        //an array of electronic store products
        this.storeProduct = new Product[MAX_PRODUCTS];
    }

    public String getName(){ return this.name;}

    public boolean addProduct(Product p){
        for (int i=0; i<storeProduct.length;i++){
            if (storeProduct[i] == null){
                storeProduct[i] = p;
                return true;
            }
        }
        return false;
    }


    public boolean sellProducts(){
        for (int i=0; i<storeProduct.length; i++){
            if(storeProduct[i]!=null){
                System.out.println(i + ". " + storeProduct[i].toString());
            }
        }
        System.out.println("Which product you are interested in?");
        int index = new Scanner(System.in).nextInt();
        System.out.println("How many would you l;ike to have?");
        int amount = new Scanner(System.in).nextInt();
        if (index>=0 && index<= storeProduct.length && storeProduct[index]!=null && amount>=0){
            revenue += storeProduct[index].sellUnits(amount);
            return true;
        }
        else{
            return false;
        }

    }

    public boolean sellProducts(int item, int amount){

        if (item>=0 && item<= storeProduct.length && storeProduct[item]!=null && amount>=0){
            revenue += storeProduct[item].sellUnits(amount);
            return true;
        }
        else{
            return false;
        }
    }

    public double getRevenue(){
        return revenue;
    }

    public void printStock(){
        for (int i=0; i<storeProduct.length; i++){
            if (storeProduct[i] != null){
                System.out.print(i + ". " + storeProduct[i].toString());
                String format = String.format(" (%.1f dollars each, %d in stock, %d sold)", storeProduct[i].getPrice(), storeProduct[i].getStockQuantity(), storeProduct[i].getSoldQuantity());
                System.out.println(format);
            }
        }
    }
    
}