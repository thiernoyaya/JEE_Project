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
<link rel="stylesheet" type="text/css" href="IncCss/createStage.css">
</head>
<body>
	<div id="formulaire">
		<p>VOS INFORMATIONS DE STAGE</p>
		<table>
			<tr>
				<td>Nom entreprise : <c:out value="${stage.getEntName()}" />
				</td>
			</tr>
			<tr>
				<td>nom Superviseur : <c:out
						value="${stage.getEntSupervisorName()}" />
				</td>
			</tr>
			<tr>
				<td>Email Superviseur : <c:out
						value="${stage.getEntSupervisorMail()}" />
				</td>
			</tr>
			<tr>
				<td>T�l Superviseur : <c:out
						value="${stage.getEntSupervisorTel()}" />
				</td>
			</tr>
			<tr>
				<td>Th�me du TFE : <c:out value="${stage.getTFETheme()}" />
				</td>
			</tr>

		</table>

	</div>
</body>
</html>