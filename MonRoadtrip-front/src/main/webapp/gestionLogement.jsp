<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <title>Gestion des logements</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
    crossorigin="anonymous"></script>

  <link href="Style.css" rel="stylesheet">

</head>
<div class="page">
<main>
  <header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
      <a class="navbar-brand" href="Roadtrip.html">Accueil</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto"> </ul>

        <form class="form-inline mt-2 mt-md-0">
            <a href="gestioncompte.html" style="color: white">
          <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Gestion de compte</a></button>
          <a class="nav-link" href="connexion.html" style="color: white">Deconnexion</a>
        </form>
      </div>
    </nav>
  </header>



    <div>
     
    <h2 class="titre" align="center">Liste des logements </h2>
    </div>

    <table border="1px" align="center" width="90%">


        <thead>
          <tr align="center">
            <th>Id</th>
            <th>numero</th>
            <th>voie</th>
            <th>cp</th>
            <th>ville</th>
            <th>date</th>
            <th>nombre de places</th>
            <th>prix</th>
            <th>action</th>

          </tr>
        </thead>
        
        <tbody align="center">
        	<c:forEach items="${logements}" var="l">

            <tr>
                <td>${l.id}</td>
                <td>${l.numero}</td>
                <td>${l.voie}</td>
                <td>${l.cp}</td>
                <td>${l.ville}</td>
                <td>${l.date}</td>
                <td>${l.nbPlaces}</td>
                <td>${l.prix}</td>
                <td><a href="updateLogement.html"><button type="button" class="btn btn-primary">Modifier</button></a>
                <button type="button" class="btn btn-danger">Supprimer</button></td>
              </tr>
              
              </c:forEach>
              


        </tbody>
        </table>

        
        
        <br>
	<div id="ajouter">
		<input type="button" value="Ajouter" id="btnShowAddForm" class="btn btn-info button">
	</div>
	<br> <br>


	<form action="logement" method="post" id="addFormLogement">
		<input type="hidden" name="tache" value="insert">

		<div>
			Numéro : <input required type="text" name="numero">
		</div>
		<div>
			Voie : <input required type="text"
				name="voie">
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
			Nombre de places : <input required type="number" name="nbPlaces" min=0 max=99>
		</div>
		<div>
			Prix : <input required type="number" name="prix" min=0 max=999 step=0.01> €
		</div>




		<input type="submit" class="btn btn-success mb-2"
			value="Ajouter un logement"> <input type="reset"
			class="btn btn-danger button">

	</form>
</main>
</div>


<script>

	btnShowAddForm.onclick = function() {
		$("#addFormLogement").show();
	}
</script>
