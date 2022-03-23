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

		<main class="mainGestion">

			<div>
				<h2 class="titre" align="center">Liste des logements</h2>
			</div>

			<table border="1px" align="center" width="90%">

				<thead>
					<tr align="center">
						<th>ID</th>
						<th>Numero</th>
						<th>Voie</th>
						<th>Code Postal</th>
						<th>Ville</th>
						<th>Date</th>
						<th>Nombre de places</th>
						<th>Prix</th>
						<th>Action</th>

					</tr>
				</thead>

				<tbody align="center">
					<c:forEach items="${logements}" var="l">

						<tr>
							<td>${l.id}</td>
							<td>${l.adresse.numero}</td>
							<td>${l.adresse.voie}</td>
							<td>${l.adresse.cp}</td>
							<td>${l.adresse.ville}</td>
							<td>${l.date}</td>
							<td>${l.nbPlaces}</td>
							<td>${l.prix}</td>
							<td><a href="gestionLogement?id=${l.id}"><button
										type="button" class="btn btn-primary">Modifier</button></a>
								<form action='gestionLogement' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${l.id}'> <input
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

			<form action="gestionLogement" method="post" id="addFormLogement"
				style="display: none" align="center">

				<input type="hidden" name="tache" value="insert">

				<div>
					Numéro : <input required type="text" name="numero">
				</div>
				<div>
					Voie : <input required type="text" name="voie">
				</div>
				<div>
					CP : <input required type="text" name="cp">
				</div>
				<div>
					Ville : <input required type="text" name="ville">
				</div>
				<div>
					Date : <input required type="date" name="date">
				</div>
				<div>
					Nombre de places : <input required type="number" name="nbPlaces"
						min=0 max=99>
				</div>
				<div>
					Prix : <input required type="number" name="prix" min=0 max=999
						step=0.01> €
				</div>

				<input type="submit" class="btn btn-success mb-2"
					value="Ajouter un logement"> <input type="reset"
					class="btn btn-danger button">

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
		$("#addFormLogement").show();
	}
</script>
