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
		<form method="POST" action="createStage">
			<fieldset>
				<legend>Informations Personnelles</legend>
				<p>veuillez saisir vos informations .</p>
				<input id="email" name="email" type="email"
					placeholder="votre email personnel*" /> <input id="tel" name="tel"
					type="text" placeholder="Tel*" /> <input id="rue" name="rue"
					type="text" placeholder="rue*" /> <input id="nrue" name="nrue"
					type="text" placeholder="N° rue*" /> <input id="ville" name="ville"
					type="text" placeholder="ville*" /> <br />
				<br /> <label>Selectionner votre professeur de Stage</label> <select
					id="professeur" name="professeur">
					<option></option>
					<c:forEach items="${listSpv}" var="p">
						<option>
							<c:out value="${p.usn}" />
						</option>
					</c:forEach>
				</select> <br />
				<br /> <label>Selectionner une coordinatrice </label> <select
					id="coordinatrice" name="coordinatrice">
					<c:forEach items="${listCoord}" var="p">
						<option>
							<c:out value="${p.usn}" />
						</option>
					</c:forEach>
				</select> <span class="erreur"> <c:out value="${error}" />
				</span> <input id="btnValider" type="submit" value="Valider" onclick="" />
			</fieldset>
		</form>
	</div>
</body>
</html>
