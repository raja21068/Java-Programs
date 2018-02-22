
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ModifyXML{
    
    private static File xmlFile = new File("file.xml");
    private static DocumentBuilder builder;
    private static Document doc;
    
    public static void init()throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }
    
    public static void saveChanges()throws Exception{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);

        transformer.transform(source, result);
    }
    
    public static void write(String name, String rollno, String subject, String marks)throws Exception{
        init();
        Element students;
        
        if(!xmlFile.exists()){
            doc = builder.newDocument();
            
            Element rootElement = doc.createElement("school");
            doc.appendChild(rootElement);
            students = doc.createElement("students");
            rootElement.appendChild(students);
            
        }
            
        else{
            doc = builder.parse(xmlFile);
            
            Node rootNode = doc.getFirstChild();
            students = doc.createElement("students");
            rootNode.appendChild(students);
        }
            
            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            students.appendChild(nameElement);

            Element rollNoElement = doc.createElement("rollNo");
            rollNoElement.appendChild(doc.createTextNode(rollno));
            students.appendChild(rollNoElement);

            Element subjectElement = doc.createElement("subject");
            subjectElement.appendChild(doc.createTextNode(subject));
            students.appendChild(subjectElement);

            Element marksElement = doc.createElement("marks");
            marksElement.appendChild(doc.createTextNode(marks));
            students.appendChild(marksElement);

        
        saveChanges();
        
        
    }
    
    public static void delete(String name)throws Exception{
        
        if(xmlFile.exists()){
            init();
            doc = builder.parse(xmlFile);
            
            Node rootNode = doc.getFirstChild();
            NodeList list = rootNode.getChildNodes();
            
            for(int k=0 ; k<list.getLength() ; k++){
                Node studentNode = list.item(k);
                Node nameNode = studentNode.getFirstChild();
                if(nameNode.getTextContent().toLowerCase().equals(name.toLowerCase())){
                    rootNode.removeChild(studentNode);
                    break;
                }
            }
            
            saveChanges();
        }
        
        else
            System.out.println("File soes not exsists.");
        
    }
    
    public static void update(String oldName, String newName, String rollNo, String subject, String marks)throws Exception{
        if(xmlFile.exists()){
            init();
            doc = builder.parse(xmlFile);
            
            Node rootNode = doc.getFirstChild();
            NodeList list = rootNode.getChildNodes();
            
            for(int k=0 ; k<list.getLength() ; k++){
                Node studentNode = list.item(k);
                Node nameNode = studentNode.getFirstChild();
                if(nameNode.getTextContent().toLowerCase().equals(oldName.toLowerCase())){
                    Element newStudentNode = doc.createElement("students");
                    
                    Element nameElement = doc.createElement("name");
                    nameElement.appendChild(doc.createTextNode(newName));
                    newStudentNode.appendChild(nameElement);

                    Element rollNoElement = doc.createElement("rollNo");
                    rollNoElement.appendChild(doc.createTextNode(rollNo));
                    newStudentNode.appendChild(rollNoElement);

                    Element subjectElement = doc.createElement("subject");
                    subjectElement.appendChild(doc.createTextNode(subject));
                    newStudentNode.appendChild(subjectElement);

                    Element marksElement = doc.createElement("marks");
                    marksElement.appendChild(doc.createTextNode(marks));
                    newStudentNode.appendChild(marksElement);
                    
                    rootNode.replaceChild(newStudentNode, studentNode);
                    break;
                }
            }
            
            saveChanges();
        }
        
        else
            System.out.println("File soes not exsists.");
    }
    
    public static void showAll()throws Exception{
        if(xmlFile.exists()){
            init();
            doc = builder.parse(xmlFile);
            
            Node rootNode = doc.getFirstChild();
            NodeList list = rootNode.getChildNodes();
            
            for(int k=0 ; k<list.getLength() ; k++){
                Node studentNode = list.item(k);
                NodeList studentList = studentNode.getChildNodes();
                for(int i=0 ; i<studentList.getLength() ; i++){    
                    Node info = studentList.item(i);
                    System.out.println(info.getNodeName() + ": " + info.getTextContent());
                }
                System.out.println("*************************");
            }
        }
        else
            System.out.println(xmlFile.getName() + "does not exsists");
    }
    
}
