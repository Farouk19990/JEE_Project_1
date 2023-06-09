<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form,
	fieldset, input, textarea, p, blockquote, th, td {
	padding: 0;
	margin: 0;
}

body {
	background: #f2f2f2;
	height: 100vh;
	display: grid;
	place-items: center;
	font-family: Montserrat;
	color: #b3afbf;
}

fieldset, img {
	border: 0
}

ol, ul, li {
	list-style: none
}

:focus {
	outline: none
}

body, input, textarea, select {
	font-family: 'Open Sans', sans-serif;
	font-size: 16px;
	color: #4c4c4c;
}

a {
	float:left;
	outline: 0;
	border: 0;
	cursor: pointer;
	border-radius: 8px;
	padding: 14px 24px 16px;
	font-size: 18px;
	font-weight: 700;
	line-height: 1;
	transition: transform 200ms, background 200ms;
	background: transparent;
	color: #000000;
	box-shadow: 0 0 0 3px #000000 inset;
}

a:hover {
	transform: translateY(-2px);
}

input.button {
	float: right;
	outline: 0;
	border: 0;
	cursor: pointer;
	background: #000000;
	color: #FFFFFF;
	border-radius: 8px;
	padding: 14px 24px 16px;
	font-size: 18px;
	font-weight: 700;
	line-height: 1;
	transition: transform 200ms, background 200ms;
}

input.button:hover {
	transform: translateY(-2px);
}

p {
	margin-top: 18px;
	font-size: 16px;
	width: 150px;
	display: inline-block;
	margin-left: 18px;
	color: #ff0000;
}

h1 {
	font-size: 32px;
	font-weight: bold;
	color: #4c4c4c;
	text-align: center;
	padding-top: 10px;
	margin-bottom: 10px;
}

html {
	background-color: #ffffff;
}

.testbox {
	margin: 20px auto;
	width: 350px;
	height: 330px;
	-webkit-border-radius: 8px/7px;
	-moz-border-radius: 8px/7px;
	border-radius: 8px/7px;
	background-color: whitesmoke;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
	border: solid 1px #cbc9c9;
}

input[type=radio] {
	visibility: hidden;
}

form {
	margin: 0 30px;
}

label.radio {
	cursor: pointer;
	text-indent: 35px;
	overflow: visible;
	display: inline-block;
	position: relative;
	margin-bottom: 15px;
}

label.radio:before {
	background: #3a57af;
	content: '';
	position: absolute;
	top: 2px;
	left: 0;
	width: 20px;
	height: 20px;
	border-radius: 100%;
}

label.radio:after {
	opacity: 0;
	content: '';
	position: absolute;
	width: 0.5em;
	height: 0.25em;
	background: transparent;
	top: 7.5px;
	left: 4.5px;
	border: 3px solid #ffffff;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

input[type=radio]:checked+label:after {
	opacity: 1;
}

hr {
	color: #a9a9a9;
	opacity: 0.3;
}

input[type=text], input[type=password] {
	width: 220px;
	height: 42px;
	-webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	-moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px;
	border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	background-color: #fff;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 1px #cbc9c9;
	margin-left: -5px;
	margin-top: 13px;
	padding-left: 10px;
}

input[type=password] {
	margin-bottom: 25px;
}

#icon {

	display: inline-block;
	width: 30px;
	background-color: black;
	padding: 8px 0px 8px 15px;
	margin-left: 15px;
	-webkit-border-radius: 4px 0px 0px 4px;
	-moz-border-radius: 4px 0px 0px 4px;
	border-radius: 4px 0px 0px 4px;
	color: white;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09); #
	border: solid 0px #cbc9c9;
}

.gender {
	margin-left: 30px;
	margin-bottom: 30px;
}

.accounttype {
	margin-left: 8px;
	margin-top: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<div class="testbox">
		<h1>Login</h1>
		<form action="UtilisateurController" method="post">
			<label id="icon" for="name"><i class="icon-envelope "></i></label><input
				type="text" name="user_mail" placeholder="Mail" required><br>
			<label id="icon" for="name"><i class="icon-shield"></i></label><input
				type="password" name="pswd" placeholder="Mot de passe" required><br>
			<input type="submit" value="valider" class="button">
		</form>
		<br />
		<%
		if (request.getAttribute("erreur") != null) {
		%>
		<p><%=request.getAttribute("erreur")%></p>
		<%
		}
		%>

	</div>
</body>
</html>