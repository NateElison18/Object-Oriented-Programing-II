/**
 * Author: Nate Elison
 * Date: 5/15/23
 *
 * This program uses JavaFX to display a stop sign.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;



public class Exercise14_15 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create an octagon
        Octagon stopSign = new Octagon();

        // Create and format label
        javafx.scene.control.Label label = new javafx.scene.control.Label("STOP");
        label.setFont(Font.font("Times New Roman", 45));
        label.setTextFill(Color.WHITE);

        // Put it all together
        Pane pane = new StackPane(); // Create a pane
        pane.getChildren().addAll(stopSign, label); // Add elements to the pane
        Scene scene = new Scene(pane); // Create a scene and add pane

        primaryStage.setTitle("ShowStopSign"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
