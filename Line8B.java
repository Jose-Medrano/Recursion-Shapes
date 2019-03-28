/**
 * contains a class that specifies a line 
 * @author cse8b tutors wi 2019
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * a class specifying a line
 * can be drawn into a javafx.scene.Group
 */
public class Line8B extends Shape {

    // two points define a line
    private Point start;
    private Point end;

    // stroke width for the line, in pixels
    final static int LINE_STROKE = 3;

    /**
     * constructor, deep copy the points passed in
     * @param  start start point of line
     * @param  end   end point of line
     * @return       Line8B object created
     */
    public Line8B( Point start, Point end ){
        super( "NoName" );
        this.setStart( new Point(start) );
        this.setEnd( new Point(end) );
    }

    /**
     * constructor, deep copy the points passed in and sets name
     * @param  start start point of line
     * @param  end   end point of line
     * @param  name  the name of the shape
     * @return       Line8B object created
     */
    public Line8B( Point start, Point end, String name ){
        super( name );
        this.setStart( new Point(start) );
        this.setEnd( new Point(end) );
    }

    /**
     * copy constructor
     * @param  l another line to copy from
     * @return   Line8B object created
     */
    public Line8B(Line8B l) {
        super( "NoName" );
        this.setStart( new Point( l.getStart() ) );
        this.setEnd( new Point( l.getEnd() ) );
    }

    /**
     * copy constructor with its own name
     * @param  l    line to copy from
     * @param  name name for this shape
     * @return      Line8B object created
     */
    public Line8B(Line8B l, String name) {
        super(name);
        this.setStart( new Point( l.getStart() ) );
        this.setEnd( new Point( l.getEnd() ) );
    }

    /**
     * getter for start point
     * @return start of the line
     */
    public Point getStart(){
        return this.start;
    }

    /**
     * getter for end point
     * @return end of the line
     */
    public Point getEnd(){
        return this.end;
    }

    /**
     * setter for start point
     * @param start where we want the line to start
     */
    private void setStart( Point start ) {
        this.start = start;
    }

    /**
     * setter for end point
     * @param end where we want the line to end
     */
    private void setEnd( Point end ){
        this.end = end;
    }

    /**
     * draws the line into a Group
     * @param group where to draw a line
     * @param c     color of the line
     * @param fill  ignored
     */
    @Override
    public void draw (Group group, Color c, boolean fill) {
        // note that fill is unused -- that's special for the line. 
        Line line = new Line(); 
        line.setStartX(start.getX()); 
        line.setStartY(start.getY()); 
        line.setEndX(end.getX()); 
        line.setEndY(end.getY());
        line.setStroke(c);

        // necessary because otherwise the line is so thin it's faded
        line.setStrokeWidth(LINE_STROKE); 

        group.getChildren().add(line);
    }

    /**
     * @return string representation of the line
     */
    @Override
    public String toString(){
        return String.format("Line8B: %s; start: %s; end: %s",
            getShapeName(), start.toString(), end.toString());
    }
}
