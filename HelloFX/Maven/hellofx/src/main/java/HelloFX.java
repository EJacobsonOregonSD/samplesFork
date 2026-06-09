
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HelloFX extends Application {

    Canvas canvas;

    Slider scaleSlider; //a slider of the viewport width in meters

    public int frame=0;
    public double totalSimTime=0;
    //private boolean running = true;

    public Simulation sim;
    public Body[][] bodyRecord;

    public void start(Stage stage) {
        sim=new Simulation(1);
        bodyRecord = sim.recordSteps(2);
        System.out.println(bodyRecord[0][1].xPos);
        System.out.println(bodyRecord[0][1].xVel);
        System.out.println(bodyRecord[1][1].xPos);
        System.out.println(bodyRecord[1][1].xVel);
        
        canvas=new Canvas(640,480);

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }
                double dt = (now - lastTime) / 1_000_000_000.0;
                lastTime=now;
                frame++;
                draw();
                
            }
        };

        timer.start();

        scaleSlider=new Slider(0,1,0.5);

        HBox controls = new HBox(
                scaleSlider
        );

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controls);

        Scene scene = new Scene(root, 640, 540);
        stage.setScene(scene);
        stage.setTitle("Gravity simulation");
        stage.show();
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //gc.fill();

        int currentFrame=Math.min(frame,bodyRecord.length-1);
        double screenWidth=1e6*Math.pow(5e8,scaleSlider.getValue());//calculates width from slider
        double camX=bodyRecord[currentFrame][0].xPos;//x of center
        double camY=bodyRecord[currentFrame][0].yPos;//y of center

        for(Body body:bodyRecord[currentFrame]){
            double sizePixels=body.radius*640/screenWidth;
            if(sizePixels<5){
                gc.setFill(Color.web("#0080FF"));
                sizePixels=15;
            }
            else gc.setFill(Color.web("#FF4000"));
            gc.fillOval(
                (body.xPos-camX)*640/screenWidth+320-sizePixels/2,
                (body.yPos-camY)*640/screenWidth+240-sizePixels/2,
                sizePixels,sizePixels
            );
            gc.fillText(
                body.name,
                (body.xPos-camX)*640/screenWidth+320,
                (body.yPos-camY)*640/screenWidth+240+sizePixels/2+10
            );
        }
        
        
        gc.fillText("Screen width:"+screenWidth,10,10);
    }

    public static void main(String[] args) {
        launch();
    }

}