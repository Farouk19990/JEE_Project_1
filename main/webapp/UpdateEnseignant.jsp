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
*{
margin: 0;
padding:0;
box-sizing :border-box;
}
body{
background: rgb(2,0,36);
background: radial-gradient(circle, rgba(2,0,36,1) 0%, rgba(224,228,235,1) 0%, rgba(237,242,250,1) 89%, rgba(255,255,255,1) 100%);
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
color:#07001f;
margin-bottom:1.2rem;
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
.btn1{
font-size:1rem;
margin-top:1.8rem;
padding:10px 0;
border-radius:20px;
outline:none;
border:none;
width:90%;
color:#fff;
cursor:pointer;
background:rgb(17,107,143);
}
.btn1:hover{
background:rgba(17,107,143,0.877);
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
label{
float:left;
font-weight:bold;
font-size:15px;
}

</style>

<body>
	<% String pos = request.getParameter("pos");
	Enseignant enseignant= EnseignantDao.findById(Integer.parseInt(pos));
	%>
	<div class="wrapper">
	<h1>Modifier Enseignant</h1>
	<form action="UpdateController" method="post">
	
<input type="text" name="name" placeholder="Nom" value=<%=enseignant.getName()%> >
	<input type="text" name="prenom" placeholder="Prenom" value=<%=enseignant.getPrenom()%>>
	 <input type="email" name="mail" placeholder="Email" value=<%=enseignant.getMail()%> >
	<input type="number" name="nbheure" placeholder="nombre d'heure" value=<%=enseignant.getNbheure()%>>

			<input type="hidden" name="pos" value=<%=pos %>> <input type="submit" value="valider" class="btn1">
	</form>
	
	
	
	
	</div>
</body>
</html>