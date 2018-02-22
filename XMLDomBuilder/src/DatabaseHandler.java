
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Jay Kumar
 */
class DatabaseHandler {
    static Connection connection;
    
    static{
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }catch(Exception ex){
            
        }
    }
    public static void DBToXml(String dbPath, File destination)throws Exception{
        Connection connection= java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, null, null, new String[]{"TABLE"});
        
        // write the content into xml file
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
        ArrayList<String> list = new ArrayList();
        
        while(result.next()){
            String tableName=result.getString(3);
            System.out.println("<<< "+tableName+" >>>>");
                if(!list.contains(tableName)){
                    System.out.println("Entered");
                    list.add(tableName);
                    ArrayList columns = getColumnName(connection, tableName);
                    handleXML(connection,destination.getAbsolutePath() ,columns , tableName, transformer);
                
                }
        }
    }
    
        public static ArrayList<String> getColumnName(Connection conn , String tableName)throws Exception{
        String query ="SELECT * from "+tableName;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(query);
        ResultSetMetaData md = result.getMetaData();
        ArrayList<String> list = new ArrayList();
        for(int i=1;i<=md.getColumnCount();i++){
            list.add(md.getColumnName(i));
        }
        return list;
    }

    private static void handleXML(Connection connection, String destination, ArrayList columns, String tableName, Transformer transformer) throws  Exception{
        try {
 
                System.out.println(tableName);
            
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("xml");
		doc.appendChild(rootElement);
 
                System.out.println("doc : "+doc);
                System.out.println("doc : "+rootElement);
                
		String query = "SELECT * from "+tableName;
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
		
                
                while(rs.next()){
                    Element tableTag = doc.createElement(tableName);
                    rootElement.appendChild(tableTag);
 
                    for(int i=0;i<columns.size();i++){
                        Element attr = doc.createElement(columns.get(i).toString());
                        attr.appendChild(doc.createTextNode(rs.getString(columns.get(i).toString())));
                        tableTag.appendChild(attr);
                    }
                }
                
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(destination+"\\"+tableName+".xml"));
 
                System.out.println("transformer :"+transformer+" Result: "+result +"    source: "+source);
		// Output to console for testing
//		StreamResult result = new StreamResult(System.out);
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		System.err.println("Exception occured at: "+tableName);
	  } catch (TransformerException tfe) {
		System.err.println("Exception occured at: "+tableName);
	  }
    }
}
