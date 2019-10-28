package eg.edu.alexu.csd.oop.draw;



import java.awt.*;
import java.util.*;

import eg.edu.alexu.csd.oop.draw.Shapes.Line;

public abstract class Drawshape implements Shape {
	private double x1,x2,y1,y2;
	private Map<String, Double> properties;
	private Point position;
	private Color backColor, foreColor;
	private final ShapeTypes myShapeType;


	public Drawshape(ShapeTypes myShapeType, int x1, int y1, int x2, int y2, Color fore, Color back) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.foreColor = foreColor;
		this.backColor = backColor;
		this.myShapeType = myShapeType;
		properties = new HashMap<String, Double>();
		properties.put("foreColor", foreColor.getRGB() * 1.0);
		properties.put("backColor", backColor.getRGB() * 1.0);
		properties.put("x1", (double) x1);
		properties.put("y1", (double) y1);
		properties.put("x2", (double) x2);
		properties.put("y2", (double) y2);
	}
	
	
	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setColor(Color color) {
		properties.put("color", color.getRGB() * 1.0);
	}

	public Color getColor() {
		return new Color(properties.get("color").intValue());
	}

	public void setFillColor(Color color) {
		properties.put("fill_color", color.getRGB() * 1.0);

	}

	public Color getFillColor() {
		return new Color(getProperties().get("fill_color").intValue());
	}
	
	public abstract void draw(java.awt.Graphics canvas); // redraw the shape on the canvas

    public abstract Object clone() throws CloneNotSupportedException; 
	

}
