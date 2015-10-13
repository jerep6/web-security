//"oscar" - Oscar, "alice" - Alice 

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

          $(document).on("click", ".user_connected_ban img", changerUser);
          chargerUserEnSession();
        });

// Charger utilisateur en session
function chargerUserEnSession() {
  if ($.cookie("USER") == "oscar") {
    // Connection en tant qu'Oscar
    chargerUserOscar();
  }
  else if ($.cookie("USER") == "alice") {
    // Connection en tant qu'Alice
    chargerUserAlice();
  }
}

// Changer d'utilisateur
function changerUser() {
  // Deconnexion
  $.cookie("JSESSIONID", null, {
    path : '/'
  });
  if ($.cookie("USER") == "alice") {
    // Connection en tant qu'Oscar
    chargerUserOscar();
  }
  else {
    // Connection en tant qu'Alice
    chargerUserAlice();
  }
}

// Charger la connection en tant qu'Oscar
function chargerUserOscar() {
  $(".user_connected").attr("src", "/resources/img/users/oscar.png");
  $(".container").css("backgroundColor", "#259325");
  $.cookie("USER", "oscar", {
    path : '/',
    expires : 365
  });
}

// Charger la connection en tant qu'Alice
function chargerUserAlice() {
  $(".user_connected").attr("src", "/resources/img/users/alice.png");
  $(".container").css("backgroundColor", "#FF4791");
  $.cookie("USER", "alice", {
    path : '/',
    expires : 365
  });
}