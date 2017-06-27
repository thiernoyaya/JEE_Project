<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
            !!! CE FICHIER EST UN EXEMPLE POUR LES 3 FENETRES (ETUDIANT / SUPERVISEUR / COORDINATEUR) !!!
		-->
<link rel="stylesheet" type="text/css" href="IncCss/menu_contexte.css">
</head>
<body>
	<div id="page">
		<div id="titre">
			<h3>Plateforme de gestion des stages</h3>
		</div>
		<div id="menu">
			<img src="./image/logo.jpg" />/
			<form method="get" action="totalStage">
				<input id="infoStage" name="infoStage" type="submit"
					value="Liste des etudiants stagiaires" onclick="" />
			</form>
			<form action="deconnexion">
				<input id="quitter" name="quitter" type="submit"
					value="Se deconnecter" onclick="" />
			</form>
		</div>
		<div id="wrapper"></div>
	</div>
</body>
</html>