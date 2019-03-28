import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.util.*;

public abstract class Shape {
  private String shapeName;

  public Shape(String name) {
    shapeName = name;
  }

  public Shape() {
    this("NoName");
  }

  /**
   * Finds the name of the shape object.
   * @return name of shape.
   */
  public String getShapeName() {
    return this.shapeName;
  }

  /**
   * Changes name of shape object.
   */
  public void setShapeName(String newName) {
    this.shapeName = newName;
  }

  public abstract void draw(Group group, Color c, boolean fill);

  public String toString() {
    return this.getShapeName();
  }

  public static Color getRandomColor() {
    Random random = new Random();
    double r = random.nextDouble(),
    g = random.nextDouble(),
    b = random.nextDouble();
    return new Color(r, g, b, 1); // Color Constructor
  }
}
