<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="UTF-8" />
<title>Gestion de stage - Yaya/Defraene</title>
<!-- Info Fichier
			Createur			: DIALO THIERNO Yaya - DEFRAENE Michael
			Classe				: 3eme Informatique de Gestion
            Projet				: JEE - Gestion de stages
			Cours				: SGBD (PL/SQL) - JEE
			Maitre Assistant	: Mme Copin - Mme Vandevorst
			Languages			: HTML5 / CSS3 / JEE
			Date Creation		: 02 Janvier 2017
		-->
<link rel="stylesheet" type="text/css" href="IncCss/loginCss.css">
</head>
<body>
	<div id="page">
		/<img src="./image/logo.jpg" />
		<form method="GET" action="acceuille">
			<fieldset>
				<legend>Connexion</legend>
				<p>Please enter your credentials</p>
				<input id="txt_usn" name="txt_usn" type="text"
					placeholder="Nom d'utilisateur" /> <input id="txt_pwd"
					name="txt_pwd" type="password" placeholder="Mot de passe" /> <span
					class="erreur"> <c:out value="${error}" />
				</span> <input id="btnlogin" name="btnlogin" type="submit" value="Login"
					onclick="" />
			</fieldset>
		</form>

	</div>

</body>
</html>