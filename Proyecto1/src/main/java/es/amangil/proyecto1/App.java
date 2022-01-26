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
import javafx.scene.shape.Shape;
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
    
    int giro = 0;
    int giro2 = 0;
    
    int movRocaX = 1500;
    int movCactusX = 2000;

    
    Image desierto = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView = new ImageView(desierto);

    Image desierto2 = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView2 = new ImageView(desierto2);
    
    Image roca = new Image(getClass().getResourceAsStream("/images/roca.png"));
    ImageView rocaView = new ImageView(roca);

    Image cactus = new Image(getClass().getResourceAsStream("/images/cactus.png"));
    ImageView cactusView=  new ImageView(cactus);
    
    Group grupoLinea1 = new Group();

    Group grupoMoto = new Group();
    
    Group grupoRoca = new Group();
    
    Group grupoCactus = new Group();

    
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
        //Marco de la moto
        Rectangle marco = new Rectangle();
        marco.setWidth(80);
        marco.setHeight(40);
        marco.setFill(Color.RED);
        marco.setVisible(false);
        grupoMoto.getChildren().add(marco);

        
        //Rueda
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
        soporteDeRueda1.setStroke(Color.RED);
        soporteDeRueda1.setStrokeWidth(4);
        //root.getChildren().add(soporteDeRueda1);
        grupoMoto.getChildren().add(soporteDeRueda1);

        
        Line soporteDeRueda2 = new Line();
        soporteDeRueda2.setStartX(70);
        soporteDeRueda2.setEndX(60);
        soporteDeRueda2.setStartY(40);
        soporteDeRueda2.setEndY(20);
        soporteDeRueda2.setStroke(Color.RED);
        soporteDeRueda2.setStrokeWidth(4);
        //root.getChildren().add(soporteDeRueda2);
        grupoMoto.getChildren().add(soporteDeRueda2);

        
        Line hierroSilla = new Line();
        hierroSilla.setStartX(23);
        hierroSilla.setEndX(59);
        hierroSilla.setStartY(20);
        hierroSilla.setEndY(20);
        hierroSilla.setStroke(Color.RED);
        hierroSilla.setStrokeWidth(10);
        //root.getChildren().add(hierroSilla);
        grupoMoto.getChildren().add(hierroSilla);

        
        Line soporteManillar = new Line();
        soporteManillar.setStartX(61);
        soporteManillar.setEndX(61);
        soporteManillar.setStartY(20);
        soporteManillar.setEndY(0);
        soporteManillar.setStroke(Color.RED);
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

        //ROCA-----------------
        Rectangle marcoRoca = new Rectangle();
        marcoRoca.setWidth(30);
        marcoRoca.setHeight(30);
        marcoRoca.setFill(Color.RED);
        marcoRoca.setVisible(false);
        grupoRoca.getChildren().add(marcoRoca);
        grupoRoca.getChildren().add(rocaView);
        grupoRoca.setLayoutX(1500);
        grupoRoca.setLayoutY(425);

        
        
        
        //CACTUS----------------------------------
        Rectangle marcoCactus = new Rectangle();
        marcoCactus.setWidth(30);
        marcoCactus.setHeight(30);
        marcoCactus.setFill(Color.RED);
        marcoCactus.setVisible(false);
        grupoCactus.getChildren().add(marcoCactus);
        grupoCactus.getChildren().add(cactusView);
        grupoCactus.setLayoutX(2000);
        grupoCactus.setLayoutY(450);
        
        
        //Movimiento de la imagen Y lineas
        Timeline animationDesierto = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
               
                //Fondo----------------------
                desiertoView.setX(desiertoX);
                desiertoX -= 3;
                
                desiertoView2.setX(desiertoX2);
                desiertoX2 -= 3;
                
               
                if (desiertoX < -1377) {
                desiertoX = 1350;
                }
                
                if (desiertoX2 < -1377) {
                desiertoX2 = 1350;
                }
                
                movLinea -= 5;
                grupoLinea1.setLayoutX(movLinea);
                
                if (movLinea < -385) {
                movLinea = 0;
                }

                
                //IF para que la moto no se salga por pantalla-----------------
                if (grupoMotoY >= 525){
                    grupoMotoY -= 5;
                    grupoMoto.setLayoutY(grupoMotoY);
                }

                if (grupoMotoY < 310){
                    grupoMotoY += 5;
                    grupoMoto.setLayoutY(grupoMotoY);
                }

                if (grupoMotoX <= 5){
                    grupoMotoX += 5;
                    grupoMoto.setLayoutX(grupoMotoX);
                }
                
                if (grupoMotoX >= 1015){
                    grupoMotoX -= 5;
                    grupoMoto.setLayoutX(grupoMotoX);
                }
                
                //OBSTACULOS-----------------------------------
                //giro
                giro -= 5;
                rocaView.setRotate(giro);
                
                giro2 -= 5;
                cactusView.setRotate(giro2);
                
                movRocaX -= 5;
                grupoRoca.setLayoutX(movRocaX);
                
                movCactusX -= 5;
                grupoCactus.setLayoutX(movCactusX);
                
                System.out.println("movCactusx" + movCactusX);
                System.out.println("Y" + grupoCactus.getLayoutY());
                System.out.println("X" + grupoCactus.getLayoutX());

                
                //COLISION Roca y moto------------------------------------
                Shape.intersect(marco, marcoRoca);

                Shape Colision = Shape.intersect(marco, marcoRoca);

                boolean colisionVacia = Colision.getBoundsInLocal().isEmpty();
                
                if (colisionVacia == false) {
                   grupoMotoY = 420;
                   grupoMoto.setLayoutY(grupoMotoY);
                   grupoMotoX = 20;
                   grupoMoto.setLayoutX(grupoMotoX);
                   movRocaX = 1500;
                   grupoRoca.setLayoutX(movRocaX);
                };
                
                if (movRocaX == 0) {
                   grupoRoca.setLayoutX(movRocaX = 1500);

                };
                //COLISION Cactus y moto------------------------------------
                Shape.intersect(marco, marcoCactus);

                Shape Colision2 = Shape.intersect(marco, marcoCactus);

                boolean colisionVacia2 = Colision2.getBoundsInLocal().isEmpty();
                
                if (colisionVacia2 == false) {
                   grupoMotoY = 420;
                   grupoMoto.setLayoutY(grupoMotoY);
                   grupoMotoX = 20;
                   grupoMoto.setLayoutX(grupoMotoX);
                   movCactusX = 2000;
                   grupoCactus.setLayoutX(movCactusX);
                };
                
                if (movCactusX == 0) {
                   grupoCactus.setLayoutX(movCactusX = 2000);

                };
                
                
                
                
                
                
                
                
                })
        );
        animationDesierto.setCycleCount(Timeline.INDEFINITE);
        animationDesierto.play();
        
        root.getChildren().add(grupoLinea1);
        root.getChildren().add(grupoRoca);
        root.getChildren().add(grupoCactus);

        

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
            } else if(event.getCode() == KeyCode.Q) {
                grupoMoto.setRotate(-50);                
            } else if(event.getCode() == KeyCode.W) {
                grupoMoto.setRotate(0);
            }
            
            //System.out.println(grupoMotoX);


        });
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}