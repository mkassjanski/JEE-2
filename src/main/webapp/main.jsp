<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
</head>
<jsp:include page="include/header.jsp" />
<body>

<div>
    <div>
        <h3>Students</h3>
        <br/>

        <c:choose>
            <c:when test="${students.size() > 0}">
                <table class="zui-table zui-table-horizontal zui-table-highlight">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Sex</th>
                        <th>Pesel</th>
                    </tr>
                    <c:forEach var="student" items="${students}" varStatus="loopCounter">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.surname}</td>
                            <td>${student.sex}</td>
                            <td>${student.pesel}</td>
                            <td>
                                <a href="view/${student.id}">
                                    View
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </c:when>
            <c:otherwise>
                <div class="well">No students yet!</div>
            </c:otherwise>
        </c:choose>
    </div>

    <div>
        <div>
            <h3>Add new student!</h3>
            <br/>

            <form action="add" method="post">
                <div>
                    <label for="student">Name:</label>

                    <div>
                        <input type="text" name="name" id="name">
                    </div>
                </div>

                <div>
                    <label for="student">Surname:</label>

                    <div>
                        <input type="text" name="surname" id="surname">
                    </div>
                </div>

                <div>
                    <label for="student">Sex:</label>

                    <div class="col-sm-10">
                        <input type="text" name="sex" id="sex" class="form-control">
                    </div>
                </div>
                <div>
                    <label for="student">Pesel:</label>

                    <div>
                        <input type="text" name="pesel" id="pesel">
                    </div>
                </div>
                <div>
                    <div>
                        <button type="submit">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

</div>

</body>
</html>