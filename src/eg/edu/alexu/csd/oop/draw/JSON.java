package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
import paint.controller.JSONArray;
import paint.controller.JSONException;
import paint.controller.JSONObject;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.Rectangle;
import paint.model.Shape;
import paint.model.ShapeTypes;
import paint.model.Square;
import paint.model.Triangle;

public class JSON {
	 
	    public void Save(ArrayList<Shape> myShapes, String path) {
	        try {
	            JSONObject obj = new JSONObject();
	            JSONArray array = new JSONArray();

	            for (Shape s : myShapes) {
	                JSONObject ob = new JSONObject();
	                ob.put("Type", s.getShapeType().toString());
	                ob.put("X1", s.getX1());
	                ob.put("Y1", s.getY1());
	                ob.put("X2", s.getX2());
	                ob.put("Y2", s.getY2());
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

	    @Override
	    public ArrayList<Shape> Load(String fileDest) {
	        ArrayList<Shape> shapes = new ArrayList<>();
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
*/
