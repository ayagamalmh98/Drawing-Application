package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import eg.edu.alexu.csd.oop.draw.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.Shapes.Line;
import eg.edu.alexu.csd.oop.draw.Shapes.Rectangle;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.ShapeTypes;
import eg.edu.alexu.csd.oop.draw.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.Shapes.Triangle;


public class XML implements ILoadSave  {
    @Override
    public void Save(ArrayList<Drawshape> myShapes, String path) {
        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("root");
            doc.appendChild(root);

            Element count = doc.createElement("Count");
            count.appendChild(doc.createTextNode(myShapes.size() + ""));
            root.appendChild(count);

            Element memberList = doc.createElement("shapes");
            root.appendChild(memberList);

            myShapes.forEach((s) -> {
                Element member = doc.createElement("Shape");
                memberList.appendChild(member);

                Element shapeType = doc.createElement("Type");
                shapeType.appendChild(doc.createTextNode(s.getShapeType().toString()));
                member.appendChild(shapeType);

                Element shapeX1 = doc.createElement("X1");
                shapeX1.appendChild(doc.createTextNode(s.getX1() + ""));
                member.appendChild(shapeX1);

                Element shapeY1 = doc.createElement("Y1");
                shapeY1.appendChild(doc.createTextNode(s.getY1() + ""));
                member.appendChild(shapeY1);

                Element shapeX2 = doc.createElement("X2");
                shapeX2.appendChild(doc.createTextNode(s.getX2() + ""));
                member.appendChild(shapeX2);

                Element shapeY2 = doc.createElement("Y2");
                shapeY2.appendChild(doc.createTextNode(s.getY2() + ""));
                member.appendChild(shapeY2);

                Element shapeFore = doc.createElement("ForeColor");
                shapeFore.appendChild(doc.createTextNode(Integer.toString(s.getColor().getRGB()) + ""));
                member.appendChild(shapeFore);

                Element shapeBack = doc.createElement("BackColor");
                shapeBack.appendChild(doc.createTextNode(Integer.toString(s.getFillColor().getRGB()) + ""));
                member.appendChild(shapeBack);
            });
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);

            try (FileWriter file = new FileWriter(path)) {
                file.write(writer.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public ArrayList<Drawshape> Load(String path) {
        ArrayList<Drawshape> shapes = new ArrayList<>();
        try {

            File file = new File(path);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            int count = Integer.parseInt(document.getElementsByTagName("Count").item(0).getTextContent());

            for (int i = 0; i < count; i++) {
                ShapeTypes type = ShapeTypes.valueOf(document.getElementsByTagName("Type").item(i).getTextContent());
                switch (type) {
                    case Ellipse:
                        shapes.add(new Ellipse(Integer.parseInt(document.getElementsByTagName("X1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("X2").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y2").item(i).getTextContent()),
                                new Color(Integer.parseInt(document.getElementsByTagName("ForeColor").item(i).getTextContent())),
                                new Color(Integer.parseInt(document.getElementsByTagName("BackColor").item(i).getTextContent()))));
                        break;

                    case Triangle:
                        shapes.add(new Triangle(Integer.parseInt(document.getElementsByTagName("X1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("X2").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y2").item(i).getTextContent()),
                                new Color(Integer.parseInt(document.getElementsByTagName("ForeColor").item(i).getTextContent())),
                                new Color(Integer.parseInt(document.getElementsByTagName("BackColor").item(i).getTextContent()))));
                        break;

                    case Square:
                        shapes.add(new Square(Integer.parseInt(document.getElementsByTagName("X1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("X2").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y2").item(i).getTextContent()),
                                new Color(Integer.parseInt(document.getElementsByTagName("ForeColor").item(i).getTextContent())),
                                new Color(Integer.parseInt(document.getElementsByTagName("BackColor").item(i).getTextContent()))));
                        break;

                    case Rectangle:
                        shapes.add(new Rectangle(Integer.parseInt(document.getElementsByTagName("X1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("X2").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y2").item(i).getTextContent()),
                                new Color(Integer.parseInt(document.getElementsByTagName("ForeColor").item(i).getTextContent())),
                                new Color(Integer.parseInt(document.getElementsByTagName("BackColor").item(i).getTextContent()))));
                        break;

                    case Line:
                        shapes.add(new Line(Integer.parseInt(document.getElementsByTagName("X1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y1").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("X2").item(i).getTextContent()),
                                Integer.parseInt(document.getElementsByTagName("Y2").item(i).getTextContent()),
                                new Color(Integer.parseInt(document.getElementsByTagName("ForeColor").item(i).getTextContent())),
                                new Color(Integer.parseInt(document.getElementsByTagName("BackColor").item(i).getTextContent()))));
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shapes;
    }

}
