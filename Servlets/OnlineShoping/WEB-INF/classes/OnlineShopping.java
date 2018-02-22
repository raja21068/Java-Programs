import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class OnlineShopping extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
        private static String UPLOAD_DIRECTORY = "images";
        private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
        private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
        private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
      
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
				
		getData(req, res);
                
	
	}
        
        private void getData(HttpServletRequest req, HttpServletResponse res){
            
             // constructs the directory path to store upload file
            String path = getServletContext().getRealPath("");
            UPLOAD_DIRECTORY = path +"/images"; 
            System.out.println("File Directory: "+UPLOAD_DIRECTORY);
            
            System.out.println("DiskFileItemFactory");			
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(THRESHOLD_SIZE);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            System.out.println("ServletFileUpload");
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(REQUEST_SIZE);


            try {
                    System.out.println("parses the request's content to extract file data");
                    // parses the request's content to extract file data
                
                    List formItems = upload.parseRequest(req);
                    System.out.println("Size of List: "+formItems.size());
                    Iterator iter = formItems.iterator();

                    System.out.println("iterates over form's fields");
                    int i=1;
                    java.util.ArrayList list = new java.util.ArrayList(); 
                    
                    // iterates over form's fields
                    while (iter.hasNext()) {
                            FileItem item = (FileItem) iter.next();
                            System.out.println(i++);
                            
                            list.add(item.getString());
                                if(item.getString().equals("addform")){
                                    System.out.println("\n\nEntered in add form condition");
                                    addVehical(iter , res.getWriter());
                                    break;
                                }
                                System.out.println("Iterstive value: "+item.getString());
//                            }
                    }//end of while
                    
                    String identify=(String)list.get(0);
                    System.out.println("Identify: "+identify);
                    if(identify.equals("signup")){
                        addUser(list, res.getWriter());
                    }else if(identify.equals("login")){
                        loginAccount(list , res.getWriter());
                    
                    }else if(identify.equals("search")){
                        searching(list,res.getWriter());
                    }else if(identify.equals("requestsearch")){
                        requestSearching(res.getWriter());
                    }else if(identify.equals("addnew")){
                        String id =(String) list.get(1);
                        System.out.println("request for showing the add new vehicle form where user id is: "+id);
                        printAddForm(res.getWriter(),Integer.parseInt(id));
                    }else if(identify.equals("remove")){
                        removeVehicle(list , res.getWriter());
                    }else if(identify.equals("view")){
                        viewVehicle(list , res.getWriter());
                    }else if(identify.equals("accountHome")){
                        printAccountHome(res.getWriter(), Integer.parseInt((String)list.get(1)));
                    }
                    
                    
                         
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
	
	}
        private void loginAccount(java.util.ArrayList list, PrintWriter out)throws Exception{
            String user = (String) list.get(1);
            String pass =(String) list.get(2);
            System.out.println("User:"+user+" : Password:"+pass);
            int id = DatabaseManager.login(user, pass);
            if(id<1){
                printInvalidLoginData(out);
            }else{
                printAccountHome(out, id);
                
            }
        }
        
        private void addUser(java.util.ArrayList list,PrintWriter out){
        
            String first =(String) list.get(1);
            String last =(String) list.get(2);
            String email =(String) list.get(3);
            String user =(String) list.get(4);
            String pass =(String) list.get(5);
            String address =(String) list.get(6);
            String contact =(String) list.get(7);
            String city =(String) list.get(8);
            String state =(String) list.get(9);
            String country =(String) list.get(10);
            
            try{
                if(!DatabaseManager.isEmailExist(email)){
                    int id = DatabaseManager.addUsers(first, last, email, pass, user, address, contact, city, state, country);
                    printAddForm(out,id);
                }else {
                     
                }
            }
            catch(Exception ex){ex.printStackTrace();}
            System.out.println(""+first+""+last+""+email+""+user+""+pass+""+address+""+contact+""+city+""+state+""+country);
        }
        
        
        private void printAddForm(PrintWriter out , int id)throws Exception {
        
             out.println("<html>");
             printMenu(out);
		out.println(" <form enctype='multipart/form-data'  action='OnlineShopping' method=post>");
			
		out.println("	<input type='hidden' name='identify' value='addform'/>");
		out.println("	<input type='hidden' name='identify' value='"+id+"'/>");
			
		out.println("	Company Make");
		out.println("	<select name='company' size=1>");
			out.println("	<option value=''>No Answer</option>");
		out.println("		<option value='SUZUKI'>Suzuki</option>");
		out.println("		<option value='TOYOTA'>Toyaota</option>");
		out.println("		<option value='BMW'>BMW</option>");
		out.println("		<option value='HONDA'>Honda</option>");
		out.println("	</select>");
		out.println("	<br />");
			
		out.println("	Vehical Name");
		out.println("	<input type='text' name='vehicalName' required='required'/>");
		out.println("	<br />");
			
		out.println("	Vehical Type");
		out.println("	<select name='vehicaltype' size=1>");
			out.println("	<option value=''>No Answer</option>");
			out.println("	<option value='BIKE'>Bike</option>");
			out.println("	<option value='CAR'>Car</option>");
			out.println("	<option value='JEEP'>Jeep</option>");
			out.println("	<option value='TRACTOR'>Tractor</option>");
		out.println("		<option value='TRUCK'>Truck</option>");
		out.println("	</select>");
		out.println("	<br />");
		
                java.util.ArrayList<Integer> years= DatabaseManager.getAllYears();
                
		out.println("	Model Year");
		out.println("	<select name='modelyear' size=1>");
			out.println("	<option value=''>No Answer</option>");
			for(int i=0;i<years.size();i++){
                    out.println("<option value='"+years.get(i)+"'>"+years.get(i) +"</option>");
                }
		out.println("	</select><br />");
           
		out.println("	Color");
		out.println("	<select name='color' size=1>");
		out.println("		<option value=''>No Answer</option>");
		out.println("		<option value='RED'>Red</option>");
		out.println("		<option value='WHITE'>White</option>");
		out.println("		<option value='BLACK'>Black</option>");
		out.println("		<option value='BROWN'>Brown</option>");
		out.println("	</select>");
			
		out.println("	<br />");
		out.println("	Registered Year");
		out.println("	<select name='registeryear' size=1>");
                
                //getting all years from database
                
		for(int i=0;i<years.size();i++){
                    out.println("<option value='"+years.get(i)+"'>"+years.get(i) +"</option>");
                }
		out.println("	</select>");
			
		out.println("	<br />");
			
		out.println("	Registeration City");
		out.println("	<input type='text' name='REGIDTERCITY' required='required' />");
		out.println("	<br />");
			
		out.println("	Demand Price:");
		out.println("<input type='text' name='PRICE' required='required' />Rs");
		out.println("<br />");
			
		out.println("AC");
		out.println("<select name='AC' size=1>");
		out.println("<option value='yes'>Yes</option>");
		out.println("<option value='no'>No</option>");
		out.println("</select><br /> ");
			
		out.println("Fule Type");
		out.println("<select name='FULE' size=1>");
		out.println("<option value=''>No Answer</option>");
		out.println("<option value='PETROL'>Petrol</option>");
		out.println("<option value='CNG'>CNG</option>");
		out.println("<option value='PETROL+CNG'>Petrol+CNG</option>");
		out.println("<option value='DIESEL+CNG'>Diesel+CNG</option>");
		out.println("<option value='DIESEL'>Diesel</option>");
		out.println("</select><br /> ");
			
		out.println("PowerWindow");
		out.println("<select name='POWERWINDOW' size=1>");
		out.println("<option value='yes'>Yes</option>");
		out.println("<option value='no'>No</option>");
		out.println("</select><br /> ");
			
		out.println("Transmission");
		out.println("<select name='TRANSMISSION' size=1>");
		out.println("<option value=''>No Answer</option>");
		out.println("<option value='AUTO'>AUTO</option>");
		out.println("<option value='NORMAL'>NORMAL</option>");
		out.println("</select><br /> ");
                
		out.println("EngineType<input type='text' name='ENGINETYPE' ><br >");	
		
                out.println("Condition");
		out.println("<select name='CONDITION' size=1>");
		out.println("<option value='USED'>Used</option>");
		out.println("<option value='NEW'>New</option>");
                out.println("</select><br />"); 

			
		out.println("Mileage");
		out.println("<input type='text' name='MILEAGE' /><br />");
			
		out.println("Door Count");
		out.println("<select name='DOORS'>");
		out.println("<option name=''>No answer</option>");
		out.println("<option name='2'>2-door</option>");
		out.println("<option name='4'>4-door</option>");
		out.println("</select><br /> ");
		
		out.println("Remarks");
		out.println("<input type='text' name='REMARKS' required='required' /><br />");
		
		out.println("Pictures");
		out.println("<input type='file' name='dataFile' id='fileChooser'  multiple='multiple'/>");
		out.println("<br />");
			
		out.println("<input type='submit' value='Upload' />");
			
		out.println("</form>");
                out.println("</body>");
        }
        
        private void printInvalidLoginData(PrintWriter out){
            
            out.println("<html>");
            
            printMenu(out);
                
            out.println("<form enctype=\"multipart/form-data\" action='OnlineShopping' method='post' >");
            out.println("<h1 align='center'>Sign In</h1>");
            out.println("<h2 style='color:red'>Invalid user or password, If you are new your pleasse sign up..</h2>");
            out.println("<input type='hidden' name='identify' value='login'  />");
            out.println("User");
            out.println("<input type='text' name='user' required='required'/><br />");
            out.println("Password");
            out.println("<input type='password' name='pass' required='required' /><br />");
            out.println("<input type='submit' value='Log In' />");
            out.println("<a href='/signup.html'>SignUp</a>");

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        
        }//end of printInvalidLoginData
        
        
        private void addVehical(Iterator iter,PrintWriter out)throws Exception{
            
            FileItem item = (FileItem) iter.next();
            int id = Integer.parseInt(item.getString());
            System.out.println("Id: "+id);
            String company =((FileItem) iter.next()).getString();
            String vehicalname =((FileItem) iter.next()).getString();
            String vehicaltype =((FileItem) iter.next()).getString();
            String modelyear =((FileItem) iter.next()).getString();
            String color =((FileItem) iter.next()).getString();
            String regisyear =((FileItem) iter.next()).getString();
            String regiscity =((FileItem) iter.next()).getString();
            String price =((FileItem) iter.next()).getString();
            String ac =((FileItem) iter.next()).getString();
            String fule =((FileItem) iter.next()).getString();
            String powerwindow =((FileItem) iter.next()).getString();
            String transmission =((FileItem) iter.next()).getString();
            String enginetype =((FileItem) iter.next()).getString();
            String condition =((FileItem) iter.next()).getString();
            String mileage =((FileItem) iter.next()).getString();
            String door =((FileItem) iter.next()).getString();
            String remarks =((FileItem) iter.next()).getString();
            
            
            int vehicleid = DatabaseManager.addVehicle(id, company, vehicalname, vehicaltype, modelyear, color, regisyear, regiscity, price, BooleanConvert.toBoolean(ac), fule, BooleanConvert.toBoolean(powerwindow ), transmission, condition, mileage, door, enginetype, remarks,DateFormatter.dateToStringMonthFormat( new java.util.Date()));
            
            // creates the directory if it does not exist
            File uploadDir = new File(UPLOAD_DIRECTORY+File.separator+vehicleid);
            System.out.println(uploadDir.getAbsolutePath());
            if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
            }
            
            //saves all the uploaded file
            while(iter.hasNext()){
                
                item = (FileItem) iter.next();
                
                //this stores the file name
                String fileName = new File(item.getName()).getName();
                System.out.println("FileName: "+fileName);
                
                //this is filepath stored in database
                String filePath = "/"+vehicleid+"/"+ fileName;
                System.out.println("FilePath: "+filePath);
                
                //this is actuall path is computer
                String realPath = UPLOAD_DIRECTORY + File.separator+vehicleid+File.separator+ fileName;
                System.out.println("reslPath: "+realPath);
                DatabaseManager.addPicture(vehicleid, filePath, remarks);
                File storeFile = new File(realPath);

                System.out.println("saves the file on disk");
                // saves the file on disk
                item.write(storeFile);
            }//end of while
            printAccountHome(out, id);
//            out.println("<frameset>"
//                    + "<frame src='car.html'></frame>"
//                    + "</frameset>");
        }
        
        private void searching(java.util.ArrayList list,PrintWriter out)throws Exception{
            System.out.println("Entered in searching...");
            for(int i=1;i<=10;i++){
                System.out.println(list.get(i));
            }
            String company =(String) list.get(1);
            String modelYear =(String) list.get(2);
            String vehicalType =(String) list.get(3);
            String vehicalName =(String) list.get(4);
            String color =(String) list.get(5);
            String regiscity =(String) list.get(6);
            String price =(String) list.get(7);
            String ac =(String) list.get(8);
            String window =(String) list.get(9);
            String transmission =(String) list.get(10);
            String acQuery="";
            
            //cheking ac
            if(!ac.isEmpty()){
                if(BooleanConvert.toBoolean(ac)){
                    acQuery="AND ac=true";
                }else{
                    acQuery="AND ac=false";
                }
            }
            
            // checking price if price is not defined by client
            if(price==null || price.isEmpty()){
                price="(SELECT Max(price_demand) from vehicle)";
            }
            
            java.util.ArrayList<VehicleDataBean> vehicleData= DatabaseManager.getAllVehicle(company, modelYear, vehicalType, vehicalName, color, regiscity, price, window, transmission, acQuery);
            out.println("<html>");
            printMenu(out);
            for(int i=0;i<vehicleData.size();i++){
                VehicleDataBean bean = vehicleData.get(i);
                System.out.println("vehicle bean got to retrive pictures from database");
                java.util.ArrayList pictures = DatabaseManager.getAllPictures(bean.getVehicalId());
                System.out.println(" got pictures from database");
                for(int j=0;j<pictures.size();j++){
                  PictureBean pic =(PictureBean) pictures.get(j);
                   out.println("<img src='/OnlineShoping/images"+pic.getPicturePath()+"' width=200 height=200>");
                    System.out.println("<img src='/OnlineShoping/images"+pic.getPicturePath()+"' width=400 height=200>");
                    
                }
                out.print("<table>");
                if(bean.getCompanyMake()!=null) {
                    out.println("<tr><td><u>Car:</u></td><td> "+bean.getCompanyMake().toUpperCase()+"</td></tr>");
                }
                if(bean.getColor()!=null) {
                    out.println("<tr><td><u>Color:</u> </td><td>"+bean.getColor().toUpperCase()+"</td></tr>");
                }
                if(bean.getCondition()!=null) {
                    out.println("<tr><td><u>Condition:</u> </td><td>"+bean.getCondition().toUpperCase()+"</td></tr>");
                }
                if(bean.getCity()!=null) {
                    out.println("<tr><td><u>City:</u> </td><td>"+bean.getCity().toUpperCase()+"</td></tr>");
                }
                if(bean.getContactNo()!=null) {
                    out.println("<tr><td><u>Contact:</u></td><td> "+bean.getContactNo()+"</td></tr>");
                }
                if(bean.getDoorCount()!=null) {
                    out.println("<tr><td><u>Doors:</u> </td><td>"+bean.getDoorCount().toUpperCase()+"</td></tr>");
                }
                if(bean.getEmail()!=null) {
                    out.println("<tr><td><u>Email:</u> </td><td>"+bean.getEmail()+"</td></tr>");
                }
                if(bean.getEngineType()!=null) {
                    out.println("<tr><td><u>Engine Type:</u> </td><td>"+bean.getEngineType()+"</td></tr>");
                }
                if(bean.getFuleType()!=null) {
                    out.println("<tr><td><u>Fule Type:</u> </td><td>"+bean.getFuleType()+"</td></tr>");
                }
                if(bean.getMileage()!=null) {
                    out.println("<tr><td><u>Mileage:</u> </td><td>"+bean.getMileage()+"</td></tr>");
                }
                if(bean.getModelYear()!=null) {
                    out.println("<tr><td><u>Model Year:</u> </td><td>"+bean.getModelYear()+"</td></tr>");
                }
                out.println("<tr><td><u>Price Demand:</u> </td><td>"+bean.getPriceDemand()+"</td></tr>");
                if(bean.getRegisteredCity()!=null) {
                    out.println("<tr><td><u>Registered City:</u> </td><td>"+bean.getRegisteredCity()+"</td></tr>");
                }
                if(bean.getRegisteredYear()!=null) {
                    out.println("<tr><td><u>Registered Year:</u> </td><td>"+bean.getRegisteredYear()+"</td></tr>");
                }
                if(bean.getTransmission()!=null) {
                    out.println("<tr><td><u>Transmission</u> </td><td>"+bean.getTransmission()+"</td></tr>");
                }
                if(bean.getUserName()!=null) {
                    out.println("<tr><td><u>Owner Name</u> </td><td>"+bean.getUserName()+"</td></tr>");
                }
                out.print("</table>");
                out.println("<hr>");
            }
            //out.println("<img src='/carsimage/creative.jpg' width=400 height=200>");
            
           out.println("</body>");
           out.println("</html>");
        }

    private void requestSearching(PrintWriter out)throws Exception {
        System.out.println("Entered in Request for searching..");
        
        java.util.ArrayList<String> cities = DatabaseManager.getAllRegisteredCities();
        java.util.ArrayList<Integer> years = DatabaseManager.getAllYears(); 
        
        out.println("<html>");
                printMenu(out);
                out.println( "<form enctype='multipart/form-data'  action='servlet/OnlineShopping' method=post>"
                + "<table>"
                + "<input type='hidden' name='identify' value='search'/>	"
                + "<tr><td>Company Make</td>"
                + "	<td><select name='company' size=1>"
                + "		<option value=''>All</option>"
                + "		<option value='SUZUKI'>Suzuki</option>"
                + "		<option value='TOYOTA'>Toyaota</option>"
                + "		<option value='BMW'>BMW</option>"
                + "		<option value='HONDA'>Honda</option>"
                + "	</select></td></tr>"
                
                + "     <tr><td>Model Year</td>"
                + "	<td><select name='modelyear' size=1>"
                + "		<option value=''>All</option>");
                for(int i=0;i<years.size();i++){
                    out.println("		<option value='"+years.get(i)+"'>"+years.get(i) +"</option>");
                }
                out.println( "	</select></td></tr>"
                
                + "     <tr><td>Vehical Type</td>"
                + "	<td><select name='type'>"
                + "		<option value=''>All</option>"
                + "		<option value='BIKE'>Bike</option>"
                + "		<option value='CAR'>Car</option>"
                + "		<option value='JEEP'>Jeep</option>"
                + "		<option value='TRACTOR'>Tractor</option>"
                + "		<option value='TRUCK'>Truck</option>	"
                + "	</select></td></tr>"
                
                + "     <tr><td>Vehical Name</td>"
                + "	<td><input type='text' name='VEHICALTYPE'/></td></tr>"
                
                + "	<tr><td>Color</td>"
                + "	<td><select name='color' size=1>"
                + "		<option value=''>All</option>"
                + "		<option value='RED'>Red</option>"
                + "		<option value='WHITE'>White</option>"
                + "		<option value='BLACK'>Black</option>"
                + "		<option value='BROWN'>Brown</option>"
                + "		<option value='GRAY'>Gray</option>"
                + "		<option value='YELLOW'>Yellow</option>"
                + "	</select></td></tr>"
                
                + "	<tr><td>Registeration City</td>"
                + "     <td><select name='registercity'>"
                        + "<option value =''>All</option>");
                for(int i=0;i<cities.size();i++){
                    out.println( "	<option value ='"+cities.get(i) +"'>"+cities.get(i) +"</option>");
                }
               out.println( "</select></td></tr>"
                
                + "	<tr><td>Demand Price:</td>"
                + "	<td><input type='text' name='PRICE' />Rs</td></tr>"
                
                + "	<tr><td>AC</td>"
                + "	<td><select name='ac' size=1>"
                + "		<option value=''>All</option>"
                + "		<option value='yes'>Yes</option>"
                + "		<option value='no'>No</option>"
                + "	</select></td></tr>"
                
                + "	<tr><td>PowerWindow</td>"
                + "	<td><select name='powerwindow' size=1>"
                + "		<option value=''>All</option>"
                + "		<option value='yes'>Yes</option>"
                + "		<option value='no'>No</option>"
                + "	</select></td></tr>"
                
                + "	<tr><td>Transmission</td>"
                + "	<td><select name='transmission' size=1>"
                + "		<option value=''>All</option>"
                + "		<option value='auto'>auto</option>"
                + "		<option value='normal'>normal</option>"
                + "	</select></td></tr>"
                
                + "	<tr><td rowspan=2><input type='submit'  value='Search'/></td></tr>"
                + "</table>"
                + "</form>"
                + "</body>"
                + "</html>");
    }

    private void printAccountHome(PrintWriter out, int id)throws Exception{
        java.util.ArrayList<VehicleBean> list = DatabaseManager.getAllVehicles(id);
        System.out.println(list.size() +" items has been fetched from vehicle data of user id : "+id);
        
        out.println("<html>");
        printMenu(out);
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<td>Remove</td>");
        out.println("<td>View</td>");
        out.println("<td>Car Name</td>");
        out.println("<td>Model</td>");
        out.println("<td>Price</td>");
        out.println("</tr>");
        
        for(int i=0;i<list.size();i++){
            VehicleBean bean = list.get(i);
            out.println("<td><form enctype='multipart/form-data' action='OnlineShopping' method='post'>"
                    + "<input type='hidden' name='identify' value='remove'>"
                    + "<input type='hidden' name='vehicleId' value='"+bean.getVehicalId()+"'>"
                    + "<input type='hidden' name='userId' value='"+id+"'>"
                    + "<input type='image' name='submit' src='/OnlineShoping/images/remove.png'> "
                    + "</form></td>");
            out.println("<td>"
                    + "<form enctype='multipart/form-data' action='OnlineShopping' method='post'>"
                    + "<input type='hidden' name='identify' value='view'>"
                    + "<input type='hidden' name='vehicleId' value='"+bean.getVehicalId()+"'>"
                    + "<input type='hidden' name='userId' value='"+id+"'>"
                    + "<input type='image' name='submit' src='/OnlineShoping/images/edit.png'> "
                    + "</form>"
                    + "</td>");
            out.println("<td>"+bean.getVehicalName()+"</td>");
            out.println("<td>"+bean.getModelYear()+"</td>");
            out.println("<td>"+bean.getPriceDemand()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<form enctype='multipart/form-data' action='OnlineShopping' method='post'>");
        out.println("<input type='hidden' name='identify' value='addnew'>");
        out.println("<input type='hidden' name='userId' value='"+id+"'>");
        out.println("<input type='submit' value='Add New Vehical'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
    
    private void printMenu(PrintWriter out){
        out.println( "  <head>"
                + "<style>"
                + "ul{"
                + "	background-color: purple;"
                + "	padding-top: 10px;"
                + "	padding-botton: 10px;"
                + "}"
                + "li{"
                + "	display: inline;"
                + "	padding-right: 10px;"
                + "}"
                + "li > a{"
                + "	color: white;"
                + "	text-decoration: none;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<img src='/OnlineShoping/images/logo.jpg' width=30% height=10%> "
                + "<ul>"
                + "		<li><a href='/OnlineShoping/car.html'>Home</a></li>"
                + "		<li><a href='/OnlineShoping/about.html'>About</a></li>"
                + "             <li><a href='/OnlineShoping/login.html'>Sign In</a></li>"
                + "	</ul>");
    }

    private void removeVehicle(ArrayList list, PrintWriter out)throws Exception {
        System.out.println("Entered in removing process...");
        
        int id = Integer.parseInt((String)list.get(1));
        System.out.println("got the vehicle id for removing "+id);
        
        DatabaseManager.deleteVehicle(id);
        System.out.println("deleted from database");
        
        String deleted =UPLOAD_DIRECTORY+File.separator+id;
        File file = new File(deleted);
        System.out.println("File exist "+file.exists());
        if(file.exists()){
        File[] f = file.listFiles();
            for(int i=0;i<f.length;i++){
                System.out.println("loop");
                if(f[i].delete()){
                    System.out.println("File is deleted.. ");
                }
            }
        }        
        int userId = Integer.parseInt((String)list.get(2));
        System.out.println("diverting request for home page where user id "+userId);
        printAccountHome(out,userId);
    }

    private void viewVehicle(ArrayList list, PrintWriter out)throws Exception {
        System.out.println("View Vehicle");
        
        int vehicleId = Integer.parseInt((String)list.get(1));
        System.out.println("got the vehicle id "+vehicleId);
        
        int userId = Integer.parseInt((String)list.get(2));
        System.out.println("user id "+userId);
        
        VehicleBean bean= DatabaseManager.getVehicle(vehicleId);
        java.util.ArrayList pictures = DatabaseManager.getAllPictures(bean.getVehicalId());
        System.out.println(" got pictures from database");
        
        for(int j=0;j<pictures.size();j++){
            PictureBean pic =(PictureBean) pictures.get(j);
            out.println("<img src='/OnlineShoping/images"+pic.getPicturePath()+"' width=200 height=200>");
            System.out.println("<img src='/OnlineShoping/images"+pic.getPicturePath()+"' width=400 height=200>");
                    
        }
        
        out.print("<table>");
                    out.println("<tr><td><u>Car:</u></td><td> "+bean.getCompanyMake().toUpperCase()+"</td></tr>");
                    out.println("<tr><td><u>Color:</u> </td><td>"+bean.getColor().toUpperCase()+"</td></tr>");
                    out.println("<tr><td><u>Condition:</u> </td><td>"+bean.getCondition().toUpperCase()+"</td></tr>");
                    out.println("<tr><td><u>Doors:</u> </td><td>"+bean.getDoorCount().toUpperCase()+"</td></tr>");
                    out.println("<tr><td><u>Engine Type:</u> </td><td>"+bean.getEngineType()+"</td></tr>");
                    out.println("<tr><td><u>Fule Type:</u> </td><td>"+bean.getFuleType()+"</td></tr>");
                    out.println("<tr><td><u>Mileage:</u> </td><td>"+bean.getMileage()+"</td></tr>");
                
                    out.println("<tr><td><u>Model Year:</u> </td><td>"+bean.getModelYear()+"</td></tr>");
                
                    out.println("<tr><td><u>Price Demand:</u> </td><td>"+bean.getPriceDemand()+"</td></tr>");
                    out.println("<tr><td><u>Registered City:</u> </td><td>"+bean.getRegisteredCity()+"</td></tr>");
                
                    out.println("<tr><td><u>Registered Year:</u> </td><td>"+bean.getRegisteredYear()+"</td></tr>");
                
                    out.println("<tr><td><u>Transmission</u> </td><td>"+bean.getTransmission()+"</td></tr>");
                
                out.println("<tr><td>"
                        + "<form enctype='multipart/form-data' action='OnlineShopping' method='post'>"
                        + " <input type='hidden' name='identify' value='accountHome'>"
                        + "<input type='hidden' name='userid' value='"+userId+"'>"
                        + "<input type='submit' value='Back'>"
                        + "</form>"
                        + "</td></tr>");
                out.print("</table>");
    }
}//end of class