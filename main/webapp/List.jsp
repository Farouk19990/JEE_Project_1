<%@page import="tn.iit.model.Enseignant"%>
<%@page import="tn.iit.dao.EnseignantDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');
*{
margin: 0;
padding:0;
box-sizing :border-box;
font-family:"Poppins",dans-serif;
}
body{
background:#dfe9f5;
}
.wrapper{
width:700px;
padding:2rem 1rem;
margin: 50px auto;
background-color:#fff;
border-radius:10px;
text-align:center;
box-shadow : 0 20px 35px rgba(0,0,0,0.1);
}
h1{
font-size:2rem;
margin-bottom:1.2rem;
color:rgb(17,107,143);
text-transform: capitalize;
}
form input{
width:92%;
outline:none;
border:1px solid #fff;
padding:12px 20px;
margin-bottom:10px;
border-radius:20px;
background:#e4e4e4;
}

.btn2{
font-size:1rem;
margin-top:1.8rem;
padding:10px 0;
border-radius:20px;
outline:none;
border:none;
width:45%;
color:#fff;
cursor:pointer;
background:#b3b3b3;
}
.btn2:hover{
background:#cccccc;
}
input:focus{
border:1px solid rgb(192,192,192);
}
.compte{
font-size: 0.9rem;
margin-top:1.4rem;
color:#636363;

}
.compte a{
color: rgb(17,107,143);
text-decoration:none;
}
.error{
color:red;
}
label{
float:left;
font-weight:bold;
font-size:15px;
}
p{
font-size:15px;
}
.p{

}
</style>

<body>
	<%
	List<Enseignant> enseignantList = EnseignantDao.getAll();
	%>
	<div class="wrapper">
	<h1>Liste des Enseignants</h1>
	

<a class="btn btn-success"  href="AddEnseignant.jsp" style="float:right;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
</svg>  Add </a>
<br>
	<table class="table table-striped table-hover">
	<tr><th>Nom</th><th>Prenom</th><th>Email</th><th>Nombre d'heure</th><th>Action</th></tr>
	<%for (Enseignant e: enseignantList){ 
		
			
		
	%>
		<tr>
			<td><%=e.getName() %></td>
			<td><%=e.getPrenom() %></td>
			<td><%=e.getMail() %></td>
			<td><%=e.getNbheure() %></td>
			
			<td><button class="btn btn-warning" onclick=window.location.href="UpdateEnseignant.jsp?pos=<%=e.getId() %>"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg> update</button>
			<button class="btn btn-outline-danger" onclick=window.location.href="DeleteController?pos=<%=e.getId() %>" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
  <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
</svg> Delete</button></td>
		</tr>
		
	<%} %>
	</div>
	

</body>
</html>