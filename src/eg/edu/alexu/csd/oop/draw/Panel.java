package eg.edu.alexu.csd.oop.draw;

import eg.edu.alexu.csd.oop.draw.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.Shapes.Line;
import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;
import eg.edu.alexu.csd.oop.draw.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.Shapes.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import eg.edu.alexu.csd.oop.draw.ShapeTypes;
import eg.edu.alexu.csd.oop.draw.Drawshape;
import eg.edu.alexu.csd.oop.draw.g;

public class Panel extends JPanel{
	public Draw myEngine;

	public boolean resize = false,
			recoloring = false,
			moving = false,
			deleting = false,
			copying = false;

	public ShapeTypes currentShapeType;
	public Drawshape currentShapeObject,copiedObject;

	public Panel() {
		myEngine = new Draw(this);

		//Initialize current Shape variables
		currentShapeType = ShapeTypes.Line;
		currentShapeObject = null;

		setLayout(new BorderLayout()); //sets layout to border layout; default is flow layout
		setBackground(Color.WHITE); //sets background color of panel to white

		// event handling for mouse and mouse motion events
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		myEngine.refresh(g);
	}


	public void resetAll() {
		copiedObject = null;
		moving = resize = recoloring = deleting = copying = false;
	}

	public void setCurrentShapeType(ShapeTypes type) {
		resetAll();
		currentShapeType = type;

	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent event) {
			if (copying) {
				copiedObject =  myEngine.findShape(event.getX(), event.getY(), false);
				copying = false;
				return;
			}
			if (copiedObject != null) {
				int new_x = event.getX();
				int new_y = event.getY();
				int to_add_X = (int) (new_x - copiedObject.getProperties().get("x1"));
				int to_add_Y = (int) (new_y - copiedObject.getProperties().get("y1"));
				int new_x1 = (int) (copiedObject.getProperties().get("x1") + to_add_X);
			    int new_y1 = (int) (copiedObject.getProperties().get("y1") + to_add_Y);
				int new_x2 = (int) (copiedObject.getProperties().get("x2") + to_add_X);
				int new_y2 = (int) (copiedObject.getProperties().get("y2") + to_add_Y);
				Drawshape obj = (Drawshape) ShapeFactory.getShape(copiedObject);
				
				if (obj != null) {
					myEngine.updateUndoStack();
					obj.updateAllCoords(new_x1, new_y1, new_x2, new_y2);
					myEngine.addShape(obj);
					repaint();
				}
				copiedObject = null;
			}
			if (moving || resize) {
				currentShapeObject =  myEngine.findShape(event.getX(), event.getY(), true);
				return;
			}
			if (deleting) {
				currentShapeObject = myEngine.findShape(event.getX(), event.getY(), true);
				currentShapeObject = null;
				repaint();
			} else if (recoloring) {
				Drawshape s = myEngine.findShape(event.getX(), event.getY(), false);
				if (s == null) {
					return;
				}
				myEngine.updateUndoStack();
				s.setFillColor(g.FillColor);
				repaint();

			} else {
				currentShapeObject = (Drawshape) ShapeFactory.getInstance(currentShapeType, event.getX(), event.getY());
			}
		}

		@Override
		public void mouseReleased(MouseEvent event) {

			//sets currentShapeObject x2 & Y2
			if (recoloring || currentShapeObject == null) {
				return;
			}

			if (!moving) {
				if (!resize) {
					myEngine.updateUndoStack();
				}
				
				currentShapeObject.setX2(event.getX());
				currentShapeObject.setY2(event.getY());

				

			}
			myEngine.addShape(currentShapeObject); //addFront currentShapeObject onto myShapes

			currentShapeObject = null; //sets currentShapeObject to null
			repaint();

		}
		

		@Override
		public void mouseDragged(MouseEvent event) {
			if (currentShapeObject == null) {
				return;
			}
			
			if (moving) {
				int new_x = event.getX(), new_y = event.getY();
				int to_add_X = new_x - currentShapeObject.getX1();
				int to_add_Y = new_y - currentShapeObject.getY1();
				currentShapeObject.setX1(currentShapeObject.getX1() + to_add_X);
				currentShapeObject.setY1(currentShapeObject.getY1() + to_add_Y);
				currentShapeObject.setX2(currentShapeObject.getX2() + to_add_X);
				currentShapeObject.setY2(currentShapeObject.getY2() + to_add_Y);
				repaint();
				return;
			}
			
			currentShapeObject.setX2(event.getX());
			currentShapeObject.setY2(event.getY());
			currentShapeObject = (Drawshape) ShapeFactory.getInstancee(currentShapeObject,currentShapeType, event.getX(), event.getY());
			repaint();
		}
	}



















}
