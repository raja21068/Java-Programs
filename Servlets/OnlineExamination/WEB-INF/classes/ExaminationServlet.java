import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExaminationServlet extends HttpServlet{
	
	public static String servletPath;
	
	@Override
	public void init(){
		servletPath = getServletContext().getRealPath("");
		System.out.println("ServletPath: "+servletPath);
	}
	
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
		
		System.out.println(">> Entered in service()");
		
		res.setContentType("text/html");
		PrintWriter out =  res.getWriter();
		
		String identify = req.getParameter("identify");
		System.out.println("identify : "+identify);
		if(identify==null || identify.isEmpty()){
			out.println("There is no identification of request");
			return;
		}
		try{
			if(identify.equals("login")){
				loginRequest(req , res, out);
			}else if(identify.equals("addsubjectform")){
				addSubjectForm(out);
			}else if(identify.equals("addsubject")){
				addSubject(req,res);
			}else if(identify.equals("logout")){
				logout(req,res);
			}else if(identify.equals("admin")){
				adminPressed(req,res);
			}else if(identify.equals("questions")){
				printAllQuestions(req, res);
			}else if(identify.equals("addquestionform")){
				printAddQuestionForm(req,res);
			}else if(identify.equals("addquestion")){
				addQuestion(req,res);
			}else if(identify.equals("showsubjects")){
				adminPressed(req,res);
			}else if(identify.equals("showallquestions")){
				printAllQuestions(req, res);
			}else if(identify.equals("addoptionsform")){
				printAddOptionForm(req, res);
			}else if(identify.equals("optionsave")){
				saveOptions(req, res);
			}else if(identify.equals("viewoptions")){
				viewOptions(req, res);
			}else if(identify.equals("deletesubject")){
				deleteSubject(req, res);
			}else if(identify.equals("deletequestion")){
				deleteQuestion(req, res);
			}else if(identify.equals("deleteoption")){
				deleteOption(req, res);
			}else if(identify.equals("subjectslist")){
				viewAllSubjects(req, res);
			}else if(identify.equals("enterinsubject")){
				enterInSubject(req,res);
			}else if(identify.equals("starttest")){
				startTest(req,res);
			}else if(identify.equals("showresult")){
				viewResult(req,res);
			}
		}catch(Exception ex){ex.printStackTrace();}
	}

	private void adminPressed(HttpServletRequest req , HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in adminPressed");
		Cookie cooks[] = req.getCookies();
		String user=null;
		if(cooks!=null && cooks.length!=0){
			for(int i=0;i<cooks.length;i++){
				Cookie cook = cooks[i];
				if(cook.getName().equals("user")){
						user = cook.getValue();
						break;
				}
			}
			if( user!= null){
				printHomePage(req ,res,user);
				return;
			}
		}
		
		printLoginForm(res.getWriter(),"");
		
	}
	
	private void printLoginForm(PrintWriter out , String message)throws Exception{
		System.out.println(">> Entered in printLoginForm");
		String formPath = servletPath+File.separator+"login.html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println("<html>");
		out.println("<h2 style='color:red'>"+message+"</h2>");
		out.println(htmlForm);
	
	}
	
	private void loginRequest(HttpServletRequest req ,HttpServletResponse res ,PrintWriter out)throws Exception{
		System.out.println(">> Entered in LoginRequest()");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("pass");
		
		String filePath = servletPath+File.separator+"admin"+File.separator+"user.txt";
		System.out.println("servlet access position is: "+filePath);
		DataInputStream in = new DataInputStream(new FileInputStream(filePath));
		String info = in.readLine();
		
		String user = info.substring(0,info.indexOf(','));
		String pass = info.substring(info.indexOf(',')+1);
		System.out.println(user +"\n"+ pass);
		
		if(user.equals(userName) && pass.equals(password)){
			res.addCookie(new Cookie("user",user));
			printHomePage(req ,res,user);
		}
		else{
				printLoginForm(res.getWriter() , "Inalid username or password..");
				System.out.println("invalid username and password..");
		}
	}
	
	private void addSubjectForm(PrintWriter out)throws Exception{
		System.out.println(">> Entered in addSubjectForm()");
		
		String formPath = servletPath+File.separator+"addsubjectform.html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println(htmlForm);
	}
	
	private void printLoginForm(PrintWriter out)throws Exception{
		System.out.println(">> Entered in printLoginForm()");
		
		String formPath = servletPath+File.separator+"login.html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println(htmlForm);
	}
	
	
	private void printHomePage(HttpServletRequest req , HttpServletResponse res,String user)throws Exception{
			System.out.println(">> Entered in printHomePage()");
			
			PrintWriter out = res.getWriter();
			out.println("<head>");
			out.println("<link href='/OnlineExamination/css/tablestyle.css' media='screen' rel='stylesheet' type='text/css'>");
			out.println("</head>");
			out.println("<h2>Hi, "+user+"</h2>");
			
			out.println("<form action='ExaminationServlet' target='display'>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Subjects</th>");
			out.println("<th>No Of Questions</th>");
			out.println("<th>Questions</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");
			
			//getting all subjects from database
			java.util.ArrayList subjectList = DatabaseManager.getAllSubjects();
			
			for(int i=0;i<subjectList.size();i++){
				SubjectsBean  bean = (SubjectsBean)subjectList.get(i);
				java.util.ArrayList questionsList = DatabaseManager.getAllQuestions(bean.getSubId());
			
				out.println("<tr>");
				out.println("<td>"+bean.getSubName()+"</td>");
				out.println("<td>"+questionsList.size()+"</td>");
				out.println("<td>");
				out.println("<form action='ExaminationServlet' target='display'>");
				out.println("<input type='hidden' name='identify' value='questions'>");
				out.println("<input type='hidden' name='subjectid' value='"+bean.getSubId()+"'>");
				out.println("<input type='submit' value='View'>");
				out.println("</form>");
				out.println("</td>");
				out.println("<td>Edit</td>");
				out.println("<td>");
				out.println("<form action='ExaminationServlet' target='display'>");
				out.println("<input type='hidden' name='identify' value='deletesubject'>");
				out.println("<input type='hidden' name='subjectid' value='"+bean.getSubId()+"'>");
				out.println("<input type='image' src='/OnlineExamination/images/remove.png'>");
				out.println("</form>");
				out.println("</td>");
				out.println("</tr>");
			}
			
			out.println("");
			out.println("</table>");
			out.println("</form>");
			
			out.println("<form action='ExaminationServlet' target='display'>"
			+"<input type='hidden' name='identify' value='addsubjectform'>"
			+"<input type='submit' value='Add Subject'>"
			+"</form>");
			
			out.println("<form action='ExaminationServlet' target='display'>"
			+"<input type='hidden' name='identify' value='logout'>"
			+"<input type='submit' value='Logout'>"
			+"</form>");
	}
	
	
	private void addSubject(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in addSubject()");
		
		Cookie[] cooks=req.getCookies();
		if(cooks==null || cooks.length==0){
			printLoginForm(res.getWriter());
			return;
		}
		
		String subjectName = req.getParameter("subject");
		String remarks = req.getParameter("remarks");
		try{
			DatabaseManager.addSubjects(subjectName,remarks);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		printHomePage(req,res,cooks[0].getValue());
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in logout()");
		PrintWriter out = res.getWriter();
		
		Cookie cooks[]=req.getCookies();
		if(cooks==null || cooks.length==0){
			out.println("Logged out!");
			return;
		}
		for(int i=0;i<cooks.length;i++){
			cooks[i].setMaxAge(0);
			res.addCookie(cooks[i]);
		}
		out.println("Logged out!");
	}
	
	private void printAllQuestions(HttpServletRequest req, HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in printAllQuestoins");
		int subId=0;
		try{
			subId = Integer.parseInt(req.getParameter("subjectid"));
		}catch(Exception ex){
			System.out.println("Entered in exception block");
			Cookie cooks[] = req.getCookies();
			System.out.println("cookie length : "+cooks.length);
			for(int i=0;i<cooks.length;i++){
				Cookie cook = cooks[i];
				if(cook.getName().equals("subjectId")){
					System.out.println("Got the value of cookie 'subjectId'");
					subId = Integer.parseInt(cook.getValue());
					break;
				}
			}
			 
		}
		System.out.println("got subject id: "+subId);
		java.util.ArrayList list = DatabaseManager.getAllQuestions(subId);
		
		PrintWriter out = res.getWriter();
		
		out.println("<head>");
		out.println("<link href='/OnlineExamination/css/tablestyle.css' media='screen' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Questions</th>");
		out.println("<th>Exist Options</th>");
		out.println("<th>Options</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for(int i=0;i<list.size();i++){
			QuestionsBean bean = (QuestionsBean) list.get(i); 
			out.println("<tr>");
			out.println("<td>"+bean.getQuestions()+"</td>");
			out.println("<td>("+DatabaseManager.getAllOptions(bean.getQuestionId()).size()+")");
			out.println("<form action='ExaminationServlet'>");
			out.println("<input type='hidden' name='identify' value='viewoptions'>");
			out.println("<input type='hidden' name='questionid' value='"+bean.getQuestionId()+"'>");
			out.println("<input type='submit' value='View'>");
			out.println("</form>");
			out.println("</td>");
			out.println("<td>"
						+"<form action='ExaminationServlet'>"
						+"<input type='hidden' name='identify' value='addoptionsform'>"
						+"<input type='hidden' name='questionid' value='"+bean.getQuestionId()+"'>"
						+"<input type='submit' value='Add Option'>"
						+"</form>"
						+"</td>");
			out.println("<td>"
						+"<form action='ExaminationServlet'>"
						+"<input type='hidden' name='identify' value='deletequestion'>"
						+"<input type='hidden' name='questionid' value='"+bean.getQuestionId()+"'>"
						+"<input type='image' src='/OnlineExamination/images/remove.png'>"
						+"</form>"
						+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		System.out.println("printed the all questions table");
		
		out.println("<form action='ExaminationServlet' target='display'>"
			+"<input type='hidden' name='identify' value='addquestionform'>"
			+"<input type='submit' value='Add Question'>"
			+"</form>");
		out.println("<form action='ExaminationServlet' target='display'>"
			+"<input type='hidden' name='identify' value='showsubjects'>"
			+"<input type='submit' value='back'>"
			+"</form>");
			res.addCookie(new Cookie("subjectId",""+subId));
			System.out.println("add the cookie in response named 'subjectId' ");
	}
	
	private void printAddQuestionForm(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in printLoginForm()");
		
		PrintWriter out = res.getWriter();
		
		String formPath = servletPath+File.separator+"questionform.html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println(htmlForm);
		
		System.out.println("Printed the form in response path:" +formPath);
	}
	
	private void addQuestion(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in addQuestion()");
		String question =req.getParameter("question");
		String remarks =req.getParameter("remarks");
		Cookie cooks[] = req.getCookies();
		//we have to get the subject id from the cookie name subid the pass into the databasemanager
		int subId=0;
		for(int i=0;i<cooks.length;i++){
			Cookie cook = cooks[i];
			if(cook.getName().equals("subjectId")){
				System.out.println("Got the value of cookie 'subjectId'");
				subId = Integer.parseInt(cook.getValue());
				break;
			}
		}
		System.out.println("subject Id:"+subId );
		try{
			DatabaseManager.addQuestions(subId, question, remarks);
			System.out.println("question is added in database..");
		}catch(Exception ex){ex.printStackTrace();}
		printAllQuestions( req,  res);
	}
	
	private void printAddOptionForm(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in printAddOptionForm()");
		String questionId = req.getParameter("questionid");
		
		System.out.println("got the questionId from request: "+questionId);
		PrintWriter out = res.getWriter();
		
		String formPath = servletPath+File.separator+"optionform.html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println(htmlForm);
		
		System.out.println("Printed the form in response path:" +formPath);
		res.addCookie(new Cookie("questionid",questionId));
		System.out.println("add a cookie in response named 'questionid' value "+questionId);
	}
	
	private void saveOptions(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entred in saveOptions()");
		String optionName = req.getParameter("optionname");
		String remarks = req.getParameter("remarks");
		String correct = req.getParameter("correct");
		int questionId = 0;
		Cookie cooks[] = req.getCookies();
		System.out.println("got array of cookies size: "+cooks.length);
		for(int i=0;i<cooks.length;i++){
			Cookie cook = cooks[i];
			System.out.println("Cookie named : "+cook.getName());
			if(cook.getName().equals("questionid")){
				System.out.println("Got the question id: "+cook.getValue());
				questionId = Integer.parseInt(cook.getValue());
				break;
			}
		}
		
		System.out.println("option Name: "+optionName);
		System.out.println("remarks Name: "+remarks);
		System.out.println("correct: "+correct);
		
		try{
			if(questionId!=0){
				if(correct==null)DatabaseManager.addOptions(questionId, optionName, "W",remarks);
				else DatabaseManager.addOptions(questionId, optionName, "C",remarks);
			}
			System.out.println("option succesfully added in database..");
		}catch(Exception ex){ex.printStackTrace();}
		
		printAllQuestions(req,res);
		
	}
	
	private void viewOptions(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in viewOptions()");
		String questionId=null;
	
		questionId = req.getParameter("questionid");
		if(questionId == null){
			Cookie cooks[] = req.getCookies();
			for(int i=0;i<cooks.length;i++){
				Cookie cook = cooks[i];
				System.out.println(cook.getName());
				if(cook.getName().equals("questionid")){
					questionId = cook.getValue();
					System.out.println("Got the question id: "+questionId+" from cookie");
					break;
				}
			}
		}
		
		System.out.println("questionId: "+questionId);
		int qId = Integer.parseInt(questionId);
		
		PrintWriter out = res.getWriter();
		try{
			java.util.ArrayList list = DatabaseManager.getAllOptions(qId);
			out.println("<head>");
			out.println("<link href='/OnlineExamination/css/tablestyle.css' media='screen' rel='stylesheet' type='text/css'>");
			out.println("</head>");
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Option Name</th>");
			out.println("<th>Correct</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");
			for(int i=0;i<list.size();i++){
				OptionsBean bean = (OptionsBean)list.get(i);
				out.println("<tr>");
				out.println("<td>"+bean.getOptionName()+"</td>");
				if(bean.getCorrect().equals("C")){ out.println("<td>Yes</td>"); }
				else{ out.println("<td>No</td>"); }
				
				out.println("<td>"
						+"<form action='ExaminationServlet'>"
						+"<input type='hidden' name='identify' value='deleteoption'>"
						+"<input type='hidden' name='optionid' value='"+bean.getOptionId()+"'>"
						+"<input type='image' src='/OnlineExamination/images/remove.png'>"
						+"</form>"
						+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<form action='ExaminationServlet'>");
					out.println("<input type='hidden' name='identify' value='showallquestions'>");
					out.println("<input type='Submit' value='back'>	");
			out.println("</form>");
			
			res.addCookie(new Cookie("questionid",questionId));
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	private void deleteSubject(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in deleteSubject()");
		Cookie cooks[]=req.getCookies();
		String subjectId = req.getParameter("subjectid");
		String user=null;
		
		System.out.println("subjectId: "+subjectId);
		for(int i=0;i<cooks.length;i++){
			Cookie cook = cooks[i];
			if(cook.getName().equals("user")){
				user=cook.getValue();
				break;
			}
		}
		
		System.out.println("User: "+user);
		if(user!=null){
			try{
				DatabaseManager.deleteSubjects(Integer.parseInt(subjectId));
			}catch(Exception ex){ex.printStackTrace();}
			printHomePage( req ,res, user);
		}
	}
	
	private void deleteQuestion(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in deleteQuestion()");
		Cookie cooks[]=req.getCookies();
		System.out.println("cookies length: "+cooks.length);
		String questionId = req.getParameter("questionid");
		System.out.println("Question id: "+questionId);
		if(questionId !=null){
			try{
				DatabaseManager.deleteQuestions(Integer.parseInt(questionId));
				System.out.println("deleted the question");
			}catch(Exception ex){ex.printStackTrace();}
		}
		printAllQuestions(req,  res);
		
	}
	
	private void deleteOption(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in deleteOption()");
		try{
			String optionId = req.getParameter("optionid");
			if(optionId != null){
				DatabaseManager.deleteOptions(Integer.parseInt(optionId));
			}
		}catch(Exception ex){ex.printStackTrace();}
		
		viewOptions(req, res);
	}
	
	private void viewAllSubjects(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in viewAllSubjects()");
		PrintWriter out = res.getWriter();
		try{
			Cookie[] cooks = req.getCookies();
			if(cooks!=null){
				for(int i=0;i<cooks.length;i++){
					cooks[i].setMaxAge(0);
					res.addCookie(cooks[i]);
						
				}
			}
			
			java.util.ArrayList list = DatabaseManager.getAllSubjects();
			
			for(int i=0;i<list.size();i++){
				SubjectsBean bean = (SubjectsBean)list.get(i);
				out.println("<form action='ExaminationServlet' style='background-color:#661155;border-radius: 5px;'>");
				out.println("<input type='hidden' name='identify' value='enterinsubject'>");
				out.println("<input type='hidden' name='subjectid' value='"+bean.getSubId()+"'>");
				out.println("<input type='hidden' name='subjectname' value='"+bean.getSubName()+"'>");
				out.println("<input type='submit' value='"+bean.getSubName()+"'>");
				out.println("</form>");
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	private void enterInSubject(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println(">> Entered in enterInSubject()");
		String subjectId = req.getParameter("subjectid");
		String subjectName = req.getParameter("subjectname");
		System.out.println("SubjectId : "+subjectId);
		System.out.println("SubjectName : "+subjectName);
		
		//destroying the cookie name questiondisplayed
		Cookie[] cooks = req.getCookies();
		if(cooks!=null){
			for(int i=0;i<cooks.length;i++){
				if(cooks[i].getName().equals("questiondisplayed") ||cooks[i].getName().equals("indexes")){
					cooks[i].setMaxAge(0);
					res.addCookie(cooks[i]);
				}
			}
		}
		
		PrintWriter out = res.getWriter();
		
		//printing the subject html file
		// the html file name must be same as the subject name
		String formPath = servletPath+File.separator+subjectName+".html";
		DataInputStream in = new DataInputStream(new FileInputStream(formPath));
		String htmlForm="";
		String s="";
		while((s=in.readLine())!=null){
			htmlForm+=s;
		}
		out.println(htmlForm);
		
		res.addCookie(new Cookie("subjectid",subjectId));
		System.out.println("a cookie is added named 'subjectid' ");
	}
	
	
	private void startTest(HttpServletRequest req,HttpServletResponse res)throws Exception{
		System.out.println("\n>> entered in startTest()");
		boolean result = true;
		
		Cookie[] cooks = req.getCookies();
		PrintWriter out = res.getWriter();
		String subjectId=null;
		int questionAlreadyDisplayed=0;
		String indexes=null;
		
		if(cooks!=null){
			for(int i=0;i<cooks.length;i++){
				Cookie cook = cooks[i];
				System.out.println("cookie name : "+cook.getName());
				if(cook.getName().equals("subjectid")){
					subjectId = cook.getValue();
				}
				//getting information about already displayed questions
				if(cook.getName().equals("questiondisplayed")){
					questionAlreadyDisplayed = Integer.parseInt(cook.getValue());
					System.out.println("got the question already displyed data "+questionAlreadyDisplayed);
				}
				if(cook.getName().equals("indexes")){
					indexes = cook.getValue();
					System.out.println(indexes);
				}
			}
		}
		if(subjectId !=null){
			int subId = Integer.parseInt(subjectId);
			try{
				java.util.ArrayList questionList = DatabaseManager.getAllQuestions(subId);
				
				// means started from 1st question
				if(indexes==null){
					
					//generaing random indexes
					indexes = "("+ (int)(Math.random()*questionList.size()-1) +")";
					for(int i=1;i<questionList.size();){
						int ran = (int)(Math.random()*questionList.size());
						
						System.out.println(ran);
						if(!indexes.contains("("+ran+")")){
							indexes += ",("+ ran +")";
							i++;
							System.out.println(">>>> "+ran);
						}
					}
					System.out.println(indexes);
				}
				//means clients has sent the answers we have to save them
				else{
					System.out.println("saving the answers");
					java.util.Enumeration<String> parameters = req.getParameterNames();
					while(parameters.hasMoreElements()){
							String name = parameters.nextElement();
							String value = req.getParameter(name);
							res.addCookie(new Cookie(name,value));
							System.out.print(name+" : ");
							System.out.println(value);
					}
				}
				
				String indexSeperated[] = indexes.split(",");
				out.println("<html>");
				out.println("<form action='ExaminationServlet'>");
				out.println("<input type='hidden' name='identify' value='starttest'>");
				int i=questionAlreadyDisplayed;
				int counter=1;
				for(    ;i<questionList.size();i++,counter++){
					result = false;
					// QuestionsBean bean = (QuestionsBean)questionList.get(i);
					int indexx = (Integer.parseInt(indexSeperated[i].substring(1,indexSeperated[i].length()-1)));
					QuestionsBean bean = (QuestionsBean)questionList.get(indexx);
					
					out.println("Q"+(i+1)+":"+bean.getQuestions());
					java.util.ArrayList optionList = DatabaseManager.getAllOptions(bean.getQuestionId());
					
					
					for(int j=0;j<optionList.size();j++){
						OptionsBean ob = (OptionsBean)optionList.get(j);
						// out.println("<br><input type='radio' name='"+bean.getQuestionId()+"' required='required' value='"+ob.getCorrect()+"'>"+ob.getOptionName());
						out.println("<br><input type='radio' name='"+bean.getQuestionId()+"' required='required' value='"+ob.getOptionId()+"'>"+ob.getOptionName());
					}
					
					out.println("<hr>");
					//if displayed question is 5 then stop
					if(counter==5){break;}
				}
				
				
				if(result){
					// viewResult(req, res , i);
					// viewResult(req, res);
					res.sendRedirect("ExaminationServlet?identify=showresult");
				}
				else{
					out.println("<input type='submit' value='Next>>'>");
					out.println("</form>");
					out.println("<html>");
					
					res.addCookie(new Cookie("questiondisplayed",""+(++i)));
					System.out.println("added a cookie named 'questiondisplayed'");
					res.addCookie(new Cookie("indexes",indexes));
					System.out.println("added a cookie named 'indexes'");
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		
	}
	
	private void viewResult(HttpServletRequest req, HttpServletResponse res )throws Exception{
		System.out.println("\n>> Entered in viewResult(req , res)");
		int correct = 0;
		Cookie cooks[] = req.getCookies();
		for(int i=0;i<cooks.length;i++){
			try{
				int questionId = Integer.parseInt(cooks[i].getName());
				int optionId = Integer.parseInt(cooks[i].getValue());
				System.out.print("-> "+questionId+":");
				System.out.println(optionId);
				
				int originalOptionId = DatabaseManager.getCorrectOptionId(questionId);
				System.out.println("originalOptionId: "+originalOptionId+" -> optionId: "+optionId);
				if(originalOptionId == optionId ){
					correct++;
				}
			}catch(NumberFormatException ex){
				System.out.println("Not a question");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		PrintWriter out = res.getWriter();
		out.println(correct+" Answer Correct ");
	}
	
	// private void viewResult(HttpServletRequest req, HttpServletResponse res , int totalQuestion)throws Exception{
		// int correct = 0;
		// Cookie[] cooks = req.getCookies();
		// for(int i=0;i<cooks.length;i++){
			// if(cooks[i].getValue().equals("C")){
				// correct++;
			// }
		// }
		// PrintWriter out = res.getWriter();
		// out.println(correct+" Question Correct out of "+totalQuestion);
	// }
	
	
	
}