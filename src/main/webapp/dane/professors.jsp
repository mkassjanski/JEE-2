<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<script>
		$(document).ready(function()
				{		
				$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/rest/professor/show',
							type: 'GET',
							success: function(dane)
							{ 
								var d = dane.length;
								var table = document.getElementById("tabelka");
								for (var i = 0; i < d; i++)
								{
									    tr = $('<tr/>');
									    tr.append("<td>"+dane[i].name+"</td>");
									    tr.append("<td>"+dane[i].surname+"</td>");
									    tr.append("<td>"+dane[i].title+"</td>");
									    td = $('<td/>');
									    td.append("<a href='${pageContext.request.contextPath}/PodgladTrumna/"+dane[i].id+"' class='btn btn-xs btn-warning' role='button'> Podgląd </a> ");
									    tr.append(td);
									    $(table).append(tr);
								}
							}
						}	
					);
				}
			);
	</script>

</head>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../include/dziennik.css">
<body>
<div>
    <div>
        <h1>Professors</h1>
        <div>
        	<a href="${pageContext.request.contextPath}/AddProfessor">Dodaj</a>
         </div>
        <br/>

        <table id="tabelka">
               <tr>
                     <th>Name</th>
                     <th>Surname</th>
                     <th>Title</th>
                     <th></th>
              </tr>
	</table>
    </div>

</body>
</html>