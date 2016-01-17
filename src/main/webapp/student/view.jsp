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
<p>Comments:</p>
        <div>
            <c:choose>
                <c:when test="${comments.size() > 0}">
                    <c:forEach var="comment" items="${comments}" varStatus="loop">
                    	<p>Id: ${comment.id}</p>
                        <p>Date: ${comment.createdAt}</p>
                        <p>Author: ${comment.author}</p>
                        <p>${comment.type}</p>
                        <p>${comment.message}</p>
                                <a href="../comment/edit/${comment.id}">
                                    Edit
                                </a>
                                <a href="../comment/remove/${comment.id}">
                                    Remove
                                </a>
                        <c:if test="${!loop.last}">
                        </c:if>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    No notes yet!
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div>
        <div>
            <h3>Add comment:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/comments/add/${student.id}" method="post">
                <div>
                    <label for="author">Author:</label>

                    <div>
                        <input type="text" name="author" id="author">
                    </div>
                </div>

				<div>
                    <label for="author">Type:</label>

                    <div>
                        <input type="text" name="type" id="type">
                    </div>
                </div>

                <div>
                    <label for="message">Message:</label>

                    <div>
                        <input type="text" name="message" id="message">
                    </div>
                </div>

                <div>
                    <div>
                        <button type="submit">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</body>
</html>
