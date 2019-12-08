package physics.project;

import com.sun.scenario.effect.Merge;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Main extends Application{
    private setupVisuals visuals = new setupVisuals();
    private Calc calc = new Calc();
    private final int MERCURY = 1;
    private final int COPPER = 2;
    private final int GOLD =3;

    private final double MERCURY_SH = 128;
    private final double COPPER_SH = 138;
    private final double GOLD_SH =129;
    private int material1 = 0;
    private int material2 = 0;
    private double specificHeat1 = 0;
    private double specificHeat2 = 0;

    //input fields
    private double mass1 = 0;
    private double mass2 = 0;
    private double temperature1 =0;
    private double temperature2=0;

    //output fields
    private double finalMass = 0;
    private double energyLoss=0;
    private double finalTemp = 0;


    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //setting the title
        primaryStage.setTitle("Physics sim");

        //making the main layout to contain all the components
        BorderPane root = new BorderPane();
        //------------------------------

        visuals.setup(root);


        primaryStage.setScene(new Scene(root, 1080, 600));
        primaryStage.show();

        visuals.mercury1.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent actionEvent) {
                                             material1=MERCURY;
                                             visuals.material1=material1;
                                             if(visuals.copper1.isSelected())
                                             {
                                                 visuals.copper1.setSelected(false);
                                             }
                                             if(visuals.gold1.isSelected())
                                             {
                                                 visuals.gold1.setSelected(false);
                                             }
                                         }
                                     });

        visuals.copper1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                material1=COPPER;
                visuals.material1=material1;
                if(visuals.mercury1.isSelected())
                {
                    visuals.mercury1.setSelected(false);
                }
                if(visuals.gold1.isSelected())
                {
                    visuals.gold1.setSelected(false);
                }
            }
        });

        visuals.gold1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                material1=GOLD;
                visuals.material1=material1;
                if(visuals.copper1.isSelected())
                {
                    visuals.copper1.setSelected(false);
                }
                if(visuals.mercury1.isSelected())
                {
                    visuals.mercury1.setSelected(false);
                }
            }
        });

        //events of the material 2
        visuals.mercury2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                material2=MERCURY;
                visuals.material2=material2;
                if(visuals.copper2.isSelected())
                {
                    visuals.copper2.setSelected(false);
                }
                if(visuals.gold2.isSelected())
                {
                    visuals.gold2.setSelected(false);
                }
            }
        });

        visuals.copper2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                material2=COPPER;
                visuals.material2=material2;
                if(visuals.mercury2.isSelected())
                {
                    visuals.mercury2.setSelected(false);
                }
                if(visuals.gold2.isSelected())
                {
                    visuals.gold2.setSelected(false);
                }
            }
        });

        visuals.gold2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                material2=GOLD;
                visuals.material2=material2;
                if(visuals.copper2.isSelected())
                {
                    visuals.copper2.setSelected(false);
                }
                if(visuals.mercury2.isSelected())
                {
                    visuals.mercury2.setSelected(false);
                }
            }
        });


                visuals.run.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        if(material1== MERCURY)
                        {
                            specificHeat1=MERCURY_SH;
                            visuals.undefined1=false;
                        }
                        else if(material1== COPPER)
                        {
                            specificHeat1=COPPER_SH;
                            visuals.undefined1=false;
                        }
                        else if(material1== GOLD)
                        {
                            specificHeat1=GOLD_SH;
                            visuals.undefined1=false;
                        }

                        //material 2 specific heat determiner
                        if(material2== MERCURY)
                        {
                            specificHeat2=MERCURY_SH;
                            visuals.undefined2=false;
                        }
                        else if(material2== COPPER)
                        {
                            specificHeat2=COPPER_SH;
                            visuals.undefined2=false;
                        }
                        else if(material2== GOLD)
                        {
                            specificHeat2=GOLD_SH;
                            visuals.undefined2=false;
                        }

                        if(!visuals.mercury1.isSelected()&&!visuals.copper1.isSelected()&&!visuals.gold1.isSelected())
                        {
                            visuals.undefined1=true;
                            visuals.errorMessage.setText("Please check a box for object 1");
                        }

                        if(!visuals.mercury2.isSelected()&&!visuals.copper2.isSelected()&&!visuals.gold2.isSelected())
                        {
                            visuals.undefined2=true;
                            visuals.errorMessage.setText(visuals.errorMessage.getText() + "\nPlease check a box or object 2");
                        }


                        if(!visuals.undefined1&&!visuals.undefined2)
                        {
                            visuals.errorMessage.setText("");
                            if(!visuals.mass1Field.getText().equals("Object1 mass")) {
                                mass1 = Double.parseDouble(visuals.mass1Field.getText());
                            }
                            else
                            {
                                visuals.errorMessage.setText(visuals.errorMessage.getText()+"Please type in a number for mass 1");
                            }
                            if(!visuals.mass2Field.getText().equals("Object2 mass")) {
                                mass2 = Double.parseDouble(visuals.mass2Field.getText());
                            }
                            else
                            {
                                visuals.errorMessage.setText(visuals.errorMessage.getText()+"Please type in a number for mass 2");
                            }

                            if(!visuals.mass1Field.getText().equals("Object1 temperature")) {
                                temperature1 = Double.parseDouble(visuals.temp1Field.getText());
                            }
                            else
                            {
                                visuals.errorMessage.setText(visuals.errorMessage.getText()+"Please type in a number for temperature 1");
                            }
                            if(!visuals.mass1Field.getText().equals("Object2 temperature")) {
                                temperature2 = Double.parseDouble(visuals.temp2Field.getText());
                            }
                            else
                            {
                                visuals.errorMessage.setText(visuals.errorMessage.getText()+"Please type in a number for temperature 2");
                            }

                            visuals.finalTemp.setText("Final Temperature: "+String.valueOf(Calc.calculateFinalTemperature(mass1,mass2,specificHeat1,specificHeat2,temperature1,temperature2)));
                            visuals.finalMass.setText("Final Mass: "+String.valueOf(Calc.calculateFinalMass(mass1,mass2)));
                            visuals.energyLoss.setText("Change in temperature: "+String.valueOf(Calc.calculateEnergyLoss(temperature1,temperature2)));
                            try {
                                visuals.update();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }



                    }
                });

    }
}
