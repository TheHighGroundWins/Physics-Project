package physics.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Physics sim");
        VBox vLayout = new VBox();
        Label objectLabel = new Label("Choose your object");
        CheckBox car = new CheckBox("car");
        CheckBox human = new CheckBox("human");
        CheckBox pumpkin = new CheckBox("pumpkin");

        vLayout.getChildren().addAll(objectLabel,car,human,pumpkin);
        StackPane root = new StackPane();

        root.getChildren().add(vLayout);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
