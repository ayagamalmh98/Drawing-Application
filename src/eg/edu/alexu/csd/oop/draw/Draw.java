package eg.edu.alexu.csd.oop.draw;


import java.awt.Graphics;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.draw.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.Shapes.Line;
import eg.edu.alexu.csd.oop.draw.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.Shapes.Triangle;

import eg.edu.alexu.csd.oop.draw.XML;
import eg.edu.alexu.csd.oop.draw.ILoadSave;
import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;


public class Draw implements DrawingEngine {
	private  ILoadSave jsonSaver;
	private  ILoadSave xmlSaver;

	private List<Class<? extends Shape>> supportedShapes;
	public Stack<ArrayList<Drawshape>> undoStack, redoStack;
	public ArrayList<Drawshape> myShapes;
	public ArrayList<Drawshape> undo;
	public ArrayList<Shape> pluginShapes;
	private Panel panel;

	public Draw(Panel panel) {
		this.panel = panel;
		this.xmlSaver = new XML();
		this.undoStack = new Stack<>();
		this.redoStack = new Stack<>();
		this.myShapes = new ArrayList<>();
		this.pluginShapes = new ArrayList<>();
	}


	@Override
	public void refresh(Graphics canvas) {
		myShapes.forEach((p) -> {
			p.draw(canvas);
		});

		//draws the current Shape Object if it is not null
		if (panel.currentShapeObject != null) {
			panel.currentShapeObject.draw(canvas);
		}
	}


	@Override
	public void addShape(Shape shape) {
		this.myShapes.add((Drawshape) shape);
	}

	@Override
	public void removeShape(Shape shape) {
		if (myShapes.contains(shape)) {
			myShapes.remove(shape);
		}
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		removeShape(oldShape);
		addShape(newShape);
	}

	@Override
	public Shape[] getShapes() {
		return (Shape[]) myShapes.toArray();
	}

	public void updateUndoStack() {
		ArrayList<Drawshape> u = new ArrayList<>();
		myShapes.forEach((p) -> {
			try {
				u.add((Drawshape) p.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		undoStack.push((ArrayList<Drawshape>) u);
	}

	public void updateRedoStack() {
		ArrayList<Drawshape> u = new ArrayList<>();
		myShapes.forEach((p) -> {
			try {
				u.add((Drawshape) p.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		redoStack.push((ArrayList<Drawshape>) u);
	}


	public Drawshape findShape(int x, int y, boolean remove) {
		for (Drawshape p : myShapes) {
			if (p.contains(x, y)) {
				if (remove) {
					updateUndoStack();// done
					myShapes.remove(p);
				}
				return p;
			}
		}
		return null;
	}

	@Override
	public void undo() {
		if (!undoStack.isEmpty()) {
			updateRedoStack();
			myShapes = undoStack.pop();
			panel.repaint();
		}
	}

	@Override
	public void redo() {
		if (!redoStack.isEmpty()) {
			updateUndoStack();
			myShapes = redoStack.pop();
			panel.repaint();
		}
	}

	@Override
	public void save(String path) {
		if (path.toLowerCase().endsWith(".xml")) {
			xmlSaver.Save(myShapes, path);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Save format.");
			throw new RuntimeException("Invalid format");
		}


	}

	@Override
	public void load(String path) {
		if (path.toLowerCase().endsWith(".json")) {
			myShapes = jsonSaver.Load(path);
		} else if (path.toLowerCase().endsWith(".xml")) {
			myShapes = xmlSaver.Load(path);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Save format.");
			throw new RuntimeException("Invalid format");
		}
		panel.repaint();


	}


	@Override
	public java.util.List<Class<? extends Shape>> getSupportedShapes() {
		supportedShapes = new ArrayList<>();
		supportedShapes.add(Line.class);
		supportedShapes.add(Rectangle.class);
		supportedShapes.add(Square.class);
		supportedShapes.add(Circle.class);
		supportedShapes.add(Ellipse.class);
		supportedShapes.add(Triangle.class);
		return supportedShapes;
	}


}
