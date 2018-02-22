<%-- 
    Document   : success
    Created on : Feb 28, 2009, 8:24:14 AM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>

<%
	String v1 = request.getParameter("value1");
	String v2 = request.getParameter("value2");
	out.println(Integer.parseInt(v1)+Integer.parseInt(v2));
%>
