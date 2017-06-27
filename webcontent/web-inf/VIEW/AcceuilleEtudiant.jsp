<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu_contexte.jsp"%>
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
<link rel="stylesheet" type="text/css"
	href="IncCss/acceuilleStudent.css">
</head>
<body>
	<div id="explication">
		<h2>
			Bienvenue
			<c:out value="${Usersession.usn}" />
		</h2>
		<p>Ceci est une plateforme de gestion des stages. elle a pour
			objectif de faciliter la communication entre les différents acteurs
			impliquer dans le processus des stages. d'autre part elle met aussi à
			la disposition des étudiants une liste d'entreprise dont ils
			pourraient solliciter un stage. Avec cette outil, l'étudiant pourra
			directement saisir les informations de son stage, son professeur
			encadrant, ainsi le soumettre directement à la coordinatrice de stage
			pour l'envoi des conventions.</p>
	</div>
</body>
</html>