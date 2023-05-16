
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ClockPane extends Pane{

    private int hour;
    private int minute;
    private int second;
    boolean hourHandVisible = true;
    boolean minuteHandVisible = true;
    boolean secondHandVisible = true;

    //Constructors
    public ClockPane() {
    }

    public ClockPane(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getters
    public int getHour() {
        return hour;
    }
    public int getMinute () {
        return minute;
    }
    public int getSecond() {
        return second;
    }
    public boolean getHourHandVisible() {
        return hourHandVisible;
    }
    public boolean getMinuteHandVisible() {
        return getMinuteHandVisible();
    }
    public boolean getSecondHandVisible() {
        return getSecondHandVisible();
    }

    // Setters
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }
    public void setHourHandVisible(boolean visible) {
        hourHandVisible = visible;
        paintClock();
    }
    public void setMinuteHandVisible(boolean visible) {
        minuteHandVisible = visible;
        paintClock();
    }
    public void setSecondHandVisible(boolean visible) {
        secondHandVisible = visible;
        paintClock();
    }

    //Paint the clock
    void paintClock() {
        // Set parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // Draw Circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        // Draw labels
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // Draw Second Hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        if (secondHandVisible == false){
            sLine.setOpacity(0);
        }

        // Draw Min Hand
        double mLength = clockRadius * 0.65;
        double minX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minX, minY);
        mLine.setStroke(Color.BLUE);
        if (minuteHandVisible == false){
            mLine.setOpacity(0);
        }

        // Draw hr Hand
        double hLength = clockRadius * 0.5;
        double hrX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hrY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hrX, hrY);
        hLine.setStroke(Color.GREEN);
        if(hourHandVisible == false){
            hLine.setOpacity(0);
        }
        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
    }
    // Override setWidth and setHeight
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paintClock();
    }
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paintClock();
    }


}
