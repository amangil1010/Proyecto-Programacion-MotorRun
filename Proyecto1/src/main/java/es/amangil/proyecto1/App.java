package es.amangil.proyecto1;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {

    //AMG-VARIABLES
    int ventanaX = 1100;
    int desiertoX = 0;
    int desiertoX2 = 1365; 
    int lineaXmax = 1450;    
    int lineaX = 1450;    
    int movLinea = 0;
    int grupoMotoX = 20;
    int grupoMotoY = 420;
    int velocidad = 10 ;
    
    int giro = 0;
    int giro2 = 0;
    int giro3 = 0;
    int giro4 = 0;

    int movRocaX = 1500;
    int movCactusX = 2000;
    int movRoca2Y = 40;
    int movCactusY = 40;
    int muroX = 5000;
            
    int puntuacion = 0;
    
    final int TEXT_SIZE = 20;
    
    //AMG-IMAGENES
    Image desierto = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView = new ImageView(desierto);

    Image desierto2 = new Image(getClass().getResourceAsStream("/images/Desierto.jpg"));
    ImageView desiertoView2 = new ImageView(desierto2);
    
    Image roca = new Image(getClass().getResourceAsStream("/images/roca.png"));
    ImageView rocaView = new ImageView(roca);
    
    Image roca2Y = new Image(getClass().getResourceAsStream("/images/roca2.png"));
    ImageView rocaView2Y = new ImageView(roca2Y);

    Image cactus = new Image(getClass().getResourceAsStream("/images/cactus.png"));
    ImageView cactusView=  new ImageView(cactus);
        
    Image cactus2 = new Image(getClass().getResourceAsStream("/images/cactus.png"));
    ImageView cactusView2=  new ImageView(cactus2);
    
    //AMG-GRUPOS
    Group grupoLinea1 = new Group();
    Group grupoMoto = new Group();
    Group grupoRoca = new Group();
    Group grupoRoca2Y = new Group();
    Group grupoCactus = new Group();
    Group grupoCactus2 = new Group();
    
    //AMG-RANDOM
    Random random = new Random();
    
    Rectangle muro = new Rectangle();

    
    @Override
    public void start(Stage stage) {
        
        //AMG-VENTANA
        Pane root = new Pane();
        Scene Ventana = new Scene(root, 1100, 600);
        stage.setTitle("MotorRun");
        stage.setScene(Ventana);
        stage.show();
        
        //AMG-RECTANGULO
        Rectangle Carretera = new Rectangle();
        Carretera.setWidth(1350);
        Carretera.setHeight(400);
        Carretera.setFill(Color.BLACK);
        Carretera.setY(300);
        root.getChildren().add(Carretera);
        
        
        //AMG-LINEA CARRETERA SUPERIOR
        for (int i=0; i< lineaXmax; i+=30) {
            Line lineaCarretera = new Line(i,325,i+10,325);
            lineaCarretera.setStroke(Color.WHITE);
            lineaCarretera.setStrokeWidth(12);
            grupoLinea1.getChildren().add(lineaCarretera);
        }
        
        
        //AMG-LINEA CARRETERA INFERIOR 
        for (int i=0; i< lineaXmax; i+=30) {
            Line lineaCarretera2 = new Line(i,575,i+10,575);
            lineaCarretera2.setStroke(Color.WHITE);
            lineaCarretera2.setStrokeWidth(12);
            grupoLinea1.getChildren().add(lineaCarretera2);
        }       
        
        
        /////AMG-MOTO
        //AMG-MARCO DE LA MOTO
        Rectangle marco = new Rectangle();
        marco.setWidth(80);
        marco.setHeight(40);
        marco.setFill(Color.RED);
        marco.setVisible(false);
        grupoMoto.getChildren().add(marco);

        
        //AMG-RUEDA
        Circle rueda1 = new Circle();
        rueda1.setRadius(12); 
        rueda1.setCenterX(15);
        rueda1.setCenterY(40);
        rueda1.setFill(Color.GRAY);
        grupoMoto.getChildren().add(rueda1);
        
        //AMG-RUEDA
        Circle rueda2 = new Circle();
        rueda2.setRadius(12); 
        rueda2.setCenterX(70);
        rueda2.setCenterY(40);
        rueda2.setFill(Color.GRAY);
        grupoMoto.getChildren().add(rueda2);

        
        //AMG-SOPORTE DE RUEDA1
        Line soporteDeRueda1 = new Line(20, 20, 15, 40);
        soporteDeRueda1.setStroke(Color.RED);
        soporteDeRueda1.setStrokeWidth(4);
        grupoMoto.getChildren().add(soporteDeRueda1);

        
        //AMG-SOPORTE DE RUEDA2
        Line soporteDeRueda2 = new Line();
        soporteDeRueda2.setStartX(70);
        soporteDeRueda2.setEndX(60);
        soporteDeRueda2.setStartY(40);
        soporteDeRueda2.setEndY(20);
        soporteDeRueda2.setStroke(Color.RED);
        soporteDeRueda2.setStrokeWidth(4);
        grupoMoto.getChildren().add(soporteDeRueda2);

        
        //AMG-HIERO DE SILLA
        Line hierroSilla = new Line();
        hierroSilla.setStartX(23);
        hierroSilla.setEndX(59);
        hierroSilla.setStartY(20);
        hierroSilla.setEndY(20);
        hierroSilla.setStroke(Color.RED);
        hierroSilla.setStrokeWidth(10);
        grupoMoto.getChildren().add(hierroSilla);

        
        //AMG-SOPORTE DE MANILLAR
        Line soporteManillar = new Line();
        soporteManillar.setStartX(61);
        soporteManillar.setEndX(61);
        soporteManillar.setStartY(20);
        soporteManillar.setEndY(0);
        soporteManillar.setStroke(Color.RED);
        soporteManillar.setStrokeWidth(5);
        grupoMoto.getChildren().add(soporteManillar);

        
        //AMG-MANILLAR
        Line manillar = new Line();
        manillar.setStartX(50);
        manillar.setEndX(61);
        manillar.setStartY(-10);
        manillar.setEndY(0);
        manillar.setStroke(Color.WHITE);
        manillar.setStrokeWidth(5);
        grupoMoto.getChildren().add(manillar);

        
        //AMG-REPOSASILLA
        Line reposaSilla = new Line();
        reposaSilla.setStartX(21);
        reposaSilla.setEndX(19);
        reposaSilla.setStartY(15);
        reposaSilla.setEndY(0);
        reposaSilla.setStroke(Color.BROWN);
        reposaSilla.setStrokeWidth(5);
        grupoMoto.getChildren().add(reposaSilla);

        
        //AMG-SILLA
        Line Silla = new Line();
        Silla.setStartX(23);
        Silla.setEndX(56);
        Silla.setStartY(15);
        Silla.setEndY(15);
        Silla.setStroke(Color.BROWN);
        Silla.setStrokeWidth(4);
        grupoMoto.getChildren().add(Silla);

        
        //AMG-AÑADIR GRUPO 
        root.getChildren().add(grupoMoto);
        grupoMoto.setLayoutX(grupoMotoX);
        grupoMoto.setLayoutY(grupoMotoY);
        
             
        //AMG-IMAGEN 1
        root.getChildren().add(desiertoView);
        
        //AMG-IMAGEN 2
        desiertoView2.setX(1250);
        root.getChildren().add(desiertoView2);

        //AMG-ROCA-----------------
        Rectangle marcoRoca = new Rectangle();
        marcoRoca.setWidth(30);
        marcoRoca.setHeight(30);
        marcoRoca.setFill(Color.RED);
        marcoRoca.setVisible(false);
        grupoRoca.getChildren().add(marcoRoca);
        grupoRoca.getChildren().add(rocaView);
        grupoRoca.setLayoutX(1500);
        grupoRoca.setLayoutY(425);
        
        
        //AMG-ROCA2------------------
        Rectangle marcoRoca2Y = new Rectangle();
        marcoRoca2Y.setWidth(30);
        marcoRoca2Y.setHeight(30);
        marcoRoca2Y.setFill(Color.RED);
        marcoRoca2Y.setVisible(false);
        grupoRoca2Y.getChildren().add(marcoRoca2Y);
        grupoRoca2Y.getChildren().add(rocaView2Y);
        grupoRoca2Y.setLayoutX(30);
        grupoRoca2Y.setLayoutY(50);
        
        
        //AMG-CACTUS----------------------------------
        Rectangle marcoCactus = new Rectangle();
        marcoCactus.setWidth(40);
        marcoCactus.setHeight(40);
        marcoCactus.setFill(Color.RED);
        marcoCactus.setVisible(false);
        grupoCactus.getChildren().add(marcoCactus);
        grupoCactus.getChildren().add(cactusView);
        grupoCactus.setLayoutX(2000);
        grupoCactus.setLayoutY(450);
                
        
        //AMG-CACTUS----------------------------------
        Rectangle marcoCactus2 = new Rectangle();
        marcoCactus2.setWidth(40);
        marcoCactus2.setHeight(40);
        marcoCactus2.setFill(Color.RED);
        marcoCactus2.setVisible(false);
        grupoCactus2.getChildren().add(marcoCactus2);
        grupoCactus2.getChildren().add(cactusView2);
        grupoCactus2.setLayoutX(500);
        grupoCactus2.setLayoutY(50);
        
        
        //AMG-muro----------------------------------
        muro.setX(muroX);
        muro.setY(315);
        muro.setWidth(40);
        muro.setHeight(275);
        muro.setFill(Color.BROWN);

        
        //Puntuaciones
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(1100);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        root.getChildren().add(paneScores);
        //Puntuacion Actual       
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);
        //Etiqueta Puntuacion       
        Text textTitleScore = new Text ("Puntuacion:");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);
        //Sobre Puntuacion       
        Text textScore = new Text ("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        //Añadir los textos a los layouts
        paneCurrentScore.getChildren().add(textTitleScore);
        paneCurrentScore.getChildren().add(textScore);
                
        
        //AMG-MOVIMIENTO DE LA IMAGEN, LINEAS,OBSTACULOS Y MOTO
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

                
                //AMG-IF PARA QUE LA MOTO NO SE SALGA POR PANTALLA
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
                
                /////////AMG-OBSTACULOS
                //AMG-GIRO
                giro -= 5;
                rocaView.setRotate(giro);
                
                giro2 -= 5;
                cactusView.setRotate(giro2);
                
                giro3 -= 5;
                rocaView2Y.setRotate(giro);
                
                giro4 -= 5;
                cactusView2.setRotate(giro4);
                
                //Movimiento
                movRocaX -= 5;
                grupoRoca.setLayoutX(movRocaX);
                
                movRoca2Y += 5;
                grupoRoca2Y.setLayoutY(movRoca2Y);
                
                movCactusX -= 5;
                grupoCactus.setLayoutX(movCactusX);
                
                movCactusY += 5;
                grupoCactus2.setLayoutY(movCactusY);
                
                muroX -= 5;
                muro.setX(muroX);
                //System.out.println("movCactusx" + movCactusX);
                //System.out.println("Y" + grupoCactus.getLayoutY());
                //System.out.println("X" + grupoCactus.getLayoutX());

                
                //COLISION ROCA Y MOTO -----------------------------------
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
                    movCactusX = 2000;
                    grupoCactus.setLayoutX(movCactusX);
                    movCactusY = 40;
                    grupoCactus2.setLayoutY(movCactusY);
                    movRoca2Y = 40;
                    grupoRoca2Y.setLayoutX(movRoca2Y);
                    puntuacion = 0;
                    muroX = 5000;
                    muro.setX(muroX);
                };
                
                if (movRocaX == 0) {
                    int valor = random.nextInt(300);
                    grupoRoca.setLayoutX(movRocaX = 1500);
                    grupoRoca.setLayoutY(300 + valor);
                    puntuacion++;
                    textScore.setText(String.valueOf(puntuacion));

                };
                //AMG-COLISION CACTUS Y MOTO
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
                    movCactusY = 40;
                    grupoCactus2.setLayoutY(movCactusY);
                    movRoca2Y = 40;
                    grupoRoca2Y.setLayoutX(movRoca2Y);
                    movRocaX = 1500;
                    grupoRoca.setLayoutX(movRocaX);
                    puntuacion = 0;
                    muroX = 5000;
                    muro.setX(muroX);
                };
                
                if (movCactusX == 0) {
                    int valor = random.nextInt(300);
                    grupoCactus.setLayoutX(movCactusX = 2000);
                    grupoCactus.setLayoutY(300 + valor);
                    puntuacion++;
                    textScore.setText(String.valueOf(puntuacion));
                };
                
                
                //AMG-MARCO ROCA Y
                Shape.intersect(marco, marcoRoca2Y);
                Shape Colision3 = Shape.intersect(marco, marcoRoca2Y);
                boolean colisionVacia3 = Colision3.getBoundsInLocal().isEmpty();
                
                if (colisionVacia3 == false) {
                    grupoMotoY = 420;
                    grupoMoto.setLayoutY(grupoMotoY);
                    grupoMotoX = 20;
                    grupoMoto.setLayoutX(grupoMotoX);
                    movRoca2Y = 40;
                    grupoRoca2Y.setLayoutX(movRoca2Y);
                    movRocaX = 1500;
                    grupoRoca.setLayoutX(movRocaX);
                    movCactusX = 2000;
                    grupoCactus.setLayoutX(movCactusX);
                    movCactusY = 40;
                    grupoCactus2.setLayoutY(movCactusY);
                    puntuacion = 0;
                    muroX = 5000;
                    muro.setX(muroX);
                }
                
                if (movRoca2Y == 600) {
                    int valor = random.nextInt(1100);
                    grupoRoca2Y.setLayoutX(valor);
                    grupoRoca2Y.setLayoutY(movRoca2Y = 40);
                    puntuacion++;
                    textScore.setText(String.valueOf(puntuacion));
                };
                
                
               //AMG-MARCO cactus Y Moto
                Shape.intersect(marco, marcoCactus2);
                Shape Colision4 = Shape.intersect(marco, marcoCactus2);
                boolean colisionVacia4 = Colision4.getBoundsInLocal().isEmpty();
                
                if (colisionVacia4 == false) {
                    grupoMotoY = 420;
                    grupoMoto.setLayoutY(grupoMotoY);
                    grupoMotoX = 20;
                    grupoMoto.setLayoutX(grupoMotoX);
                    movCactusY = 40;
                    grupoCactus2.setLayoutY(movCactusY);
                    movRoca2Y = 40;
                    grupoRoca2Y.setLayoutX(movRoca2Y);
                    movRocaX = 1500;
                    grupoRoca.setLayoutX(movRocaX);
                    movCactusX = 2000;
                    grupoCactus.setLayoutX(movCactusX);
                    puntuacion = 0;
                    muroX = 5000;
                    muro.setX(muroX);
                }
                
                if (movCactusY == 600) {
                    int valor = random.nextInt(1100);
                    grupoCactus2.setLayoutX(valor);
                    grupoCactus2.setLayoutY(movCactusY = 40);
                    puntuacion++;
                    textScore.setText(String.valueOf(puntuacion));
                };
                
                
                })
        );
        animationDesierto.setCycleCount(Timeline.INDEFINITE);
        animationDesierto.play();
        
        root.getChildren().add(grupoLinea1);
        root.getChildren().add(grupoRoca);
        root.getChildren().add(grupoRoca2Y);
        root.getChildren().add(grupoCactus);
        root.getChildren().add(grupoCactus2);
        root.getChildren().add(muro);

        
       //CONTROLES DE LA MOTO 
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