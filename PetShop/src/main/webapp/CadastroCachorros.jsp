<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>PetStore - Home</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/pricing/">

<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="css/pricing.css" rel="stylesheet">
</head>
<body>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<a href="home"><img class="mb-2"
			src="https://img.icons8.com/plasticine/50/000000/corgi.png" alt=""
			width="24" height="24"></a>
		<h5 class="my-0 mr-md-auto font-weight-normal">PetStore</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="listaDogs">Cat&aacute;logo</a>
		</nav>
		<a class="btn btn-outline-primary" href="logout">Sign out</a>
	</div>

	<div
		class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
		<h1 class="display-4">Cadastrar/Atualizar Dog</h1>
	</div>

	<div class="container">
		<form name="cadCachorro" action="cadastroCachorro?tipo=${tipo}"
			method="${tipoMetodo}">
			<div class="row">
				<div class="form-group col-md-3">
					<label for="nomeCachorro">Nome Cachorro:</label> <input type="text"
						class="form-control" value="${nomeCachorro}" name="nomeCachorro"
						id="nomeCachorro" required>
				</div>
				<div class="form-group col-md-3">
					<label for="racaCachorro">Ra&ccedil;a do Cachorro:</label> <input
						type="text" class="form-control" value="${racaCachorro}"
						name="racaCachorro" id="racaCachorro" required>
				</div>
				<div class="form-group col-md-3">
					<label for="pesoCachorro">Peso(kg):</label> <input type="text"
						class="form-control" value="${pesoCachorro}" name="pesoCachorro"
						id="pesoCachorro" required>
				</div>
				<div class="form-group col-md-3">
					<label for="porteCachorro">Porte do Cachorro:</label> <select
						id="porteCachorro" class="form-control" name="porteCachorro"
						required>
						<option value="pequeno" selected>Pequeno</option>
						<option value="medio">M&eacute;dio</option>
						<option value="grande">Grande</option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="alturaCachorro">Altura(cm):</label> <input type="text"
						class="form-control" value="${alturaCachorro}"
						name="alturaCachorro" id="alturaCachorro" required>
				</div>
				<div class="form-group col-md-4">
					<label for="corCachorro">Cor:</label> <input type="text"
						class="form-control" value="${corCachorro}" name="corCachorro"
						id="corCachorro" required>
				</div>
				<div class="form-group col-md-4">
					<button style="margin-top: 32px" type="submit" name="idCachorro"
						value="${idCachorro}" class="btn btn-success">Salvar</button>
				</div>
			</div>
		</form>
		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<div class="row">
				<div class="col-12 col-md">
					<img class="mb-2"
						src="https://img.icons8.com/plasticine/24/000000/corgi.png" alt=""
						width="24" height="24"> <small
						class="d-block mb-3 text-muted">&copy;2019</small>
				</div>
				<div class="col-6 col-md">
					<h5>Features</h5>
					<ul class="list-unstyled text-small">
						<li><a class="text-muted" href="#">Cool stuff</a></li>
						<li><a class="text-muted" href="#">Random feature</a></li>
						<li><a class="text-muted" href="#">Team feature</a></li>
						<li><a class="text-muted" href="#">Stuff for developers</a></li>
						<li><a class="text-muted" href="#">Another one</a></li>
						<li><a class="text-muted" href="#">Last time</a></li>
					</ul>
				</div>
				<div class="col-6 col-md">
					<h5>Resources</h5>
					<ul class="list-unstyled text-small">
						<li><a class="text-muted" href="#">Resource</a></li>
						<li><a class="text-muted" href="#">Resource name</a></li>
						<li><a class="text-muted" href="#">Another resource</a></li>
						<li><a class="text-muted" href="#">Final resource</a></li>
					</ul>
				</div>
				<div class="col-6 col-md">
					<h5>About</h5>
					<ul class="list-unstyled text-small">
						<li><a class="text-muted" href="#">Team</a></li>
						<li><a class="text-muted" href="#">Locations</a></li>
						<li><a class="text-muted" href="#">Privacy</a></li>
						<li><a class="text-muted" href="#">Terms</a></li>
					</ul>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>