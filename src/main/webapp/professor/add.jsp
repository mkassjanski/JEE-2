<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../include/dziennik.css">

<script>
		$(document).ready(function()
			{
				$( "#add" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/professor/add',
						    type: 'POST',
						    data:
							{
								name: document.getElementById('name').value,
								surname: document.getElementById('surname').value,
								title: document.getElementById('title').value
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/Professors"); },
 						    error: function() { alert("Nieprawidłowo wprowadzono dane!"); }
						}		
						);
					}
				);
			}
		);
	</script>




</head>
<body>

<div>
    <div>
        <h1>Add professor</h1>

        	<form action="${pageContext.request.contextPath}/rest/professor/add" data-toggle="validator" method="post">
		        <div>
		            <label for="name">Name:</label>

		            <div>
		                <input type="text" name="name" id="name">
		            </div>
		        </div>

		        <div>
		            <label for="surname">Surname:</label>

		            <div>
		                <input type="text" name="surname" id="surname">
		            </div>
		        </div>

		        <div>
		            <label for="title">Title:</label>

		            <div>
		                <input type="text" name="title" id="title">
		            </div>
		        </div>
		        <div>
		                <button id="add" type="submit">Add</button>
		 	    </div>
		        </div>
            	</form>
</div>





</body>
</html>