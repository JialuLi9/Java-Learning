import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;


public class DVDCollectionApp1 extends Application {
    public DVDCollection model;

    public DVDCollectionApp1() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the view
        DVDCollectionAppView1 view = new DVDCollectionAppView1();

        aPane.getChildren().add(view);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();

        view.update(model, 0);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String title = javax.swing.JOptionPane.showInputDialog("Title: ");
                Integer year = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Year: "));
                Integer length = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Year: "));

                DVD d = new DVD(title, year, length);
                model.add(d);
                view.update(model, 0);
            }
        });

        view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String temp = view.getTitleList().getSelectionModel().getSelectedItem();
                model.remove(temp);
                view.update(model,0);
            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                int selected = view.getTitleList().getSelectionModel().getSelectedIndex();
                view.getYearList().getSelectionModel().select(selected);
                view.getLengthList().getSelectionModel().select(selected);
                view.update(model,0);
            }

        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}