package eg.edu.alexu.csd.oop.draw.Shapes;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

import eg.edu.alexu.csd.oop.draw.Drawshape;
import eg.edu.alexu.csd.oop.draw.ShapeTypes;

public  class Line extends Drawshape{
	double x1 = getProperties().get("x1");
	double y1 = getProperties().get("y1");
	double x2 = getProperties().get("x2");
	double y2 = getProperties().get("y2");

	public Line(int x1, int y1, int x2, int y2, Color fore, Color back) {
		super(ShapeTypes.Line, x1, y1, x2, y2, fore, back);
	}

	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine((int)x1,(int)y1,(int)x2
				, (int)y2);
	}

	public boolean contains(int x, int y) {
		int dxc = (int) (x - x1);
		int dyc = (int) (y - y1);
		int dxl =(int) (x2 - x1);
		int dyl = (int) (y2 - y1);
		int cross = dxc * dyl - dyc * dxl;
		return cross == 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Line((int)x1,(int) y1, (int)x2, (int)y2, getColor(), getFillColor());
	}



}