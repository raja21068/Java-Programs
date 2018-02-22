import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
/**
 * @author Jay
 */
public class PrintHandler extends DefaultHandler{
    private int indentation=0;
    
    
    public void startElement(String namespaceUri,String localName,String qualifiedName, Attributes attributes){
        System.out.println("Start tag: " +qualifiedName);
        int numAtributes = attributes.getLength();
        
        //for <LikeThisTag> just print that "LikeThisTag"
        // but <LikeThis attribut1="Hello" attribute2="Java">
        // it will print LikeThis (attribut1=Hello attribute2=Java)
        if(numAtributes>0){
            System.out.println("(");
            for(int i=0;i<numAtributes;i++){
                if(i>0){
                    System.out.println(", ");
                }
                System.out.println(attributes.getQName(i)+"="+attributes.getValue(i));
            }
            System.out.println(")");
        }
        System.out.println();
        indentation +=2;
    }
    
    public void endElement(String namespace , String localName,String qualifiedName){
        indentation-=2;
        indent(indentation);
    }
    
    
    private void indent(int identation){
        for(int i=0;i<identation;i++){
            System.out.print(" ");
        }
    }
    
    public void characters(char[] chars,int startIndex,int length){
        String data = new String(chars, startIndex, length);
        //white space makes up default StringTokenizer delimeter
        StringTokenizer tok = new StringTokenizer(data);
        if(tok.hasMoreElements()){
            indent(indentation);
            System.out.print(tok.nextToken());
            if(tok.hasMoreTokens()){
                System.out.println("...");
            }else{
                System.out.println();
            }
        }
    }
    public static void main(String arg[]){
        String jaxpPropertyName = "javax.xml.parsers.SAXParserFactory";
        //pass the parser factory in on the command line with -D to override the use of the Apache parser.
        
        if(System.getProperty(jaxpPropertyName)==null){
            System.out.println(jaxpPropertyName+" not found");
//            String apacheXercesPropertyValue="org.apache.xerces.jaxp.SAXParserFactoryImpl";
//            System.setProperty(jaxpPropertyName, apacheXercesPropertyValue);
        }
        
        String filename="";
        if(arg.length > 0){
            filename = arg[0];
        }
        else{
            filename = "Test.xml";
//            String[] extensions = {"xml" , "tld"};
//            WindowUtilities.setNativeLookAndFeel();
//            filename = ExtensionFileFilter.getFileName(".","XML Files" ,extensions);
//            if(filename==null){
//                filename = "text.xml";
//            }
        }
        printOutline(filename);
        System.exit(0);
    }
    
    public static void printOutline(String filename){
        DefaultHandler handler = new PrintHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = factory.newSAXParser();
            parser.parse(filename, handler);
        }catch(Exception ex){
            String errorMessage = "Error parsing "+filename+": "+ ex;
            System.err.println(errorMessage);
            ex.printStackTrace();
        }
    }
}
