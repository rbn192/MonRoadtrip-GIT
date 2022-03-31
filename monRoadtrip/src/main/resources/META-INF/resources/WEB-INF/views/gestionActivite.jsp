<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="Style.css">

<head>
<title>Gestion des activités</title>
</head>

<body>
	<div>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
				<a class="navbar-brand" href="Roadtrip.html">Accueil</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarCollapse" aria-controls="navbarCollapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav mr-auto">
					</ul>

					<form class="form-inline mt-2 mt-md-0">
						<a class="nav-link" href="gestioncompte.html" style="color: white">Connecté
							: Robin</a> <a class="nav-link" href="gestioncompte.html"
							style="color: white">Gérer mon compte</a> <a class="nav-link"
							href="disconnect" style="color: white">Se déconnecter</a>
					</form>
				</div>
			</nav>
		</header>

		<main class="mainGestion">

			<div>
				<h2 class="titre" align="center">Liste des activités</h2>
			</div>

			<table border="1px" align="center" width="90%">

				<thead>
					<tr align="center">
						<th>ID</th>
						<th>Numero</th>
						<th>Voie</th>
						<th>Ville</th>
						<th>Code Postal</th>
						<th>Categorie</th>
						<th>Date</th>
						<th>Heure</th>
						<th>Nombre de places</th>
						<th>Prix</th>
						<th>Action</th>

					</tr>
				</thead>

				<tbody align="center">
					<c:forEach items="${activites}" var="a">

						<tr>
							<td>${a.id}</td>
							<td>${a.adresse.numero}</td>
							<td>${a.adresse.voie}</td>
							<td>${a.adresse.cp}</td>
							<td>${a.adresse.ville}</td>
							<td>${a.categorie}</td>
							<td>${a.date}</td>
							<td>${a.heure}</td>
							<td>${a.nbPlaces}</td>
							<td>${a.prix}</td>
							<td><a href="gestionActivite?id=${a.id}"><button
										type="button" class="btn btn-primary">Modifier</button></a>
								<form action='gestionActivite' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${a.id}'> <input
										type='submit' class='btn btn-danger' value='Supprimer'>
								</form></td>
						</tr>

					</c:forEach>
				</tbody>

			</table>

			<br>

			<div id="ajouter">
				<input type="button" value="Ajouter" id="btnShowAddForm"
					class="btn btn-info button">
			</div>

			<br> <br>

				<form action="gestionActivite" method="post" id="addFormActivite"
					style="display: none" align="center">

					<input type="hidden" name="tache" value="insert">

					<table class="infos">
						<tr>
							<td>Numéro :</td>
							<td><input required type="text" name="numero"></td>
						</tr>
						<tr>
							<td>Voie :</td>
							<td><input required type="text" name="voie"></td>
						</tr>
						<tr>
							<td>CP :</td>
							<td><input required type="text" name="cp"></td>
						</tr>
						<tr>
							<td>Ville :</td>
							<td><input required type="text" name="ville"></td>
						</tr>
						<tr>
							<td>Catégorie :</td>
							<td><input required type="text" name="categorie"></td>
						</tr>
						<tr>
							<td>Date :</td>
							<td><input required type="date" name="date"></td>
						</tr>
						<tr>
							<td>Heure :</td>
							<td><input required type="time" name="heure"></td>
						</tr>
						<tr>
							<td>Nombre de places :</td>
							<td><input required type="number" name="nbPlaces" min=0
								max=99></td>
						</tr>
						<tr>
							<td>Prix :</td>
							<td><input required type="number" name="prix" min=0 max=999
								step=0.01> €</td>
						</tr>
					</table>

					<input type="reset"
						class="btn btn-warning button" value="Annuler">
					<input type="submit" class="btn btn-success mb-2"
						value="Ajouter">
			</form>
		</main>
	</div>

	<footer class="container">
		<p class="float-right">
			<a href="">Retour en haut</a>
		</p>
		<p>
			&copy; 2022 - Mon road trip&middot; <a href="#">Confidentialité</a>
		</p>
	</footer>
</body>

<script>
	btnShowAddForm.onclick = function() {
		$("#addFormActivite").show();
	}
</script>
