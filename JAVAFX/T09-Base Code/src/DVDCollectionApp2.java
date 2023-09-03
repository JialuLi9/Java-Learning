import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;



public class DVDCollectionApp2 extends Application {
    private DVDCollection model;


    public DVDCollectionApp2() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        Label label2 = new Label("Title");
        Label label3 = new Label("Year");
        Label label4 = new Label("Length");

        //relocation
        label1.relocate(10, 10);
        label2.relocate(10, 202);
        label3.relocate(10, 242);
        label4.relocate(120, 242);

        // Create the TextFields
        TextField tField = new TextField();
        TextField yField = new TextField();
        TextField lField = new TextField();

        tField.relocate(50, 200);
        tField.setPrefSize(500, 30);
        yField.relocate(50, 240);
        yField.setPrefSize(55, 30);
        lField.relocate(180, 240);
        lField.setPrefSize(45, 30);

        // Create the lists
        ListView<DVD> tList = new ListView<DVD>();
        tList.relocate(10, 40);
        tList.setPrefSize(540, 150);
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));


        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250, 240);
        buttonPane.setPrefSize(305, 30);

        //event - add a DVD
        buttonPane.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (tField.getText().length() > 0 && yField.getText().length() > 0 && lField.getText().length() > 0) {
                    String title = tField.getText();
                    int length = Integer.parseInt(lField.getText());
                    int year = Integer.parseInt(yField.getText());
                    DVD temp = new DVD(title, year, length);
                    model.add(temp);
                    tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
                }
            }
        });

        //event - delete a DVD
        buttonPane.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                DVD temp = tList.getSelectionModel().getSelectedItem();
                model.remove(temp.getTitle());
                tList.setItems(FXCollections.observableArrayList(model.getDVDList()));

            }
        });

        //select DVD and show in the TextFields
        tList.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                DVD selected = tList.getSelectionModel().getSelectedItem();
                if (selected != null){
                    tField.setText(selected.getTitle());
                    yField.setText(String.valueOf(selected.getYear()));
                    lField.setText(String.valueOf(selected.getDuration()));
                }
            }
        });

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 560, 280));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
