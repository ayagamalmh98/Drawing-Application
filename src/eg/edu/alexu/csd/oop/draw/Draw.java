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
import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;


public class Draw implements DrawingEngine {
	
	private List<Class<? extends Shape>> supportedShapes;
    public Stack<ArrayList<Shape>> undoStack, redoStack;
    public ArrayList<Shape> myShapes;
    public ArrayList<Shape> pluginShapes;
	private Panel panel;
    
    public Draw(Panel panel) {
        this.panel = panel;
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
		this.myShapes.add(shape);
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
        ArrayList<Shape> u = new ArrayList<>();
        myShapes.forEach((p) -> {
            try {
				u.add((Shape) p.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
        });
        undoStack.push((ArrayList<Shape>) u);
    }
	
	public void updateRedoStack() {
        ArrayList<Shape> u = new ArrayList<>();
        myShapes.forEach((p) -> {
            try {
				u.add((Shape) p.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
        });
        redoStack.push((ArrayList<Shape>) u);
    }
	
	public Drawshape findShape(int x, int y, boolean remove) {
        for (Shape p : myShapes) {
            if (p.c) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String path) {
	
	}

	@Override
	public void load(String path) {
		
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
