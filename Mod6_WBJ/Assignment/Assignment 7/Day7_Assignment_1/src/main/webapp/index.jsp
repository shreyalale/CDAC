<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Calculator</title>
</head>
<body>
  <h2>Simple Calculator</h2>
  <form action="result.jsp" method= "post">
  <label for="num1">Number 1:</label>
  <input type= "number" step= "any" name= "num1" id="num1" required> <br> <br>
  
   <label for="num1">Number 2:</label>
  <input type= "number" step= "any" name= "num2" id="num2" required> <br> <br>
  
  <label for="operation">Operation:</label>
  <select name= "operation" id="operation" required>
  <option value= "add">Add</option>
  <option value= "subtract">Subtract</option>
  <option value= "multiply">Multiply</option>
  <option value= "divide">Divide</option>
  </select><br><br>
  <button type="submit">Calculate</button>
  </form>
</body>
</html>