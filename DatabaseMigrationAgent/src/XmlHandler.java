
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Jay
 */
public class XmlHandler extends DefaultHandler{
     
    private ArrayList tags= new ArrayList();
    String table="";
    String filePath="";
    Hashtable tag = null;
    String tagName = "";
    SAXParserFactory factory = SAXParserFactory.newInstance();
        
    
    XmlHandler(String filePath){
        try{
        this.filePath = filePath;
        int dot = filePath.lastIndexOf(".");
        int slash = filePath.lastIndexOf("\\")+1;
        table = filePath.substring(slash,dot);
        
            SAXParser parser = factory.newSAXParser();
            parser.parse(filePath, this);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void startElement(String namespaceUri,String localName,String qualifiedName, Attributes attributes){
        tagName = qualifiedName;
        if(!qualifiedName.equals("xml")){
            if(qualifiedName.equals(table)){
                tag = new Hashtable();
            }
        }
        
    }
    
    @Override
    public void endElement(String namespace , String localName,String qualifiedName){
        if(qualifiedName.equals(table)){
            tags.add(tag);
           
        }
    }

    @Override
    public void characters(char[] chars,int startIndex,int length){
        String data = new String(chars, startIndex, length);
        //white space makes up default StringTokenizer delimeter
        StringTokenizer tok = new StringTokenizer(data);
        if(tok.hasMoreElements()){
             tag.put(tagName,tok.nextElement());
        }
            
    }
    
    public ArrayList getTags(){

        return tags;
    }
    
    public String getTable(){
        return table;
    }
    
}