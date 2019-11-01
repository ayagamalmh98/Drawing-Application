package eg.edu.alexu.csd.oop.draw;


import java.awt.Color;

import eg.edu.alexu.csd.oop.draw.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.Shapes.Line;
import eg.edu.alexu.csd.oop.draw.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.Shapes.Triangle;
import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;

public class ShapeFactory {
	public static Shape getShape(Shape copiedObject) {
		Shape obj = null;
		if (copiedObject instanceof Circle) {
			try {
				obj = (Circle) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (copiedObject instanceof Square) {
			try {
				obj = (Square) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (copiedObject instanceof Rectangle) {
			try {
				obj = (Shape) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (copiedObject instanceof Line) {
			try {
				obj = (Line) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (copiedObject instanceof Triangle) {
			try {
				obj = (Triangle) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (copiedObject instanceof Ellipse) {
			try {
				obj = (Ellipse) copiedObject.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static Shape getInstance(ShapeTypes currentShapeType, int x, int y) {
		Drawshape currentShapeObject = null;
		switch (currentShapeType) {
		case Line: {
			currentShapeObject = new Line(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}
		case Rectangle: {
			currentShapeObject = new Rectangle(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}
		case Square: {
			currentShapeObject = new Square(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}
		case Ellipse: {
			currentShapeObject = new Ellipse(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}
		case Circle: {
			currentShapeObject = new Circle(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}
		case Triangle: {
			currentShapeObject = new Triangle(x, y,
					x, y, g.ForeColor, g.BackColor);
			break;
		}

		}
		return currentShapeObject;
	}
	
	public static Shape getInstancee(Drawshape habd,ShapeTypes currentShapeType, int x, int y) {
		Drawshape currentShapeObject = null;
		double x1 = habd.getProperties().get("x1");
		double y1 = habd.getProperties().get("y1");

		switch (currentShapeType) {
		case Line: {
			habd = new Line((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}
		case Rectangle: {
			habd = new Rectangle((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}
		case Square: {
			habd = new Square((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}
		case Ellipse: {
			habd = new Ellipse((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}
		case Circle: {
			habd = new Circle((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}
		case Triangle: {
			habd = new Triangle((int)x1, (int)y1,
					x, y, g.ForeColor, habd.getFillColor());
			break;
		}

		}
		return habd;
	}
	public static Shape getInstanceee(Drawshape s,ShapeTypes currentShapeType, int x, int y) {
		Drawshape currentShapeObject = null;
		Color c=s.getFillColor();
		System.out.println(c);
		
		switch (currentShapeType) {
		case Line: {
			currentShapeObject = new Line(x, y,
					x, y, g.ForeColor, c);
			break;
		}
		case Rectangle: {
			currentShapeObject = new Rectangle(x, y,
					x, y, g.ForeColor, c);
			break;
		}
		case Square: {
			currentShapeObject = new Square(x, y,
					x, y, g.ForeColor, c);
			break;
		}
		case Ellipse: {
			currentShapeObject = new Ellipse(x, y,
					x, y, g.ForeColor, c);
			break;
		}
		case Circle: {
			currentShapeObject = new Circle(x, y,
					x, y, g.ForeColor, c);
			break;
		}
		case Triangle: {
			currentShapeObject = new Triangle(x, y,
					x, y, g.ForeColor, c);
			break;
		}

		}
		return currentShapeObject;
	}

	public static Shape move(ShapeTypes currentShapeType, int x1, int x2,int y1,int y2) {
		Drawshape currentShapeObject = null;
		switch (currentShapeType) {
		case Line: {
			currentShapeObject = new Line(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}
		case Rectangle: {
			currentShapeObject = new Rectangle(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}
		case Square: {
			currentShapeObject = new Square(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}
		case Ellipse: {
			currentShapeObject = new Ellipse(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}
		case Circle: {
			currentShapeObject = new Circle(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}
		case Triangle: {
			currentShapeObject = new Triangle(x1, y1,
					x2, y2, g.ForeColor, g.BackColor);
			break;
		}

		}
		return currentShapeObject;
	}
}































