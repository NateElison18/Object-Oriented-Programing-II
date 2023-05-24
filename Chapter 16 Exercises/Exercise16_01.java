/**
 * Author: Nate Elison
 * Date: 5/22/23
 *
 * This program creates a window with a GUI that controls a line of text.
 * The text can be moved left and right, and the text color can also be changed. 
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise16_01 extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        // Create panes
        BorderPane pane = new BorderPane();
        HBox radioPane = new HBox();
        HBox movePane = new HBox();
        Pane textPane = new Pane();

        // Create label and add it to the pane
        Label text = new Label("Programing is fun");
        text.setLayoutX(50);
        text.setLayoutY(20);
        textPane.getChildren().add(text);
        textPane.setStyle("-fx-border-width: 1px; -fx-border-color: black");
        pane.setCenter(textPane);

        // Create radio buttons, add them to the pane, group them together
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        rbBlack.setSelected(true);
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        radioPane.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        radioPane.setAlignment(Pos.CENTER);
        radioPane.setSpacing(5);
        pane.setTop(radioPane);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // Handle radio buttons

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()){
                text.setTextFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()){
                text.setTextFill(Color.YELLOW);
            }
        });

        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()){
                text.setTextFill(Color.BLACK);
            }
        });

        rbOrange.setOnAction(e -> {
            if (rbOrange.isSelected()){
                text.setTextFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()){
                text.setTextFill(Color.GREEN);
            }
        });

        // Create left/right buttons
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");

        movePane.getChildren().addAll(btLeft, btRight);
        movePane.setAlignment(Pos.CENTER);
        movePane.setSpacing(5);
        pane.setBottom(movePane);

        // Handle move button actions

        btLeft.setOnAction(e -> {
            text.setLayoutX(text.getLayoutX() > 0 ? text.getLayoutX() - 50 : 0);
        });
        btRight.setOnAction(e -> {
            text.setLayoutX(text.getLayoutX() < (pane.getWidth() - text.getWidth()) ? text.getLayoutX() + 50 : (pane.getWidth() - text.getWidth()));
        });

        // Build Window
        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("Programing is Fun!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
