<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../include/dziennik.css">
<body>
            <h3>Edit comment:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/comment/edit/${comment.id}" method="post">
                    <label for="type">Type:</label>

                       <input type="text" name="type" id="type" value="${comment.type}"><br />

                      <label for="message">Message:</label>

                       <input type="text" name="message" id="message" value="${comment.message}"><br />
						<label for="author">Author:</label>

                       <input type="text" name="author" id="author" value="${comment.author}"><br />
     
                        <button type="submit">Save</button>
            </form>





</body>
</html>