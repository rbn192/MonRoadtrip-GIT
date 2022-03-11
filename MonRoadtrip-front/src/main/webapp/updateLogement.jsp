<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <title>Gestion des logements</title>

  <body id="bodyGestionCompte">

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="Roadtrip.html">Accueil</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
          aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto"> </ul>

          <form class="form-inline mt-2 mt-md-0">
            <a class="nav-link" href="gestioncompte.html" style="color: white">Connecté : Hote</a>
            <a class="nav-link" href="gestionLogement.html" style="color: white">Mes logements</a>
            <a class="nav-link" href="connexion.html" style="color: white">Se déconnecter</a>
          </form>
        </div>
      </nav>
    </header>

    <br>

    <div id="gestionCompte">
      <h1>Modification du logement</h1>

      <form id=formGestionCompte>
      	<input type="hidden" name="tache" value="update">
		<input type="hidden" name="id" value="${logement.id}">
		<input type="hidden" name="version" value="${logement.version}">

        <table id="infos">
          <tr>
            <td>Numero :</td>
            <td><input name="numero" type="text" value="${logement.numero}"></td>
            
          </tr>
          <tr>
            <td>Voie :</td>
            <td><input name="voie" type="text" value="${logement.voie}"></td>
          </tr>
          <tr>
            <td>Ville :</td>
            <td><input name="ville" type="text" value="${logement.ville}"></td>
          </tr>
          <tr>
            <td>CP :</td>
            <td><input name="cp" type="text" value="${logement.cp}"></td>
          </tr>
          <tr>
            <td>Nombre de places :</td>
            <td><input name="nbPlaces" type="number" value="${logement.nbPlaces}" min=0 max=99></td>
          </tr>
          <tr>
            <td>Prix :</td>
            <td><input name="prix" type="number" value="${logement.prix}" min=0 max=999 step=0.01> €</td>
          </tr>
        </table>
        
        <br> <br>


		<div>
			<input type="submit" value="Valider" class="btn btn-success button">
			<input type="reset" class="btn btn-danger button"> <a
				href="activite"><input type="button" value="Retour"
				class="btn btn-primary button"></a>
		</div>
      </form>
    </div>
  </body>