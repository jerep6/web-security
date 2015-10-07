var user_connected = 1; //1 - Alice, 2-Oscar 

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

        });
		
		
function changeUser(){
	if (user_connected == 1){
		// Connection en tant qu'Oscar
		$(".user_connected").attr("src", "/resources/img/users/oscar.png");
		user_connected = 2;
		$(".container").css("backgroundColor", "#f3f3f3");
	}
	else if (user_connected == 2){
		// Connection en tant qu'Alice
		$(".user_connected").attr("src", "/resources/img/users/alice.png");
		user_connected = 1;
		$(".container").css("backgroundColor", "#fff8f5");
	}
//a propager sur toutes les pages
//TODO deconnexion & changement d'image
}