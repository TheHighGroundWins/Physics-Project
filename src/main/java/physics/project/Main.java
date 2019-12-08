package physics.project;

import com.sun.scenario.effect.Merge;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


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



    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) {
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
                        }
                        else if(material1== COPPER)
                        {
                            specificHeat1=COPPER_SH;
                        }
                        else if(material1== GOLD)
                        {
                            specificHeat1=GOLD;
                        }
                        else
                        {
                            visuals.instructions.setText("Please check a box for object 1");
                        }

                        //material 2 specific heat determiner
                        if(material2== MERCURY)
                        {
                            specificHeat2=MERCURY_SH;
                        }
                        else if(material2== COPPER)
                        {
                            specificHeat2=COPPER_SH;
                        }
                        else if(material2== GOLD)
                        {
                            specificHeat2=GOLD;
                        }
                        else
                        {
                            visuals.instructions.setText(visuals.instructions.getText()+"\nplease check a box or object 2");
                        }

                    }
                });

    }
}
