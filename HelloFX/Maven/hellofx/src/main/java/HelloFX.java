
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;

public class HelloFX extends Application {

    Canvas canvas;
    public int frame=0;
    public double totalSimTime=0;
    //private boolean running = true;

    public void start(Stage stage) {
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
                // if(dt>(1.0/60)){
                //     lastTime = now;
                //     frame++;
                //     draw();
                // }
                //if (running) {update(dt);}
                
            }
        };

        timer.start();

        Scene scene = new Scene(new StackPane(canvas), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Gravity simulation");
        stage.show();
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.web("#0080FF"));
        gc.fillOval(100,100,50,50);
        gc.fillText("Frames:"+frame,10,10);
    }

    public static void main(String[] args) {
        Simulation sim=new Simulation(1);
        sim.simulateStep();
        launch();
    }

}