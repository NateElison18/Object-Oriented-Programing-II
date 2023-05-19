/**
 * Author: Nate Elison
 * Date: 5/18/23
 *
 * This program builds an animation of a rectangle following an outline of a pentagon, while fading in and out.
 * The user can play and pause the animation by clicking inside the pentagon.
 */

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.Scene;
import javafx.util.Duration;

public class Exercise15_Animation extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        // Build Rectangle
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.PURPLE);
        rectangle.setStroke(Color.BLACK);

        // Build pentagon
        Polygon pentagon = new Polygon();
        ObservableList<Double> list = pentagon.getPoints();
        int s = 5;
        int pentCenterX = 100;
        int pentCenterY = 100;
        int pentRadius = 60;
        for (int i = 0; i < s; i++) {
            list.add(pentCenterX + pentRadius * Math.cos(2 * i * Math.PI / s));
            list.add(pentCenterY - pentRadius * Math.sin(2 * i * Math.PI / s));
        }
        pentagon.setFill(Color.WHITE);
        pentagon.setStroke(Color.BLACK);

        // Add shapes to a pane
        Pane pane = new Pane();
        pane.getChildren().addAll(pentagon, rectangle);

        // Build Path Transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(pentagon);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // Build Fade Transition
        FadeTransition ft = new FadeTransition(Duration.millis(2000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        // Play/pause w mouse click
        pentagon.setOnMouseClicked(e -> {
            if(pt.getStatus().equals(Animation.Status.RUNNING)) {
                pt.pause();
                ft.pause();
            }
            else if(pt.getStatus().equals(Animation.Status.PAUSED)){
                pt.play();
                ft.play();
            }
         });
        // Build window
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
