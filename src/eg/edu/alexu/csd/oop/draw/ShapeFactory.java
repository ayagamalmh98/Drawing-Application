package eg.edu.alexu.csd.oop.draw;


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
}


