
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HelloFX extends Application {
    Canvas canvas;
    GraphicsContext graphics;
    public void start(Stage stage) {
        canvas=new Canvas(640,480);
        graphics=canvas.getGraphicsContext2D();
        graphics.setFill(Color.web("#0080FF"));
        graphics.fillOval(100,100,50,50);
        Scene scene = new Scene(new StackPane(canvas), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Gravity simulation");
        stage.show();
    }

    public static void main(String[] args) {
        Simulation sim=new Simulation(1);
        sim.simulateStep();
        launch();
    }

}