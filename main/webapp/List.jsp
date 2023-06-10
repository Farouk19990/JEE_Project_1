<%@page import="tn.iit.model.Enseignant"%>
<%@page import="tn.iit.dao.EnseignantDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.css"
	rel="stylesheet" />
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>


* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;

}

body {
background: rgb(2,0,36);
background: radial-gradient(circle, rgba(2,0,36,1) 0%, rgba(224,228,235,1) 0%, rgba(237,242,250,1) 89%, rgba(255,255,255,1) 100%);

}

.wrapper {
	width: 1000px;
	padding: 2rem 1rem;
	margin: 50px auto;
	background-color: #fff;
	border-radius: 10px;
	text-align: center;
	box-shadow: 0 20px 35px rgba(0, 0, 0, 0.1);
}

h1 {
	font-size: 2rem;
	margin-bottom: 1.2rem;
	color: rgb(17, 107, 143);
	text-transform: capitalize;
}

form input {
	width: 92%;
	outline: none;
	border: 1px solid #fff;
	padding: 12px 20px;
	margin-bottom: 10px;
	border-radius: 20px;
	background: #e4e4e4;
}

.btn2 {
	font-size: 1rem;
	margin-top: 1.8rem;
	padding: 10px 0;
	border-radius: 20px;
	outline: none;
	border: none;
	width: 45%;
	color: #fff;
	cursor: pointer;
	background: #b3b3b3;
}

.btn2:hover {
	background: #cccccc;
}

input:focus {
	border: 1px solid rgb(192, 192, 192);
}

.compte {
	font-size: 0.9rem;
	margin-top: 1.4rem;
	color: #636363;
}

.compte a {
	color: rgb(17, 107, 143);
	text-decoration: none;
}

.error {
	color: red;
}

label {
	float: left;
	font-weight: bold;
	font-size: 15px;
}

p {
	font-size: 15px;
}

.p {
	
}
</style>

<body>
	<%
		List<Enseignant> enseignantList = EnseignantDao.getAll();
	%>
	<div class="wrapper">
		<h1>Liste des Enseignants</h1>





		<br>

		<div class="table-responsive">
			<a href="AddEnseignant.jsp" type="button"
				class="btn btn-success btn-rounded" style="float: right;"><i
				class="fa-solid fa-plus"></i> Ajouter</a>

			<table class="table table-striped table-hover border-info">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Email</th>
						<th scope="col">Nombre d'heure</th>
						<th scope="col">Action</th>

					</tr>
				</thead>
				<tbody>
					<%
						for (Enseignant e : enseignantList) {
					%>
					<tr>
						<th scope="row"><%=e.getName()%></th>
						<td><%=e.getPrenom()%></td>
						<td><%=e.getMail()%></td>
						<td><%=e.getNbheure()%></td>
						<td><button type="button" class="btn btn-warning btn-lg btn-floating"
								data-mdb-ripple-color="dark" onclick=window.location.href="UpdateEnseignant.jsp?pos=<%=e.getId()%>">
								<i class="fa-sharp fa-solid fa-pen-to-square"></i>
							</button>
							<button type="button"
								class="btn btn-outline-danger btn-lg btn-floating"
								onclick=window.location.href="DeleteController?pos=<%=e.getId()%>" >
								<i class="fa-solid fa-trash"></i>
							</button>
							<button type="button"
								class="btn btn-info btn-lg btn-floating"
								data-mdb-ripple-color="dark" >
								<i class="fa-solid fa-print"></i>
							</button>
							</td>
					</tr>
					<%
						}
					%>
				</tbody>

				<caption>Tableau des enseignants</caption>

			</table>
		</div>
		</div>
		
		 
</body>

</html>