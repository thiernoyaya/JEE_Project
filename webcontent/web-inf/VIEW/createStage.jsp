<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu_contexte.jsp"%>
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
		<form method="POST" action="stageInfo">
			<fieldset>
				<legend>Informations Stage "${resultat.getFirstName()}"</legend>
				<p>vos informations ont étés bien encodées. veuillez à présent
					saisir vos infos de stage.</p>
				<input id="entname" name="entname" type="text"
					placeholder="Nom de l'entrepries(*)" /> <input id="entspvname"
					name="entspvname" type="text" placeholder="Nom du superviseur*" />
				<input id="entspvmail" name="entspvmail" type="email"
					placeholder="Mail du superviseur*" /> <input id="entspvtel"
					name="entspvtel" type="tel" placeholder="Tel superviseur*" /> <input
					id="entcountry" name="entcountry" type="text" placeholder="Pays*" />
				<input id="entcity" name="entcity" type="text" placeholder="Ville*" />
				<input id="entstreet" name="entstreet" type="text"
					placeholder="Rue*" /> <input id="entstreetnb" name="entstreetnb"
					type="number" placeholder="N° Rue*" /> <input id="entzipcode"
					name="entzipcode" type="number" placeholder="Code Postal*" /><br />

				<input id="datebeg" name="datebeg" type="date"
					placeholder="Date début du Stage*" /> <input id="dateend"
					name="dateend" type="date" placeholder="Date fin du Stage*" /> <input
					id="tfetheme" name="tfetheme" type="text"
					placeholder="Thème du TFE" /> <input id="btnValider" type="submit"
					value="Valider" onclick="" />
			</fieldset>
		</form>
	</div>
</body>
</html>

