<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Connexion</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="Style.css">

</head>

<c:if test="${connected.getClass().getSimpleName()=='Client'}">
	<c:redirect url = "gestionRoadtrip.html"/>
</c:if>
<c:if test="${connected.getClass().getSimpleName()=='Hote'}">
	<c:redirect url = "gestionLogement.jsp"/>
</c:if>
<c:if test="${connected.getClass().getSimpleName()=='Organisateur'}">
	<c:redirect url = "organisateur.html"/>
</c:if>

<body id="bodyConnexion">

  <div id="connexion">

    <h1>Connexion</h1>

    <form action="connexion" method="post" id=formConnexion>

      <table>
        <tbody>
          <tr>
            <div class="my-3">
              <label type="email" class="sr-only" for="inlineFormInputGroupUsername">Identifiant</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <div class="input-group-text">@</div>
                </div>
                <input name="mail" type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
              </div>
            </div>
          </tr>
          <tr>
            <div class="my-1">
              <label type="password" class="sr-only" for="inlineFormInputGroupUsername">Mot de passe</label>
              <div class="input-group">
                <input name="password" type="password" class="form-control" id="inlineFormInputGroupUsername" placeholder="Mot de passe">
              </div>
            </div>
          </tr>
        </tbody>
      </table>

      <br>
	 <div id="errorConnect">${error}</div>
	 
      <div class="form-row">
        <div class="form-group col-lg-4">
          <a  href="Roadtrip.html"><button type="button" class="btn btn-warning btnConnexion">Retour</button></a>
        </div>
        <div class="form-group col-lg-8">
          <button type="submit" class="btn btn-primary btnConnexion">Se connecter</button>
        </div>
      </div>
      
    </form>

  </div>
</body>
</html>