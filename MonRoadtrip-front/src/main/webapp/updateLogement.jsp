<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<head>
<title>Gestion des logements</title>
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
							: Lucie</a> <a class="nav-link" href="gestioncompte.html"
							style="color: white">Gérer mon compte</a> <a class="nav-link"
							href="disconnect" style="color: white">Se déconnecter</a>
					</form>
				</div>
			</nav>
		</header>

		<main class="mainGestionLogement">

			<div id="updateLogement">
				<h3 class="titre" align="center">Modification du logement</h3>

				<form id="formGestionLogement" method="post"
					action="gestionLogement">
					<input type="hidden" name="tache" value="update"> <input
						type="hidden" name="id" value="${logement.id}">

					<table id="infos">
						<tr>
							<td>Numero :</td>
							<td><input name="numero" type="text"
								value="${logement.adresse.numero}"></td>

						</tr>
						<tr>
							<td>Voie :</td>
							<td><input name="voie" type="text"
								value="${logement.adresse.voie}"></td>
						</tr>
						<tr>
							<td>Ville :</td>
							<td><input name="ville" type="text"
								value="${logement.adresse.ville}"></td>
						</tr>
						<tr>
							<td>CP :</td>
							<td><input name="cp" type="text"
								value="${logement.adresse.cp}"></td>
						</tr>
						<tr>
							<td>Date :</td>
							<td><input name="date" type="date" value="${logement.date}"></td>
						</tr>
						<tr>
							<td>Nombre de places :</td>
							<td><input name="nbPlaces" type="number"
								value="${logement.nbPlaces}" min=0 max=99></td>
						</tr>
						<tr>
							<td>Prix :</td>
							<td><input name="prix" type="number"
								value="${logement.prix}" min=0 max=999 step=0.01> €</td>
						</tr>
					</table>

					<br>

					<div class="form-row">
						<div class="form-group col-lg-4">
							<a href="gestionLogement"><button type="button"
									class="btn btn-warning btnUpdate">Annuler</button></a>
						</div>
						<div class="form-group col-lg-8">
							<button type="submit" class="btn btn-success btnUpdate">Valider</button>
						</div>
					</div>
				</form>
			</div>
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