/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/27/19
 * Sources: piazza.com/class/jqe6cd8pdbq61?cid=2837
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * A class specifying a square that can be drawn into javafx.scene.Group.
 */
public class Square extends Shape {
  private Point upperLeft;
  private int side;

  /**
   * Constructor with no name.
   * @param upperLeft is the upperLeft point of the square.
   * @param side is the length of the sides.
   */
  public Square(Point upperLeft, int side) {
    super("NoName");
    this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
    this.side = side;
  }

  /**
   * Constructor with name.
   * @param upperLeft is the top left of the square
   * @param side is the length of the sides.
   * @param name is the name of the square.
   */
  public Square(Point upperLeft, int side, String name) {
    super(name);
    this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
    this.side = side;
  }

  /**
   * Copy constructor
   * @param square is the Square we are copying.
   */
  public Square(Square square) {
    super("NoName");
    this.setUpperLeft(new Point(square.getUpperLeft()));
    this.setSide(square.getSide());
  }

  /**
   * no-arg constructor
   */
  public Square() {
    super("NoName");
    upperLeft = new Point(0,0);
    side = 0;
  }

  /**
   * This method returns the top left point of the square.
   * @return Point is the topleft.
   */
  public Point getUpperLeft() {
    return this.upperLeft;
  }

  /**
   * This method returns the size of the side.
   * @return int is the side length.
   */
  public int getSide() {
    return this.side;
  }

  /**
   * This method changes the top left corner of the square.
   * @param upperLeft is the new corner.
   */
  private void setUpperLeft(Point upperLeft) {
    this.upperLeft = upperLeft;
  }

  /**
   * This method changes the side length of the square.
   * @param side is the length of the side.
   */
  private void setSide(int side) {
    this.side = side;
  }
  
  /**
   * Draws a square with the specified color and fill type.
   * @param group is the group of shapes we are adding the squares to.
   * @param c is the color of the outline and potential fill.
   * @param fill is a boolean to determine whether or not we fill in the
   * square.
   */
  @Override
    public void draw(Group group, Color c, boolean fill) {
      Rectangle square = new Rectangle(upperLeft.getX(), upperLeft.getY(), 
          side, side);
      square.setStroke(c);

      if (fill) {
        square.setFill(c);
      } else {
        square.setFill(null);
      }
      group.getChildren().add(square);
    } 

  /**
   * This prints out the square name, upperLeft point, and radius.
   * @return String is ^^.
   */
  @Override
    public String toString() {
      return String.format("Square: %s; upperLeft: %s; side: %s",
          getShapeName(), upperLeft.toString(), side);
    }

  /**
   * This method creates a square at every vertice from the original square
   * and then so on for each newly creates square.
   * @param group is the group of squares.
   * @param fill tells us whether to fill in the squares or not.
   * @param n is the amount of times we will perform this operation.
   */
  public void drawGrid(Group group, boolean fill, int n) {
    if (n > 0) {
      Point ref = new Point(upperLeft);

      Point s1 = new Point(ref.getX() - side, ref.getY() - side);
      upperLeft = s1;
      Square sq1 = new Square(upperLeft, side);
      draw(group, getRandomColor(), fill);
      drawGrid(group, fill, n - 1);

      Point s2 = new Point(ref.getX() - side, ref.getY() + side);
      upperLeft = s2;
      Square sq2 = new Square(upperLeft, side);
      draw(group, getRandomColor(), fill);
      drawGrid(group, fill, n - 1);

      Point s3 = new Point(ref.getX() + side, ref.getY() - side);
      upperLeft = s3;
      Square sq3 = new Square(upperLeft, side);
      draw(group, getRandomColor(), fill);
      drawGrid(group, fill, n - 1);

      Point s4 = new Point(ref.getX() + side, ref.getY() + side);
      upperLeft = s4;
      Square sq4 = new Square(upperLeft, side);
      draw(group, getRandomColor(), fill);
      drawGrid(group, fill, n - 1);
    }
  }
}
