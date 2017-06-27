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
<link rel="stylesheet" type="text/css"
	href="IncCss/acceuilleStudent.css">
</head>
<body>
	<div id="explication">
		<h2>liste des stagiaires</h2>
		<form method="GET" action="displayInfoStage">
			<table>
				<tr>
					<th></th>
				</tr>

				<c:forEach items="${lisOfStudent}" var="p">
					<tr>
						<td><input id="createStage" name="createStage" type="submit"
							value="<c:out value="${p.usn}"/>" onclick="" /></td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>
</body>
</html>
