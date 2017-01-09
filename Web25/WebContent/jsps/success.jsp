<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.google.com/b2r" prefix="vish"%>

<%@page import="java.util.Calendar"%>

<HTML>
<BODY>
	<h2>Hi ${userFullName1}</h2>
	<h1> Success </h1>	
	
	My First name: <%= session.getAttribute("firstName") %> <br>
	Hello!  The time is now <%= request.getAttribute("userFullName") %>
	
	<%! int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK); %>
	<jsp:declaration> int a = 10;</jsp:declaration>
	
	
	<c:if test="${userFullName1 == 'Vish'}">
		<div> dvdsvssvavv </div>
	</c:if>
	
	<% if (day == 1 || day == 7) { %>
	      <p> Today is weekend</p>
	<% } else { %>
	      <p> Today is not weekend</p>
	<% } %>
	
	<br>
	<%@ include file="./info.jsp" %>
	
	
	<vish:message1>	</vish:message1>
<h1>What Can JavaScript Do?</h1>

<p id="demo">JavaScript can change HTML content.</p>

<button type="button" onclick="myFunction()" onmouseover="mouseOverDisplayMessage()" >Click Me!</button>

<script>
	function myFunction(){
	    alert("Hi Buddy");
	}
	
	function mouseOverDisplayMessage() {
		console.out("On mouse focus");
	}
</script>


</BODY>
</HTML>
	