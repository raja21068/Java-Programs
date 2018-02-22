import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet{
	private static String UPLOAD_DIRECTORY = "upload";
        private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
        private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
        private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
		
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in UploadServlet");
		PrintWriter out = res.getWriter();
		
		String path = getServletContext().getRealPath("");
        UPLOAD_DIRECTORY = path +"/upload"; 
        System.out.println("File Directory: "+UPLOAD_DIRECTORY);
            
        System.out.println("DiskFileItemFactory");			
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        System.out.println("ServletFileUpload");
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
		
		try{
			List formItems = upload.parseRequest(req);
            System.out.println("Size of List: "+formItems.size());
            
			//Having all the parameters and binary data info
			Iterator iter = formItems.iterator();
			
			String customerId=((FileItem) iter.next()).getString();
			String areaId=((FileItem) iter.next()).getString();
			String propertyType=((FileItem) iter.next()).getString();
			String forWhat=((FileItem) iter.next()).getString();
			String areaSquareFeet=((FileItem) iter.next()).getString();
			String story=((FileItem) iter.next()).getString();
			String rooms=((FileItem) iter.next()).getString();
			String kitchen=((FileItem) iter.next()).getString();
			String location=((FileItem) iter.next()).getString();
			String propertyAddress=((FileItem) iter.next()).getString();
			String price=((FileItem) iter.next()).getString();
			String description=((FileItem) iter.next()).getString();
			
			int propsId = DatabaseManager.addPropertyDetail(Integer.parseInt(areaId), areaSquareFeet, story, rooms, kitchen, propertyType, location, price, DateFormatter.dateToString(new java.util.Date() , "yyyy-MM-dd"), description, forWhat, propertyAddress, Integer.parseInt(customerId));
			
			System.out.println("PrpertydetailId: "+propsId);
			int maxId = DatabaseManager.getMaxMediaId();
			while(iter.hasNext()){
				FileItem item = (FileItem) iter.next();
				
				//getting the file Format because we have to give our own name to picture
				String fileName = new File(item.getName()).getName();
				String fileFormat = fileName.substring(fileName.lastIndexOf("."),fileName.length());
				
                //this is actuall path is computer
                String realPath = UPLOAD_DIRECTORY+File.separator+(maxId++)+fileFormat ;
                System.out.println("reslPath: "+realPath);
                DatabaseManager.addMediaDetail(propsId,(maxId++)+fileFormat );
                File storeFile = new File(realPath);

                System.out.println("saves the file on disk");
                // saves the file on disk
                item.write(storeFile);
				
			}
			
			out.println("<h1>Your Prpperty will be posted soon...!</h1>");
			out.println("<a href='home.html'>Home</a>");
			
		}catch(Exception ex){ex.printStackTrace(res.getWriter());}
	}
	
}
