/**
 * contains a class that describes a point on the scene
 * @author cse8b tutors wi 2019
 */

/**
 * defines a point object defined by x and y coordinate 
 * in a cartesian 2D plane
 */
public class Point {

    private int x;
    private int y;

    /**
     * @param  x x value of the point
     * @param  y y value of the point
     * @return   a created Point object
     */
    public Point(int x, int y) {
        this.setX( x );
        this.setY( y );
    }

    /**
     * default constructor sets point to 0,0
     * @return a created Point object
     */ 
    public Point() {
        this( 0, 0 );
    }

    /**
     * copy constructor
     * @param  point another point to copy from
     * @return       a created Point object
     */
    public Point(Point point) {
        this.setX( point.getX() );
        this.setY( point.getY() );
    }

    /**
     * getter for x value
     * @return x value
     */
    public int getX() {
        return this.x;
    }

    /**
     * getter for y value
     * @return y value
     */
    public int getY() {
        return this.y;
    }

    /**
     * setter for x value
     * @param x x value to set to 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter for y value
     * @param y y value to set to 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the string representation of this point
     */
    @Override
    public String toString() {
        return String.format("Point: (%d, %d)", getX(), getY());
    }

}
