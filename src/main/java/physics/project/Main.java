package physics.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    //all the object Vbox layouts are here
    private VBox objectVlayout;
    private VBox object2Vlayout;
    private VBox object1Vlayout;



    private Label object1Label;
    private CheckBox wood1;
    private CheckBox copper1;
    private CheckBox gold1;

    private Label object2Label;
    private  CheckBox wood2;
    private CheckBox copper2;
    private CheckBox gold2;

    private HBox masterMass1Outer;
    private HBox masterMass2Outer;
    private VBox masterMass1;
    private VBox massVlayout;
    private Label mass1Label;
    private TextField mass1Field;

    private VBox masterMass2;
    private Label mass2Label;
    private TextField mass2Field;

    //temperature layouts
    private HBox masterTemp1Outer;
    private HBox masterTemp2Outer;
    private VBox masterTemp1;
    private VBox tempVlayout;
    private Label temp1Label;
    private TextField temp1Field;

    private VBox masterTemp2;
    private Label temp2Label;
    private TextField temp2Field;



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Physics sim");
        BorderPane root = new BorderPane();
        objectVlayout = new VBox();
        object1Vlayout = new VBox();
        object2Vlayout = new VBox();
        object1Label = new Label("Choose your first object");
        wood1 = new CheckBox("wood");
        copper1 = new CheckBox("copper");
        gold1 = new CheckBox("gold");

        //setting font size
        object1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        wood1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        object1Vlayout.getChildren().addAll(object1Label,wood1,copper1,gold1);

        object2Label = new Label("Choose your second object");
        wood2 = new CheckBox("wood");
        copper2 = new CheckBox("copper");
        gold2 = new CheckBox("gold");

        object2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        wood2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        object2Vlayout.getChildren().addAll(object2Label,wood2,copper2,gold2);

        objectVlayout.getChildren().addAll(object1Vlayout,object2Vlayout);

        masterMass1 = new VBox();
        masterMass2 = new VBox();
        masterMass1Outer = new HBox();
        masterMass2Outer = new HBox();

        massVlayout =new VBox();
        mass1Label = new Label("Enter your mass for your first object");
        mass1Field = new TextField("Object1 mass");
        mass2Label = new Label("Enter your mass for your second object");
        mass2Field = new TextField("Object2 mass");

        mass1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass1Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass2Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        mass1Field.setPrefWidth(5);
        mass2Field.setPrefWidth(5);
        mass1Field.setAlignment(Pos.CENTER);
        mass2Field.setAlignment(Pos.CENTER);

        //temp intiator
        masterTemp1 = new VBox();
        masterTemp2 = new VBox();
        masterTemp1Outer = new HBox();
        masterTemp2Outer = new HBox();

        tempVlayout =new VBox();
        temp1Label = new Label("Enter the temperature for your first object");
        temp1Field = new TextField("Object1 temperature");
        temp2Label = new Label("Enter the temperature for your first object");
        temp2Field = new TextField("Object2 temperature");

        temp1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp1Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp2Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        temp1Field.setPrefWidth(5);
        temp2Field.setPrefWidth(5);
        temp1Field.setAlignment(Pos.CENTER);
        temp2Field.setAlignment(Pos.CENTER);





        masterMass1.getChildren().addAll(mass1Label,mass1Field);
        masterMass2.getChildren().addAll(mass2Label,mass2Field);

        masterMass1Outer.getChildren().add(masterMass1);
        masterMass2Outer.getChildren().add(masterMass2);
        massVlayout.getChildren().addAll(masterMass1Outer,masterMass2Outer);


        //temperature
        masterTemp1.getChildren().addAll(temp1Label,temp1Field);
        masterTemp2.getChildren().addAll(temp2Label,temp2Field);

        masterTemp1Outer.getChildren().add(masterTemp1);
        masterTemp2Outer.getChildren().add(masterTemp2);
        tempVlayout.getChildren().addAll(masterTemp1Outer,masterTemp2Outer);

        //adding to root
        root.setLeft(objectVlayout);
        root.setCenter(massVlayout);
        root.setBottom(tempVlayout);




        primaryStage.setScene(new Scene(root, 1080, 600));
        primaryStage.show();

    }
}
