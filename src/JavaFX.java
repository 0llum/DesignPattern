/**
 * Created by odo on 26.10.16.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX extends Application {

    private Group root;
    private int cursorX = 0;
    private int cursorY = 200;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        Rectangle panel = new Rectangle(600, 400, Color.LIGHTGRAY);
        root.getChildren().add(panel);
        primaryStage.show();

        drawSinus(100, 0.005);
    }

    public void reset() {
        cursorX = 0;
        cursorY = 200;
        root.getChildren().remove(0, root.getChildren().size());
    }

    public void drawLine(int x, int y) {
        int endX = x;
        int endY = 200 - y;
        Line line = new Line(cursorX, cursorY, endX, endY);
        cursorX = endX;
        cursorY = endY;
        line.setStroke(Color.BLACK);
        root.getChildren().add(line);
    }

    public void drawSinus(double amplitude, double frequency) {
        for (int x = 0; x < 600; x++) {
            double y = amplitude * Math.sin(2 * Math.PI * frequency * x);
            drawLine(x, (int)y);
            System.out.println(x + ", " + y);
        }
    }
}
