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