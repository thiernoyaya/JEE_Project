<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu_SchoolCoordinatrice.jsp"%>
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
		<p>
			LES INFORAMTIONS DE STAGE DE L'ETUDIANT
			<c:out value="${etudiant}" />
		</p>
		<table>
			<tr>
				<td>Nom entreprise : <c:out value="${stage.getEntName()}" />
				</td>
			</tr>
			
			<tr>
				<td>Pays       : <c:out value="${stage.getEntCountry()}" />
				</td>
			</tr> 
			<tr>
				<td>Ville       : <c:out value="${stage.getEntCity()}" />
				</td>
			</tr> 
			
			<tr>
				<td>Rue       : <c:out value="${stage.getEntStreet()}" />
				</td>
			</tr> 
			
			
			<tr>
				<td>Nom Superviseur : <c:out
						value="${stage.getEntSpvName()}" />
				</td>
			</tr>
			<tr>
				<td>Email Superviseur : <c:out
						value="${stage.getEntSpvMail()}" />
				</td>
			</tr>
			<tr>
				<td>Tél Superviseur : <c:out
						value="${stage.getEntSpvTel()}" />
				</td>
			</tr>
			<tr>
				<td>Thème du TFE : <c:out value="${stage.getTfeTheme()}" />
				</td>
			</tr>

		</table>

	</div>
</body>
</html>