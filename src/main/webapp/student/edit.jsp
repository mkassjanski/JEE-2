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
            <h3>Edit student:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/edit/${student.id}" method="post">
                    <label for="name">Name:</label>

                       <input type="text" name="name" id="name" value="${student.name}"><br />

                      <label for="surname">Surname:</label>

                       <input type="text" name="surname" id="surname" value="${student.surname}"><br />
						<label for="sex">Sex:</label>

                       <input type="text" name="sex" id="sex" value="${student.sex}"><br />
     					<label for="pesel">Pesel:</label>

                       <input type="text" name="pesel" id="pesel" value="${student.pesel}"><br />
     
                        <button type="submit">Save</button>
            </form>





</body>
</html>