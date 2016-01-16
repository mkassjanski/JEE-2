<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
</head>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../include/dziennik.css">
<body>


<div>
 <h3>Student</h3>
        <br/>

         <label>Name:</label>
        ${student.name} <br/>

        <label>Surname:</label>
        ${student.surname} <br/>
        
         <label>Sex:</label>
       ${student.sex} <br/>
        
         <label>Pesel:</label>
        ${student.pesel} <br/>

        <label>Created:</label>
        ${student.createdAt} <br/>
</div>
</body>
</html>
