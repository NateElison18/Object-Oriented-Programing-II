/**
 * Author: Nate Elison
 * Date: 5/17/23
 *
 * This program builds and displays a window with a circle and buttons that, when clicked,
 * move the circle left, right, up, and down. 
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Exercise15_03 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Circle circle = new Circle(40, 50, 20);


    @Override
    public void start(Stage primaryStage) {
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        //Hbox for the 4 buttons
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);


        btLeft.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 10 : 0);
        });

        btRight.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() < 200 ? circle.getCenterX() + 10 : 200);
        });
        btUp.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() > 0 ? circle.getCenterY() - 10 : 0);
        });
        btDown.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() < 150 ? circle.getCenterY() + 10 : 150);
        });

        // Build window
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("MoveCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


