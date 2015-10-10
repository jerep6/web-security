$(document)
    .ready(
        function() {
          $(".hint .hint-content").addClass("nodisplay");

          $(".hint .hint-title")
              .append(
                  ' <i title="Cliquez pour voir l\'indice" class="hint-action hint-closed glyphicon glyphicon-eye-open"></i>')

          $(".hint .hint-action").click(
              function() {
                $(this).parents(".hint").find(".hint-content").toggleClass(
                    "nodisplay");
              });
		  chargerUserEnSession();
        });
		
		
// Charger utilisateur en session
function chargerUserEnSession(){
	if (cookiesSite.getUserAvatarCourant() == "oscar"){
		// Connection en tant qu'Oscar
		chargerUserOscar();
	} else if(cookiesSite.getUserAvatarCourant() == "alice"){
		// Connection en tant qu'Alice
		chargerUserAlice();
	} else {
		// Pas de cookie. Connection en tant qu'Oscar
		chargerUserOscar();
	}
}

// Changer d'utilisateur
function changerUser(){
	// Deconnexion
	if (cookiesSite.getUserAvatarCourant() == "oscar"){
		document.cookie = 'JSESSIONID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		// Connection en tant qu'Alice
		chargerUserAlice();
	}
	else if (cookiesSite.getUserAvatarCourant() == "alice"){
		document.cookie = 'JSESSIONID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		// Connection en tant qu'Oscar
		chargerUserOscar();
	}
}
	
// Charger la connection en tant qu'Oscar
function chargerUserOscar(){
	$(".user_connected").attr("src", "/resources/img/users/oscar.png");
	//$(".container").css("backgroundColor", "#259325");
	cookiesSite.saveUserAvatarOscarCourant("oscar");
}

// Charger la connection en tant qu'Alice
function chargerUserAlice(){
	$(".user_connected").attr("src", "/resources/img/users/alice.png");
	//$(".container").css("backgroundColor", "#FF4791");
	cookiesSite.saveUserAvatarOscarCourant("alice");
}