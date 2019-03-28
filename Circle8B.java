/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/27/19
 * Sources:
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * A class specifying a circle that can be drawn into javafx.scene.Group
 */
public class Circle8B extends Shape {
  private static final int RADIUS_DECREMENT = 10;
  private Point center;
  private int radius;

  // 5 Constructors
  /**
   * constructor, deep copy with no name.
   * @param center is the center of the cirle.
   * @param radius is the radius of the circle.
   */
  public Circle8B(Point center, int radius) {
    super("NoName");
    this.center = new Point(center.getX(), center.getY());
    this.radius = radius;
  }

  /**
   * constructor, deep copy with a name.
   * @param center is the center of the circle.
   * @param radius is the radius of the circle.
   * @param name is the name of the circle.
   */
  public Circle8B(Point center, int radius, String name) {
    super(name);
    this.center = new Point(center.getX(), center.getY());
    this.radius = radius;
  }

  /**
   * Copy constructor with no name.
   * @param c is the circle we are copying.
   */
  public Circle8B(Circle8B c) {
    super("NoName");
    this.setCenter(new Point(c.getCenter()));
    this.setRadius(c.getRadius());
  }

  /**
   * copy constructor with new name.
   * @param c is the circle we are copying.
   * @param name is the new name of the circle.
   */
  public Circle8B(Circle8B c, String name) {
    super(name);
    this.setCenter(new Point(c.getCenter()));
    this.setRadius(c.getRadius());
  }

  /**
   * no-arg construcor
   */
  public Circle8B() {
    super("NoName");
    center = new Point(0, 0);
    radius = 0;
  }

  /**
   * This method returns the point located at the center.
   * @return Point is the center.
   */
  public Point getCenter() {
    return this.center;
  }

  /**
   * This method returns the radius of the circle.
   * @return int is the radius of the circle.
   */
  public int getRadius() {
    return this.radius;
  }

  /**
   * This method changes the center of a circle.
   * @param center is the center of the circle.
   */
  private void setCenter(Point center) {
    this.center = center;
  }

  /**
   * This method changes the radius of a circle.
   * @param radius is the new radius.
   */
  private void setRadius(int radius) {
    this.radius = radius;
  }

  /**
   * Draws a circle with the specified color and fill type.
   * @param group is the group of shapes we are adding the circle to.
   * @param c is the color of the line and potential fill.
   * @param fill is a boolean to determine whether or not we fill in the
   * circle.
   */
  @Override
    public void draw(Group group, Color c, boolean fill) {
      Circle circle = new Circle(center.getX(), center.getY(), radius);
      circle.setStroke(c);

      if (fill) {
        circle.setFill(c);
      } else {
        circle.setFill(null);
      }

      group.getChildren().add(circle);
    }

  /**
   * This prints out the circle name, center point, and radius.
   * @return String is ^^.
   */
  @Override
    public String toString() {
      return String.format("Circle: %s; Center: %s; Radius: %s",
          getShapeName(), center.toString(), radius);
    }

  /**
   * This method recursively calls the draw method to create a bullseye with
   * the same amount of rings as int 'n'.
   * @param group is the group of shapes we are adding the rings to.
   * @param fill is the boolean on whether or not we want the circles to be
   * solid or just outlines.
   * @param n is the number of rings we want in our bullseye.
   */
  public void drawBullsEye(Group group, boolean fill, int n) {
    if (n > 0) {
      draw(group, getRandomColor(), fill);
      radius = radius - RADIUS_DECREMENT;
      drawBullsEye(group, fill, n - 1);
    }
    return;
  }
}
