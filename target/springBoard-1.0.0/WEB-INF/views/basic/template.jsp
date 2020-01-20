<%@page import="org.springframework.web.servlet.view.tiles2.TilesView"%>
<%@page import="org.springframework.web.servlet.view.tiles2.TilesConfigurer"%>
<%@page import="org.apache.tiles.web.util.TilesDispatchServlet"%>
<%@page import="org.apache.tiles.access.TilesAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
     <title>MY PORTFOLIO</title>
    <%@ include file="/WEB-INF/views/basic/header.jspf" %>
 </head>
  <body>
  	<tiles:insertAttribute name="menu" />
	<div class="main" style="display:block; margin-top:60px;">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />   
	</div>
	 <div class="container"> 
		<tiles:insertAttribute name="footer" /> 
	</div>
  </body>
</html>


