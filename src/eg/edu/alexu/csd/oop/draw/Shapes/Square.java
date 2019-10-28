package eg.edu.alexu.csd.oop.draw.Shapes;

import eg.edu.alexu.csd.oop.draw.ShapeTypes;
import eg.edu.alexu.csd.oop.draw.Drawshape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Square extends Drawshape{
	
	Rectangle2D.Double shape;
	double x1 = getProperties().get("x1");
	double y1 = getProperties().get("y1");
	double x2 = getProperties().get("x2");
	double y2 = getProperties().get("y2");

    public Square(int x1, int y1, int x2, int y2, Color fore, Color back) {
        super(ShapeTypes.Square, x1, y1, x2, y2, fore, back);
    }

    @Override
    public void draw(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        shape = new Rectangle2D.Double(Math.min((int)x1, (int)x2), Math.min((int)y1, (int)y2),
        		Math.abs((int)x1- (int)x2), Math.abs((int)y1- (int)y2));

        g.setColor(getFillColor());
        g.fill(shape);

        g.setColor(getColor());
        g.draw(shape);
    }
 
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Square((int)x1,(int)y1,(int) x2, (int)y2, getColor(), getFillColor());
	}

}