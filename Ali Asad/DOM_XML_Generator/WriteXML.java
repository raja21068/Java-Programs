
import java.io.File;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Aahil Mehboob
 */
public class WriteXML extends Thread{
    
    private String destinationPath;
    private String tableName;
    private Vector<String> columnNames;
    private Vector<String> data;
    private String dbName;
    
    WriteXML(String destinationPath, String dbName, String tableName, Vector<String> columnNames, Vector<String> data){
        this.destinationPath = destinationPath;
        this.dbName = dbName;
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.data = data;
    }
    
    public void run(){
        File file = new File(this.destinationPath + "\\" + this.tableName + ".xml");
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            
            Element rootElement = doc.createElement(dbName);
            doc.appendChild(rootElement);
            
            for(int k=0 ; k<data.size() ; k++){
                Element tableElement = doc.createElement(tableName);
                rootElement.appendChild(tableElement);
                
                String cols[] = data.elementAt(k).split(",");
                for(int i=0 ; i<columnNames.size() ; i++){
                    Element columnElement = doc.createElement(columnNames.elementAt(i));
                    columnElement.appendChild(doc.createTextNode(cols[i]));
                    tableElement.appendChild(columnElement);
                }
            }
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            
        }catch(Exception ex){ex.printStackTrace();}
    }
    
}
