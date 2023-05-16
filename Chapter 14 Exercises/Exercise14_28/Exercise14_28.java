/**
 * Author: Nate Elison
 * Date: 5/15/23
 *
 * This program uses a ClockPane class to build a clock showing only the minute and hour hands.
 * The hour is generated randomly, and the minute hand is set at either 0 or 30. 
 */

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Exercise14_28 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){
        // Generate random hour and minute values
        int hour = (int) (Math.random() * 12);
        int minTemp = (int) ((Math.random() * 10) % 2);
        int min = 0;
        if (minTemp == 1) min = 30;
        int sec = 0;

        // Create Clock
        ClockPane clock = new ClockPane(hour, min, sec);
        clock.setSecondHandVisible(false);

        // Build Stage
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
