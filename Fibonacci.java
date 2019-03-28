import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Fibonacci {

    // every arc is a quarter circle
    static final int arcLength = 90;

    private static final int NINETY = 90;
    private static final int ONE_EIGHTY = 180;
    private static final int TWO_SEVENTY = 270;
    private static final int THREE_SIXTY = 360;

    /**
     * This method is what draws our golden ratio spiral.
     * @param group is the group of shapes we are adding the arc objects to.
     * @param centerX is the x coordinate where the lines from both endpoints 
     * of the arc meet up.
     * @param centerY in the y coordinate where the line from both endpoints of
     * the arc meet up.
     * @param prevRadius is the previous radius that we used in the arc
     * @param currRadius is the radius we are using to determine the next
     * currRadius.
     * @param startAngle is the angle of our arc that we are determining.
     * @param n is the amount of arc objects we want to create.
     */
    public static void draw(Group group, 
                            int centerX, int centerY,
                            int prevRadius, int currRadius,
                            int startAngle,
                            int n) {
        if (n == 0) return;

        Arc a = new Arc(centerX, centerY, currRadius, currRadius, 
                        startAngle, arcLength);
        a.setType(ArcType.ROUND);
        a.setFill(null);
        a.setStroke(Color.BLACK);
        group.getChildren().add(a);

        // Where my code come in.
        int increment = prevRadius;
        prevRadius = currRadius;
        currRadius = currRadius + increment;

        if (startAngle == 0) {
          startAngle = startAngle + arcLength;
          centerY = centerY + increment;
          draw(group, centerX, centerY, prevRadius, currRadius, startAngle, 
              n - 1);

        } else if (startAngle == NINETY) {
          startAngle = startAngle + arcLength;
          centerX = centerX + increment;
          draw(group, centerX, centerY, prevRadius, currRadius, startAngle, 
              n - 1);

        } else if (startAngle == ONE_EIGHTY) {
          startAngle = startAngle + arcLength;
          centerY = centerY - increment;
          draw(group, centerX, centerY, prevRadius, currRadius, startAngle, 
              n - 1);

        } else if (startAngle == TWO_SEVENTY) {
          // 0 == 360
          startAngle = 0; 
          centerX = centerX - increment;
          draw(group, centerX, centerY, prevRadius, currRadius, startAngle, 
              n - 1);
        }
    }

}
