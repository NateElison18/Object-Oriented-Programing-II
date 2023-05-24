/**
 * Author: Nate Elison
 * Date: 5/23/23
 *
 * This program creates a window of a text field that takes in a number, counts from that number down in seconds and finally,
 * once the timer hits 0, plays a song indefinitely. 
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;





public class Exercise16_21 extends Application{
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) {

        // Create text field, media, and media player
        TextField tf = new TextField();
        Media song = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer player = new MediaPlayer(song);
        player.setCycleCount(MediaPlayer.INDEFINITE);

        // Countdown animation
        Timeline countDownAnimation = new Timeline(new KeyFrame(Duration.seconds(1), eh -> {
            int countDown = Integer.parseInt(tf.getText());
            countDown--;
            tf.setText(String.valueOf(countDown));
            if (countDown <= 0){
                player.play();
            }
        }));

        // Action after input
        tf.setOnAction(e -> {
            countDownAnimation.setCycleCount(Integer.parseInt(tf.getText()));
            countDownAnimation.play();
        });


        // Build the window
        Pane pane = new Pane();
        tf.setAlignment(Pos.CENTER);
        pane.getChildren().add(tf);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Count down");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
