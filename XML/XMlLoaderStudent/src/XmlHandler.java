
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Jay
 */
public class XmlHandler extends DefaultHandler{
     
    private ArrayList list= new ArrayList();
    String tag="";
    StudentBean bean = null;
    ArrayList<String> tags = new ArrayList<String>();
    
    @Override
    public void startElement(String namespaceUri,String localName,String qualifiedName, Attributes attributes){
        System.out.println("Start tag: " +qualifiedName);
        tag=qualifiedName;
        if(qualifiedName.equals("student")){
            bean = new StudentBean();
        }
        if(!qualifiedName.equals("xml")){
            if(!tags.contains(qualifiedName)){
                tags.add(qualifiedName);
            }
        }
        
    }
    
    @Override
    public void endElement(String namespace , String localName,String qualifiedName){
        
        tag="";
        if(qualifiedName.equals("student"))list.add(bean);
    }

    @Override
    public void characters(char[] chars,int startIndex,int length){
        String data = new String(chars, startIndex, length);
        //white space makes up default StringTokenizer delimeter
        StringTokenizer tok = new StringTokenizer(data);
        if(tok.hasMoreElements()){
            if(tag.equals("name")){ 
                bean.setName(tok.nextToken());
                System.out.println("Got name");
            }
            else if(tag.equals("subject")){
                bean.setSubject(tok.nextToken());
                System.out.println("Got subject");
            }
            else if(tag.equals("rollno")){
                bean.setRollno(tok.nextToken());
                System.out.println("Got rollno");
            }
            else if(tag.equals("marks")){ 
                bean.setMarks(tok.nextToken());
                System.out.println("Got marks");}
        }
    }
    
    public ArrayList<StudentBean> printOutline(String filename){

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = factory.newSAXParser();
            parser.parse(filename, this);
        }catch(Exception ex){
            String errorMessage = "Error parsing "+filename+": "+ ex;
            System.err.println(errorMessage);
            ex.printStackTrace();
        }
        return list;
    }
    
     public ArrayList<String> getAllTags(){
        return tags;
    }
}
