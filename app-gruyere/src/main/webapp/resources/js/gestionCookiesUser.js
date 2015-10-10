/** *************************************************** */
/* Librairie de gestion des cookies spécifique du site */
/* nécessite l'import de : */
/* jquery.js */
/* jquery.cookie.js */
/** *************************************************** */

/** ****************************************************** */
/* Création d'un objet Jquery de gestion des onglets */
/** ****************************************************** */

var cookiesSite = {
    /* nom et paramétrage du cookie user avatar */
    COOKIE_NAME_USER_AVATAR : "USER",
    COOKIE_OPTIONS_USER_AVATAR : {
        path : '/',
        domain : "localhost",
        secure : false,
        expires : 365
    },
    /* Récupère le user avatar courant en cookie */
    getUserAvatarCourant : function() {
        /* lecture du cookie */
        var usr = $.cookie(this.COOKIE_NAME_USER_AVATAR);
        if (usr == null) {
            /* cookie n'existe pas ou est vide */
        	usr = "";
        }
        return usr;
    },
    /* Sauvegarde du user avatar Oscar dans le cookie */
    saveUserAvatarOscarCourant : function(userName) {
        this.deleteUserAvatarCourant();
        /* on écrit à la racine et on ne définie pas de expires donc le cookie est de type session */
        $.cookie(this.COOKIE_NAME_USER_AVATAR, userName, this.COOKIE_OPTIONS_USER_AVATAR);
    },
    /* Delete du user avatar courant dans le cookie */
    deleteUserAvatarCourant : function() {
    	console.log(document.cookie);
        $.cookie(this.COOKIE_NAME_USER_AVATAR, null, {
            path : '/',
            domain : "localhost",
            secure : false,
            expires : -1
        });
        console.log(document.cookie);
    }
};
