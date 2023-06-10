<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="tn.iit.model.Autorisation"%>
<%@page import="tn.iit.dao.AutorisationDao"%>
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
	background: rgb(2, 0, 36);
	background: radial-gradient(circle, rgba(2, 0, 36, 1) 0%,
		rgba(224, 228, 235, 1) 0%, rgba(237, 242, 250, 1) 89%,
		rgba(255, 255, 255, 1) 100%);
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
	
	String idE = request.getParameter("idE");
	System.out.println("List Aut  " + idE);
	if(idE==null){
		 idE =(String) session.getAttribute("idE");
		 System.out.println("List Aut SESSION  " + idE);
	}
	List<Autorisation> autorisationList = AutorisationDao.findByEnseignantId(Integer.parseInt(idE));
	Enseignant enseignant= EnseignantDao.findById(Integer.parseInt(idE));
	
	%>
	<div class="wrapper">
		<h1>Liste des Autorisations</h1>

		<br>

		<div class="table-responsive">
			<a href="AddAutorisation.jsp?idE=<%=idE%>" type="button"
				class="btn btn-success btn-rounded" style="float: right;"><i
				class="fa-solid fa-plus"></i> Ajouter</a>
<a href="List.jsp" type="button"
				class="btn btn-info btn-rounded" style="float: left;"><i class="fa-solid fa-arrow-left"></i> Liste des enseignants</a>

			<table class="table table-striped table-hover border-info">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Date</th>
						<th scope="col">Nombre d'heure</th>
						<th scope="col">Action</th>

					</tr>
				</thead>
				<tbody>
					<%
					for (Autorisation a : autorisationList) {
					%>
					<tr>
						<th scope="row"><%=enseignant.getName() %></th>
						<td><%=a.getDate()%></td>
						<td><%=a.getNbheure()%></td>
						<td><button type="button"
								class="btn btn-warning btn-lg btn-floating"
								data-mdb-ripple-color="dark" onclick=window.location.href="UpdateAutorisation.jsp?pos=<%=a.getId()%>&idE=<%=idE %>">
								<i class="fa-sharp fa-solid fa-pen-to-square"></i>
							</button>
							<button type="button"
								class="btn btn-outline-danger btn-lg btn-floating"
								onclick=window.location.href="DeleteAutorisationController?pos=<%=a.getId()%>&idE=<%=idE %>" >
								<i class="fa-solid fa-trash"></i>
							</button>
							<button type="button" class="btn btn-dark btn-lg btn-floating"
								data-mdb-ripple-color="dark"
								onclick=window.location.href="PDFGeneratorServlet?pos=<%=a.getId()%>&idE=<%=idE %>"
								>
<i class="fa-solid fa-file-pdf"></i>							</button></td>
					</tr>
					<%
					}
					%>
				</tbody>

				<caption>Tableau des autorisations</caption>

			</table>
		</div>
	</div>


</body>

</html>