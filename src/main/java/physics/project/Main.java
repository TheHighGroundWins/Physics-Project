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

    //VBoxes that encapsulate the components
    private VBox objectVlayout;
    private VBox object2Vlayout;
    private VBox object1Vlayout;
    //encanpsulation


    //the object choosers
    private Label object1Label;
    private CheckBox wood1;
    private CheckBox copper1;
    private CheckBox gold1;

    private Label object2Label;
    private CheckBox wood2;
    private CheckBox copper2;
    private CheckBox gold2;
    //-------------------------

    //this keeps the layout of the components perfect
    private HBox masterMass1Outer;
    private HBox masterMass2Outer;
    private VBox masterMass1;
    private VBox massVlayout;
    private VBox masterMass2;
    //do not change this

    //the label and text fields of the mass
    private Label mass1Label;
    private TextField mass1Field;


    private Label mass2Label;
    private TextField mass2Field;
    //---------------------------------------

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

    //the instructions
    private Label instructions;

    private Button run;

    //output values
    private Label finalTemp;
    private Label objectImage;



    @Override
    public void start(Stage primaryStage) {
        //setting the title
        primaryStage.setTitle("Physics sim");

        //initializing the instructions
        instructions= new Label("to calculate the final temperature" +
                "\n please input your values then press run");
        instructions.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        //---------------------------


        //initializing the run button
        run = new Button("RUN");
        run.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        //---------------------------

        //making the main layout to contain all the components
        BorderPane root = new BorderPane();
        //------------------------------

        //intializing the layout holder for the object checkbox and label components
        objectVlayout = new VBox();
        object1Vlayout = new VBox();
        object2Vlayout = new VBox();
        //----------------------------

        //initializing the components of object 1 select
        object1Label = new Label("Choose your first object");
        wood1 = new CheckBox("wood");
        copper1 = new CheckBox("copper");
        gold1 = new CheckBox("gold");
        //----------------------------------------------

        //setting font size of object 1 components
        object1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        wood1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //-------------------

        //adding object 1 components to the VBox object 1 layout
        object1Vlayout.getChildren().addAll(object1Label,wood1,copper1,gold1);
        //--------------------


        //setting font size of object 2 components
        object2Label = new Label("Choose your second object");
        wood2 = new CheckBox("wood");
        copper2 = new CheckBox("copper");
        gold2 = new CheckBox("gold");
        //---------------------------------------


        //setting font size of object 2 components
        object2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        wood2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //-----------------------------------


        //adding object 2 components to the VBox object 2 layout
        object2Vlayout.getChildren().addAll(object2Label,wood2,copper2,gold2);
        //----------------------------------


        //adding both object 1 and object 2 layout holder to one big holder
        objectVlayout.getChildren().addAll(object1Vlayout,object2Vlayout);
        //------------------------


        //initializing the layout managers of the mass textfield and labels
        masterMass1 = new VBox();
        masterMass2 = new VBox();
        masterMass1Outer = new HBox();
        masterMass2Outer = new HBox();
        //-----------------------

        //intializing the one big mass components layout
        massVlayout =new VBox();
        //--------

        //intializing the actual components of the mass input for both objects
        mass1Label = new Label("Enter your mass for your first object");
        mass1Field = new TextField("Object1 mass");
        mass2Label = new Label("Enter your mass for your second object");
        mass2Field = new TextField("Object2 mass");
        //-------------------------------

        //setting the font size of the mass input components
        mass1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass1Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mass2Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //--------------------

        //finally adding the components of the mass input to the layout managers
        masterMass1.getChildren().addAll(mass1Label,mass1Field);
        masterMass2.getChildren().addAll(mass2Label,mass2Field);
        //---------------

        //prevents the textfield from taking the whole screen by using the HBox
        masterMass1Outer.getChildren().add(masterMass1);
        masterMass2Outer.getChildren().add(masterMass2);
        //---------------------

        //adding the 2 finall mass layout components to the one big mass components holder
        massVlayout.getChildren().addAll(masterMass1Outer,masterMass2Outer);
        //--------------------------------



        //initializing the layout managers of the temperature textfield and labels
        masterTemp1 = new VBox();
        masterTemp2 = new VBox();
        masterTemp1Outer = new HBox();
        masterTemp2Outer = new HBox();
        //------------------

        //intializing the one big temperature components layout
        tempVlayout =new VBox();
        //--------------------

        //intializing the actual components of the temperature input for both objects
        temp1Label = new Label("Enter the temperature for your first object");
        temp1Field = new TextField("Object1 temperature");
        temp2Label = new Label("Enter the temperature for your first object");
        temp2Field = new TextField("Object2 temperature");
        //-------------------------------

        //setting the font size of the temperature input components
        temp1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp1Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        temp2Field.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //------------------------


        //finally adding the components of the temperature input to the layout managers
        masterTemp1.getChildren().addAll(temp1Label,temp1Field);
        masterTemp2.getChildren().addAll(temp2Label,temp2Field);
        //------------------------

        //prevents the textfield from taking the whole screen by using the HBox
        masterTemp1Outer.getChildren().add(masterTemp1);
        masterTemp2Outer.getChildren().add(masterTemp2);
        //----------------------------

        //adding the 2 finall temperature layout components to the one big temperature components holder
        tempVlayout.getChildren().addAll(masterTemp1Outer,masterTemp2Outer);
        //-----------------------------

        //adding to root
        root.setTop(instructions);
        root.setLeft(objectVlayout);
        root.setCenter(massVlayout);
        root.setBottom(tempVlayout);
        root.setRight(run);




        primaryStage.setScene(new Scene(root, 1080, 600));
        primaryStage.show();

    }
}
