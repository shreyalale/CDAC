<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.cdac.beans.TestBean" %>
<jsp:useBean id="testBean" class="com.cdac.beans.TestBean" scope="request" />
<jsp:setProperty property="*" name="testBean" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
    <h2>Calculate Result</h2>
    <%
       testBean.calculate();
    %>
    <p> 
     Result of <strong><%= testBean.getOperation() %></strong> operation between 
        <strong><%= testBean.getNum1() %></strong> and 
        <strong><%= testBean.getNum2() %></strong> is: 
        <strong><%= testBean.getResult() %></strong>
    </p>
    <a href= "index.jsp">Go Back</a>
</body>
</html>