package physics.project;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class setupVisuals {

    private final int MERCURY = 1;
    private final int COPPER = 2;
    private final int GOLD =3;

    //all the object Vbox layouts are here

    //VBoxes that encapsulate the components
    private VBox objectVlayout;
    private VBox object2Vlayout;
    private VBox object1Vlayout;
    //encanpsulation


    //the object choosers
    private Label object1Label;
    public CheckBox mercury1;
    public CheckBox copper1;
    public CheckBox gold1;

    private Label object2Label;
    public CheckBox mercury2;
    public CheckBox copper2;
    public CheckBox gold2;
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
    public TextField mass1Field;


    private Label mass2Label;
    public TextField mass2Field;
    //---------------------------------------

    //temperature layouts
    private HBox masterTemp1Outer;
    private HBox masterTemp2Outer;
    private VBox masterTemp1;
    private VBox tempVlayout;
    private Label temp1Label;
    public TextField temp1Field;

    private VBox masterTemp2;
    private Label temp2Label;
    public TextField temp2Field;

    //the instructions
    public Label instructions;

    public Button run;

    //output values
    public Label finalTemp;
    public Label energyLoss;
    public Label finalMass;


    private VBox outputs;
    public Label errorMessage;


    public boolean undefined1;
    public boolean undefined2;

    private VBox center;

    //images
    private Image materialImage1;
    private ImageView materialView1;
    private Image materialImage2;
    private ImageView materialView2;
    private HBox materialImages;
    public int material1;
    public int material2;

    private Label object1Image;
    private Label object2Image;



    public void setup(BorderPane root) throws FileNotFoundException {
        //initializing the instructions
        instructions= new Label("to calculate the final temperature" +
                "\n please input your values then press run");
        instructions.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        //---------------------------


        //initializing the run button
        run = new Button("RUN");
        run.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        //---------------------------



        //intializing the layout holder for the object checkbox and label components
        objectVlayout = new VBox();
        object1Vlayout = new VBox();
        object2Vlayout = new VBox();
        //----------------------------

        //initializing the components of object 1 select
        object1Label = new Label("Choose your first object");
        mercury1 = new CheckBox("mercury");
        copper1 = new CheckBox("copper");
        gold1 = new CheckBox("gold");
        //----------------------------------------------

        //setting font size of object 1 components
        object1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mercury1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //-------------------

        //adding object 1 components to the VBox object 1 layout
        object1Vlayout.getChildren().addAll(object1Label,mercury1,copper1,gold1);
        //--------------------


        //setting font size of object 2 components
        object2Label = new Label("Choose your second object");
        mercury2 = new CheckBox("mercury");
        copper2 = new CheckBox("copper");
        gold2 = new CheckBox("gold");
        //---------------------------------------


        //setting font size of object 2 components
        object2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        mercury2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        copper2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gold2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //-----------------------------------


        //adding object 2 components to the VBox object 2 layout
        object2Vlayout.getChildren().addAll(object2Label,mercury2,copper2,gold2);
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
        mass1Label = new Label("Enter your mass for your first object(kg)");
        mass1Field = new TextField("");
        mass2Label = new Label("Enter your mass for your second object(kg)");
        mass2Field = new TextField("");
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
        temp1Label = new Label("Enter the initial temperature for your first object(Celsius)");
        temp1Field = new TextField("");
        temp2Label = new Label("Enter the initial temperature for your second object(Celsius)");
        temp2Field = new TextField("");
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

        outputs = new VBox();
        errorMessage = new Label();
        object1Image = new Label();
        object2Image = new Label();
        finalMass = new Label("");
        energyLoss = new Label("");
        finalTemp = new Label("");

        finalMass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        energyLoss.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        finalTemp.setFont(Font.font("Arial", FontWeight.BOLD, 20));



        errorMessage.setFont(Font.font("Arial",FontWeight.BOLD, 10));


        center = new VBox();

        materialImages = new HBox();
        materialImages.getChildren().addAll(object1Image,object2Image);
        
        center.getChildren().addAll(massVlayout,materialImages);

        outputs.getChildren().addAll(run,finalTemp,energyLoss,finalMass,errorMessage);




        //adding to root
        root.setTop(instructions);
        root.setLeft(objectVlayout);
        root.setCenter(center);
        root.setBottom(tempVlayout);
        root.setRight(outputs);


    }

    public void update() throws FileNotFoundException {




        if(material1==MERCURY)
        {
            materialImage1 = new Image(new FileInputStream(getClass().getClassLoader().getResource("mercury.png").getFile()));
        }
        if(material1==COPPER)
        {
            materialImage1 = new Image(new FileInputStream(getClass().getClassLoader().getResource("copper.png").getFile()));
        }
        if(material1==GOLD)
        {
            materialImage1 = new Image(new FileInputStream(getClass().getClassLoader().getResource("gold.png").getFile()));
        }

        //material 2
        if(material2==MERCURY)
        {
            materialImage2 = new Image(new FileInputStream(getClass().getClassLoader().getResource("mercury.png").getFile()));
        }
        if(material2==COPPER)
        {
            materialImage2 = new Image(new FileInputStream(getClass().getClassLoader().getResource("copper.png").getFile()));
        }
        if(material2==GOLD)
        {
            materialImage2 = new Image(new FileInputStream(getClass().getClassLoader().getResource("gold.png").getFile()));
        }

        //Setting the image view
        materialView1 = new ImageView(materialImage1);
        materialView2 = new ImageView(materialImage2);

        materialView1.setFitWidth(300);
        materialView1.setFitHeight(250);

        object1Image.setGraphic(materialView1);

        materialView2.setFitWidth(300);
        materialView2.setFitHeight(250);

        object2Image.setGraphic(materialView2);

    }
}
