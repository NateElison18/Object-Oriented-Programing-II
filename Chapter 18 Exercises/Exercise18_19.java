/**
 * Author: Nate Elison
 * Date: 6/1/23
 *
 * This program revises given code that paints sierpinski triangles. It has been changed to add "-" and "+" buttons,
 * that control the order of the displayed triangles.
 */

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise18_19 extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        // Create the triangle pane and the buttons
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
        Button btFewer = new Button("-");
        Button btMore = new Button("+");

        // Action statements for button presses
        btFewer.setOnAction(e -> {
            if (trianglePane.getOrder() != 0) {
                trianglePane.setOrder((trianglePane.getOrder() - 1));
            };
        });
        btMore.setOnAction(e -> trianglePane.setOrder((trianglePane.getOrder() + 1)));

        // Create an Hbox and add the buttons to the box
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(btFewer, btMore);
        hBox.setAlignment(Pos.CENTER);

        // Create a borderPane, add, and align the other panes to it.
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);

        // Build the scene
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        trianglePane.paint();

        // Listeners for when the scene is stretched, so are the triangles
        scene.widthProperty().addListener(ov -> trianglePane.paint());
        scene.heightProperty().addListener(ov -> trianglePane.paint());
    }

    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;

        // Setter and getter for the oder
        public void setOrder(int order) {
            this.order = order;
            paint();
        }
        public int getOrder() {
            return order;
        }

        // Constructor
        SierpinskiTrianglePane() {
        }

        // Paint methods
        protected void paint() {
            // Select three points in proportion to the panel size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear(); // Clear the pane before redisplay

            displayTriangles(order, p1, p2, p3);
        }

        // Recursive method to display the triangles 
        private void displayTriangles(int order, Point2D p1,
                                      Point2D p2, Point2D p3) {
            if (order == 0) {
                // Base Case: Draw a triangle to connect three points
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(),
                        p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            }
            else {
                // Get the midpoint on each edge in the triangle
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                // Recursively display three triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
        }
    }
}
