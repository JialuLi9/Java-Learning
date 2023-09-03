import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

public class ElectronicStoreView extends Pane {
    public final int wide = 800;
    public final int high = 400;
    private double price = 0.00f;
    private Label label1,label2,label3,label4,label5,label6,label7;
    private ArrayList<String> stockItems = new ArrayList<>();
    private ArrayList<Integer> saleItems = new ArrayList<>();
    private ArrayList<String> cartItems = new ArrayList<>();

    private ArrayList<String> popularItems;

    private ListView<String> itemList, stockList, cartList;
    private TextField priceOfSalesField, revenueField,numOfSalesField;
    private ButtonPane buttonPane;
    public ElectronicStoreView(){
        buttonPane = new ButtonPane();

        // Create the labels
        label1 = new Label("Store Summary:");
        label1.relocate(50, 20);
        label1.setPrefSize(100, 20);
        label2 = new Label("Store Stock:");
        label2.relocate(320, 20);
        label2.setPrefSize(100, 20);
        label3 = new Label(String.format("Current Cart: ($%.2f)", price));
        label3.relocate(620, 20);
        label3.setPrefSize(200, 20);

        label4 = new Label("# Sales:");
        label4.relocate(30, 45);
        label4.setPrefSize(100, 20);
        label5 = new Label("Revenue:");
        label5.relocate(30, 80);
        label5.setPrefSize(100, 20);
        label6 = new Label("$ / Sale:");
        label6.relocate(30, 115);
        label6.setPrefSize(100, 20);

        label7 = new Label("Most Popular items:");
        label7.relocate(30, 150);
        label7.setPrefSize(200, 20);

        itemList = new ListView<>();
        itemList.relocate(20,190);
        itemList.setPrefSize(150,150);

        stockList = new ListView<>();
        stockList.relocate(200,40);
        stockList.setPrefSize(280,300);

        cartList = new ListView<>();
        cartList.relocate(505,40);
        cartList.setPrefSize(280,300);

        priceOfSalesField = new TextField();
        priceOfSalesField.setText("0");
        priceOfSalesField.relocate(80,40);
        priceOfSalesField.setPrefSize(100, 30);

        revenueField = new TextField();
        revenueField.setText("0.00");
        revenueField.relocate(80,75);
        revenueField.setPrefSize(100, 30);

        numOfSalesField = new TextField();
        numOfSalesField.setText("N/A");
        numOfSalesField.relocate(80,110);
        numOfSalesField.setPrefSize(100, 30);

        getChildren().addAll(label1,label2,label3, label4,label5,label6,label7, buttonPane, itemList, stockList,cartList,priceOfSalesField,revenueField,numOfSalesField);
        setPrefSize(wide, high);
    }

    public void update(ElectronicStore model) {

        for (Product p : model.getStock()) {
            if(p!=null) {
                stockItems.add(p.toString());
                saleItems.add(p.getSoldQuantity());
            }
        }
        stockList.setItems(FXCollections.observableArrayList(stockItems));

        Collections.sort(saleItems, Collections.reverseOrder());
        popularItems = new ArrayList<>();
        for(int i=0; i<3; i++){
            int topSales = saleItems.get(i);
            for(Product product: model.getStock()){
                if(product.getSoldQuantity()==topSales && !popularItems.contains(product.toString())){
                    popularItems.add(product.toString());
                    break;
                }
            }
        }
        itemList.setItems(FXCollections.observableArrayList(popularItems));
    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }

    public ListView<String> getStockList() {
        return stockList;
    }
    public ListView<String> getCartList() {
        return cartList;
    }

    public ArrayList<String> getCartItems() {
        return cartItems;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
        label3.setText(String.format("Current Cart: ($%.2f)", this.price));
    }

    public TextField getNumOfSalesField() {
        return numOfSalesField;
    }

    public TextField getRevenueField() {
        return revenueField;
    }

    public ArrayList<String> getStockItems() {
        return stockItems;
    }

    public TextField getPriceOfSalesField(){return priceOfSalesField;}

    public ArrayList<String> getPopularItems() {
        return popularItems;
    }

    public ListView<String> getItemList() {
        return itemList;
    }

    public ArrayList<Integer> getSaleItems() {
        return saleItems;
    }
}
