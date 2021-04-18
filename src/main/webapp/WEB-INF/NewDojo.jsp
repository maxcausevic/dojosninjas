<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Dojo</title>
</head>
<body>
<h1>Add a Dojo!</h1>
<form:form action="/addDojo/new" method="POST" modelAttribute="dojo">
 <label>Name: <input type="text" name="name"></label>
        <br>
      
    
    <input type="submit" value="Add Dojo"/>
</form:form>
</body>
</html>