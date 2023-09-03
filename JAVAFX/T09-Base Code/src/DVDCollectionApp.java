import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp  extends Application {
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


        // Create the buttons
        // The following code shows how to set the font,
        // background color and text color of a button:
        // b.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " +
        //     "-fx-text-fill: rgb(255,255,255);");
        //the 3 rgb values represent the red/green/blue values for the color your want
        Button addButton = new Button("Add");
        addButton.relocate(10, 200);
        addButton.setPrefSize(95, 30);
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,255,0); " +
                    "-fx-text-fill: rgb(255,255,255);");

        Button deleteButton = new Button("Delete");
        deleteButton.relocate(115, 200);
        deleteButton.setPrefSize(95, 30);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,0,0); " +
                "-fx-text-fill: rgb(255,255,255);");

        Button statsButton = new Button("Stats");
        statsButton.relocate(290, 200);
        statsButton.setPrefSize(60, 30);
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(128,128,128); " +
                "-fx-text-fill: rgb(255,255,255);");

        aPane.getChildren().addAll(label1,label2,label3,titlesList,yearsList,lengthsList,addButton,deleteButton,statsButton);
        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 360,240)); // Set size of window
        primaryStage.show();

        // Don't forget to add the components to the window, set the title,
        // make it non-resizable, set Scene dimensions and then show the stage
        // ... ADD CODE HERE ... //
    }

    public static void main(String[] args) {
        launch(args);
    }
}
