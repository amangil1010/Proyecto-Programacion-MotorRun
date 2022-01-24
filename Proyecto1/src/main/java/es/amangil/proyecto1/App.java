package es.amangil.proyecto1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {

    //Variables

    int ventanaX = 1100;
    
    int desiertoX = 0;
    
    int desiertoX2 = 1365; //1365

    int lineaXmax = 1450;    
    
    int lineaX = 1450;    

    int movLinea = 0;
    
    int grupoMotoX = 20;
    
    int grupoMotoY = 420;
    
    int velocidad = 5 ;
    
    Image desierto = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView = new ImageView(desierto);

    Image desierto2 = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView2 = new ImageView(desierto2);
    
    Group grupoLinea1 = new Group();

    Group grupoMoto = new Group();

    
    @Override
    public void start(Stage stage) {
        
        //Ventana
        Pane root = new Pane();
        Scene Ventana = new Scene(root, 1100, 600);
        stage.setTitle("MotorRun");
        stage.setScene(Ventana);
        stage.show();
        
        
        //RECTANGULO
        Rectangle Carretera = new Rectangle();
        Carretera.setWidth(1350);
        Carretera.setHeight(400);
        Carretera.setFill(Color.BLACK);
        Carretera.setY(300);
        root.getChildren().add(Carretera);
        
        

        
        
        //Linea carretera superior
        for (int i=0; i< lineaXmax; i+=30) {
            Line lineaCarretera = new Line(i,325,i+10,325);
            lineaCarretera.setStroke(Color.WHITE);
            lineaCarretera.setStrokeWidth(12);
            //root.getChildren().add(lineaCarretera);
            grupoLinea1.getChildren().add(lineaCarretera);
        }
        
        
        //Linea carretera inferior
        for (int i=0; i< lineaXmax; i+=30) {
            Line lineaCarretera2 = new Line(i,575,i+10,575);
            lineaCarretera2.setStroke(Color.WHITE);
            lineaCarretera2.setStrokeWidth(12);
            //root.getChildren().add(lineaCarretera2);
            grupoLinea1.getChildren().add(lineaCarretera2);
        }
                
        
        
        //Moto
        Circle rueda1 = new Circle();
        rueda1.setRadius(12); 
        rueda1.setCenterX(15);
        rueda1.setCenterY(40);
        rueda1.setFill(Color.GRAY);
        //root.getChildren().add(rueda1);
        grupoMoto.getChildren().add(rueda1);
        
        Circle rueda2 = new Circle();
        rueda2.setRadius(12); 
        rueda2.setCenterX(70);
        rueda2.setCenterY(40);
        rueda2.setFill(Color.GRAY);
        //root.getChildren().add(rueda2);
        grupoMoto.getChildren().add(rueda2);

        
        Line soporteDeRueda1 = new Line(20, 20, 15, 40);
        soporteDeRueda1.setStroke(Color.GREEN);
        soporteDeRueda1.setStrokeWidth(4);
        //root.getChildren().add(soporteDeRueda1);
        grupoMoto.getChildren().add(soporteDeRueda1);

        
        
        Line soporteDeRueda2 = new Line();
        soporteDeRueda2.setStartX(70);
        soporteDeRueda2.setEndX(60);
        soporteDeRueda2.setStartY(40);
        soporteDeRueda2.setEndY(20);
        soporteDeRueda2.setStroke(Color.GREEN);
        soporteDeRueda2.setStrokeWidth(4);
        //root.getChildren().add(soporteDeRueda2);
        grupoMoto.getChildren().add(soporteDeRueda2);

        
        
        Line hierroSilla = new Line();
        hierroSilla.setStartX(23);
        hierroSilla.setEndX(59);
        hierroSilla.setStartY(20);
        hierroSilla.setEndY(20);
        hierroSilla.setStroke(Color.GREEN);
        hierroSilla.setStrokeWidth(10);
        //root.getChildren().add(hierroSilla);
        grupoMoto.getChildren().add(hierroSilla);

        
        
        Line soporteManillar = new Line();
        soporteManillar.setStartX(61);
        soporteManillar.setEndX(61);
        soporteManillar.setStartY(20);
        soporteManillar.setEndY(0);
        soporteManillar.setStroke(Color.GREEN);
        soporteManillar.setStrokeWidth(5);
        //root.getChildren().add(soporteManillar);
        grupoMoto.getChildren().add(soporteManillar);

        
        Line manillar = new Line();
        manillar.setStartX(50);
        manillar.setEndX(61);
        manillar.setStartY(-10);
        manillar.setEndY(0);
        manillar.setStroke(Color.WHITE);
        manillar.setStrokeWidth(5);
        //root.getChildren().add(manillar);
        grupoMoto.getChildren().add(manillar);

        
        
        Line reposaSilla = new Line();
        reposaSilla.setStartX(21);
        reposaSilla.setEndX(19);
        reposaSilla.setStartY(15);
        reposaSilla.setEndY(0);
        reposaSilla.setStroke(Color.BROWN);
        reposaSilla.setStrokeWidth(5);
        //root.getChildren().add(reposaSilla);
        grupoMoto.getChildren().add(reposaSilla);

        
        Line Silla = new Line();
        Silla.setStartX(23);
        Silla.setEndX(56);
        Silla.setStartY(15);
        Silla.setEndY(15);
        Silla.setStroke(Color.BROWN);
        Silla.setStrokeWidth(4);
        //root.getChildren().add(Silla);
        grupoMoto.getChildren().add(Silla);

        
        root.getChildren().add(grupoMoto);

        grupoMoto.setLayoutX(grupoMotoX);
        grupoMoto.setLayoutY(grupoMotoY);
        

        
        
        
             
        //Imagen1
        root.getChildren().add(desiertoView);
        
        //Imagen2
        desiertoView2.setX(1250);
        root.getChildren().add(desiertoView2);

        
        
        //Movimiento de la imagen Y lineas
        Timeline animationDesierto = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //System.out.println(desiertoX);
                desiertoView.setX(desiertoX);
                desiertoX -= 3;
                
                //System.out.println(desiertoX2);
                desiertoView2.setX(desiertoX2);
                desiertoX2 -= 3;
                
                if (desiertoX < -1377) {
                desiertoX = 1350;
                }
                
                if (desiertoX2 < -1377) {
                desiertoX2 = 1350;
                }
                
                grupoLinea1.setLayoutX(movLinea -= 5);
                //System.out.println(movLinea);
                
                if (movLinea < -385) {
                movLinea = 0;
                }

                if (grupoMotoY > 525){
                velocidad = +5;
                }

                if (grupoMotoY < 310){
                    velocidad = -5;
                }

                })
        );
        animationDesierto.setCycleCount(Timeline.INDEFINITE);
        animationDesierto.play();
        
        root.getChildren().add(grupoLinea1);

       //Controles de la moto 
        Ventana.setOnKeyPressed((KeyEvent event) -> {
            if(event.getCode() == KeyCode.RIGHT) {
                grupoMotoX += velocidad;
                grupoMoto.setLayoutX(grupoMotoX);
            } else if(event.getCode() == KeyCode.LEFT) {
                grupoMotoX -= velocidad;
                grupoMoto.setLayoutX(grupoMotoX);
            } else if(event.getCode() == KeyCode.UP) {
                grupoMotoY -= velocidad;
                grupoMoto.setLayoutY(grupoMotoY);
            } else if(event.getCode() == KeyCode.DOWN) {
                grupoMotoY += velocidad;
                grupoMoto.setLayoutY(grupoMotoY);
            }
            
            System.out.println(grupoMotoY);

        });
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}