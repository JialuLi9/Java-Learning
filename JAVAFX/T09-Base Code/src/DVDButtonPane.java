
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class DVDButtonPane extends Pane {
    private Button addButton;
    private Button deleteButton;
    private Button statsButton;

    public DVDButtonPane() {
        Pane  aPane = new Pane();

        addButton = new Button("Add");
        addButton.relocate(0, 0);
        addButton.setPrefSize(90, 30);
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,255,0); " +
                "-fx-text-fill: rgb(255,255,255);");

        deleteButton = new Button("Delete");
        deleteButton.relocate(100, 0);
        deleteButton.setPrefSize(90, 30);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,0,0); " +
                "-fx-text-fill: rgb(255,255,255);");

        statsButton = new Button("Stats");
        statsButton.relocate(210, 0);
        statsButton.setPrefSize(90, 30);
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(128,128,128); " +
                "-fx-text-fill: rgb(255,255,255);");

        aPane.getChildren().addAll(addButton, deleteButton,statsButton);
        getChildren().addAll(aPane);

    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton(){
        return deleteButton;
    }

    public Button getStatsButton() {
        return statsButton;
    }
}
