package eg.edu.alexu.csd.oop.draw;


import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eg.edu.alexu.csd.oop.draw.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.Shapes.Line;
import eg.edu.alexu.csd.oop.draw.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.Shapes.Triangle;

import eg.edu.alexu.csd.oop.draw.XML;

import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;
import eg.edu.alexu.csd.oop.draw.Shapes.RoundRectangle;


public class Draw implements DrawingEngine {

	private  XML xmlSaver;

	private List<Class<? extends Shape>> supportedShapes;
	public Stack<ArrayList<Drawshape>> undoStack, redoStack;
	public ArrayList<Drawshape> myShapes;
	public ArrayList<Drawshape> undo;
	public ArrayList<Shape> pluginShapes;
	private Panel panel;
	private boolean plug = false;
	
	public Draw() {
	}

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
		if(shape != null) {
			this.myShapes.add((Drawshape) shape);
		}
		
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
		if (path.toLowerCase().endsWith(".json")) {
			System.out.println(path);
			System.out.println(myShapes);
			Save(myShapes, path);
			//SaveJson save = new SaveJson();
			//save.save(path, myShapes);
		} else if (path.toLowerCase().endsWith(".xml")) {
			System.out.println(xmlSaver);
			xmlSaver.Save(myShapes, path);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Save format.");
			throw new RuntimeException("Invalid format");
		}
	}

	@Override
	public void load(String path) {
		if (path.toLowerCase().endsWith(".json")) {
			myShapes = Load(path);
		//	LoadJson load = new LoadJson();
			//myShapes = load.load(path, supportedShapes);
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
		supportedShapes.add(RoundRectangle.class);
		return supportedShapes;
	}
	
	@Override
	public void installPluginShape(String jarPath) {
		File file = new File(jarPath);

		try {
		    // Convert File to a URL
		    URL url = file.toURI().toURL();          // file:/c:/myclasses/
		    URL[] urls = new URL[]{url};

		    // Create a new class loader with the directory
		    ClassLoader cl = new URLClassLoader(urls);

		    // Load in the class; MyClass.class should be located in
		    // the directory file:/c:/myclasses/com/mycompany
		    Class cls = cl.loadClass("eg.edu.alexu.csd.oop.draw.Shapes.RoundRectangle");
		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		}
    }

	public void Save(ArrayList<Drawshape> myShapes, String path) {
		try {
			JSONObject obj = new JSONObject();
			JSONArray array = new JSONArray();

			for (Drawshape s : myShapes) {
				JSONObject ob = new JSONObject();
				ob.put("Type", ((Drawshape)s).getShapeType().toString());
				ob.put("X1", ((Drawshape)s).getProperties().get("x1"));
				ob.put("Y1", ((Drawshape)s).getProperties().get("y1"));
				ob.put("X2", ((Drawshape)s).getProperties().get("x2"));
				ob.put("Y2", ((Drawshape)s).getProperties().get("y2"));
				ob.put("ForeColor", Integer.toString(s.getColor().getRGB()));
				ob.put("BackColor", Integer.toString(s.getFillColor().getRGB()));
				array.put(ob);
			}
			obj.put("Shapes", array);

			try (FileWriter file = new FileWriter(path)) {
				file.write(obj.toString());
				file.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
		String content = new String(Files.readAllBytes(Paths.get(filename)));
		return new JSONObject(content);
	}

	public ArrayList<Drawshape> Load(String fileDest) {
		ArrayList<Drawshape> shapes = new ArrayList<>();
		try {
			JSONObject jsonObject = parseJSONFile(fileDest);
			JSONArray arr = jsonObject.getJSONArray("Shapes");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject j = arr.getJSONObject(i);
				ShapeTypes type = ShapeTypes.valueOf(j.getString("Type"));
				switch (type) {
				case Ellipse:
					shapes.add(new Ellipse(j.getInt("X1"),
							j.getInt("Y1"),
							j.getInt("X2"),
							j.getInt("Y2"),
							new Color(j.getInt("ForeColor")),
							new Color(j.getInt("BackColor"))));
					break;

				case Triangle:
					shapes.add(new Triangle(j.getInt("X1"),
							j.getInt("Y1"),
							j.getInt("X2"),
							j.getInt("Y2"),
							new Color(j.getInt("ForeColor")),
							new Color(j.getInt("BackColor"))));
					break;

				case Square:
					shapes.add(new Square(j.getInt("X1"),
							j.getInt("Y1"),
							j.getInt("X2"),
							j.getInt("Y2"),
							new Color(j.getInt("ForeColor")),
							new Color(j.getInt("BackColor"))));
					break;

				case Rectangle:
					shapes.add(new Rectangle(j.getInt("X1"),
							j.getInt("Y1"),
							j.getInt("X2"),
							j.getInt("Y2"),
							new Color(j.getInt("ForeColor")),
							new Color(j.getInt("BackColor"))));
					break;

				case Line:
					shapes.add(new Line(j.getInt("X1"),
							j.getInt("Y1"),
							j.getInt("X2"),
							j.getInt("Y2"),
							new Color(j.getInt("ForeColor")),
							new Color(j.getInt("BackColor"))));
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shapes;
	}

	
	
}
