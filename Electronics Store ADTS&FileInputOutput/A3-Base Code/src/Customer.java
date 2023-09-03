import java.io.*;
import java.util.ArrayList;

public class Customer  implements Serializable{
    private String name;
    private ArrayList<Product> products ;
    private ArrayList<Integer> amount;
    private double totalSpend;

    public Customer(String name){
        this.name = name;
        this.products = new ArrayList<>();
        this.totalSpend = 0.0;
        this.amount= new ArrayList<>();;
    }

    public Customer(String name, ArrayList<Product> products, double totalSpend, ArrayList<Integer> amount) {
        this.name = name;
        this.products = products;
        this.totalSpend = totalSpend;
        this.amount = amount;
    }

    public String toString(){
        String output = String.format("%s who has spent $%.0f",this.name, this.totalSpend);
        return output;
    }

    public void printPurchaseHistory(){
        for (int i=0; i<products.size(); i++){

            String result = String.format("%dx%s", this.amount.get(i), this.products.get(i).getClass().getName());
            System.out.println(result);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    //after buy the product add it here
    public void addProducts(Product product) {
        this.products.add(product) ;
    }

    public double getTotalSpend(){
        return this.totalSpend;
    }

    public void setTotalSpend(double spend){
        this.totalSpend += spend;
    }

    public void addAmount(Integer amount) {
        this.amount.add(amount) ;
    }

    public ArrayList<Integer> getAmount() {
        return amount;
    }

}
