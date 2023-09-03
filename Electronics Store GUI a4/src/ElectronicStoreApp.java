import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class ElectronicStoreApp extends Application {
    private ElectronicStore model;
    private double totalPrice =0;

    private HashMap<String, Integer> hashMap = new HashMap<>();
    public ElectronicStoreApp() {model = ElectronicStore.createStore();}

    public void start(Stage stage){
        Pane aPane = new Pane();

        ElectronicStoreView view = new ElectronicStoreView();

        view.update(model);
        aPane.getChildren().add(view);

        stage.setTitle("Electronic Store Application -"+ model.getName());
        stage.setResizable(false);
        stage.setScene(new Scene(aPane));
        stage.show();

        //add event
        view.getButtonPane().getAddButton().setDisable(true);

        view.getStockList().getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue != null)
                view.getButtonPane().getAddButton().setDisable(false);
        }));

        if (view.getCartItems().isEmpty()) {
            view.getButtonPane().getSaleButton().setDisable(true);
            view.getButtonPane().getRemoveButton().setDisable(true);
        }

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>(){


            public void handle(ActionEvent actionEvent) {
                view.getButtonPane().getSaleButton().setDisable(false);

                String select = view.getStockList().getSelectionModel().getSelectedItem();
                int index = view.getStockItems().indexOf(select);
                double price = model.getStock()[index].getPrice();


                if (hashMap.containsKey(select)){
                    int value = hashMap.get(select);
                    value+=1;
                    hashMap.put(select,value);

                }else {
                    hashMap.put(select,1);
                }
                totalPrice+=price;

                ObservableList<String> newList = FXCollections.observableArrayList();
                for(HashMap.Entry<String, Integer> entry: hashMap.entrySet()){
                    String item = entry.getKey();
                    String value = String.valueOf(entry.getValue());
                    String output = value+"x"+item;
                    if(entry.getValue()!=0 && entry.getValue()<10) {
                        newList.add(output);
                    } else if (entry.getValue()==10) {
                        newList.add(output);
                        view.getStockItems().remove(index);
                        view.getStockList().getItems().setAll(view.getStockItems());
                    }

                }

                view.getCartList().getItems().setAll(newList);
                view.setPrice(totalPrice);

            }
        });



        //enable to remove button event
        view.getCartList().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getButtonPane().getRemoveButton().setDisable(false);
            }
        });



        view.getButtonPane().getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {

                String select = view.getCartList().getSelectionModel().getSelectedItem();
                String subString = select.substring(select.indexOf("x")+1);

                int value;

                if (hashMap.containsKey(subString)) {
                    value = hashMap.get(subString);
                    if (value > 1 && value!=10) {
                        value -= 1;
                        hashMap.put(subString, value);
                    } else if (value==10) {
                        value -= 1;
                        hashMap.put(subString, value);
                        view.getStockItems().add(subString);
                        view.getStockList().getItems().setAll(view.getStockItems());

                    } else {
                        hashMap.remove(subString);
                    }
                } else {
                    System.out.println("Key not found: " + subString);
                }

                int index = view.getStockItems().indexOf(subString);
                double price = model.getStock()[index].getPrice();
                totalPrice-=price;

                ObservableList<String> newList = FXCollections.observableArrayList();

                for(HashMap.Entry<String, Integer> entry: hashMap.entrySet()){
                    String item = entry.getKey();
                    String times = String.valueOf(entry.getValue());
                    String output = times +"x"+item;
                    if(entry.getValue()!=0)
                        newList.add(output);
                }
                view.getCartList().getItems().setAll(newList);
                view.setPrice(totalPrice);

                if(view.getCartItems().isEmpty()){
                    view.getButtonPane().getRemoveButton().setDisable(true);
                }

            }
        });

        view.getButtonPane().getSaleButton().setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent actionEvent) {
                int sales=0;
                double revenue = model.getRevenue() + totalPrice;
                Product temp = null;
                ObservableList<String> newList = FXCollections.observableArrayList();

                if(hashMap.size()>0){
                    sales ++;
                    model.setRevenue(revenue);

                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();

                        temp= model.findProduct(key);

                        temp.sellUnits(value);


                    }

                    view.getCartList().getItems().clear();
                    view.getCartItems().clear();
                    hashMap.clear();

                    view.getNumOfSalesField().setText(String.valueOf(sales));
                    view.getRevenueField().setText(String.format("%.2f",revenue));
                    view.getPriceOfSalesField().setText(String.valueOf(totalPrice));

                    totalPrice = 0.00;
                    view.setPrice(totalPrice);
                }

                //sort the sold item
                ArrayList<Product> notNull = new ArrayList<>();
                for(Product p:model.getStock()){
                    if(p!=null){
                        notNull.add(p);
                    }
                }
                Collections.sort(notNull, new Comparator<Product>() {
                    public int compare(Product p1, Product p2) {
                        return Integer.compare(p2.getSoldQuantity(), p1.getSoldQuantity());
                    }
                });

                view.getPopularItems().clear();
                for(int i=0; i<3; i++){
                    view.getPopularItems().add(notNull.get(i).toString());
                }

                ObservableList<String> popularItems = FXCollections.observableArrayList(view.getPopularItems());
                view.getItemList().setItems(popularItems);
            }
        });

        view.getButtonPane().getResetButton().setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent actionEvent) {
                ElectronicStore newStore = ElectronicStore.createStore();
                Pane newPane = new Pane();

                view.getStockList().getItems().clear();
                view.getStockItems().clear();
                view.getItemList().getItems().clear();
                view.getPopularItems().clear();
                view.getCartList().getItems().clear();
                view.getCartItems().clear();

                view.getPriceOfSalesField().clear();
                view.getNumOfSalesField().clear();
                view.getRevenueField().clear();

                view.update(newStore);
                newPane.getChildren().add(view);

                stage.setTitle("Electronic Store Application -"+ newStore.getName());
                stage.setResizable(false);
                stage.setScene(new Scene(newPane));
                stage.show();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }

}
