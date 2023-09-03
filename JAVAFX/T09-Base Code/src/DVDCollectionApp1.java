import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp1  extends Application {
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label label1 = new Label("Title");
        label1.relocate(10, 10);
        label1.setPrefSize(40, 20);
        Label label2 = new Label("Year");
        label2.relocate(220, 10);
        label2.setPrefSize(40, 20);
        Label label3 = new Label("Length");
        label3.relocate(290, 10);
        label3.setPrefSize(40, 20);

        // Create the lists
        String[]    titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        String[]    years = {"1978", "2002", "1968", "1999"};
        String[]    lengths = {"124", "93", "126", "148"};

        ListView<String> titlesList = new ListView<>();
        ObservableList<String> tList = FXCollections.observableArrayList(titles);
        titlesList.setItems(tList);
        titlesList.relocate(10,40);
        titlesList.setPrefSize(200,150);

        ListView<String> yearsList = new ListView<>();
        ObservableList<String> yList = FXCollections.observableArrayList(years);
        yearsList.setItems(yList);
        yearsList.relocate(220,40);
        yearsList.setPrefSize(60,150);

        ListView<String> lengthsList = new ListView<>();
        ObservableList<String> lList = FXCollections.observableArrayList(lengths);
        lengthsList.setItems(lList);
        lengthsList.relocate(290,40);
        lengthsList.setPrefSize(60,150);

        DVDButtonPane myPanel1 = new DVDButtonPane();
        myPanel1.relocate(30,200);
        myPanel1.setPrefSize(305,30);

        aPane.getChildren().addAll(label1,label2,label3,titlesList,yearsList,lengthsList, myPanel1);
        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 360,240)); // Set size of window
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
