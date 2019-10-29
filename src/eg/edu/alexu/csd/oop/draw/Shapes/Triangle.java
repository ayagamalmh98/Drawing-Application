package eg.edu.alexu.csd.oop.draw.Shapes;

import eg.edu.alexu.csd.oop.draw.Drawshape;
import eg.edu.alexu.csd.oop.draw.ShapeTypes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Drawshape{ 

	int x3;
	double x1 = getProperties().get("x1");
	double y1 = getProperties().get("y1");
	double x2 = getProperties().get("x2");
	double y2 = getProperties().get("y2");
	public Triangle(int x1, int y1, int x2, int y2, Color fore, Color back) {
		super(ShapeTypes.Triangle, x1, y1, x2, y2, fore, back);
	}

	@Override
	public void draw(Graphics g) {
		x3 = 2 * (int)x1 - (int)x2;
		g.setColor(getFillColor());
		g.fillPolygon(new int[]{(int)x1, (int)x2, x3}, new int[]{(int)y1, (int)y2, (int)y2}, 3);

		g.setColor(getColor());
		g.drawPolygon(new int[]{(int)x1, (int)x2, x3}, new int[]{(int)y1,(int)y2,(int)y2}, 3);
	}
	
	 public boolean contains(int x, int y) {
	        int y3 = (int) y2;
	        double ABC = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
	        double ABP = Math.abs(x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));
	        double APC = Math.abs(x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
	        double PBC = Math.abs(x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));

	        return ABP + APC + PBC == ABC;
	    }



	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Triangle((int)x1,(int)y1,(int) x2, (int)y2, getColor(), getFillColor());
	}

}