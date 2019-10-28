package eg.edu.alexu.csd.oop.draw.Shapes;

import java.awt.geom.*;
import java.awt.*;

import eg.edu.alexu.csd.oop.draw.Drawshape;
import eg.edu.alexu.csd.oop.draw.ShapeTypes;

public class Rectangle extends Drawshape{
	
	 Rectangle2D.Double shape;
	    double x1 = getProperties().get("x1");
		double y1 = getProperties().get("y1");
		double x2 = getProperties().get("x2");
		double y2 = getProperties().get("y2");


	    public Rectangle(int x1, int y1, int x2, int y2, Color fore, Color back) {
	        super(ShapeTypes.Rectangle, x1, y1, x2, y2, fore, back);
	    }


		@Override
		public void draw(Graphics canvas) {
			  Graphics2D g = (Graphics2D) canvas;
		        shape = new Rectangle2D.Double(Math.min((int)x1, (int)x2), Math.min((int)y1, (int)y2),
		        		Math.abs((int)x1- (int)x2), Math.abs((int)y1- (int)y2));

		        g.setColor(getFillColor());
		        g.fill(shape);

		        g.setColor(getColor());
		        g.draw(shape);
			
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return new Rectangle((int)x1,(int)y1,(int) x2, (int)y2, getColor(), getFillColor());
		}

}