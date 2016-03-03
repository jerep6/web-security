'use strict';

var userService = require("../services/user.service"),
    _ = require('lodash');


exports.authent = function(req, res) {

  userService.getUser(req.query.login, req.query.password)
    .then(function(user) {
      if(user) {
        var sessionUser = _.pick(user, ['USR_ID', 'USR_LOGIN']);
        req.session.user = sessionUser;
        res.status(200).json(sessionUser);
      }
      else {
        res.status(404).json({"error" : "User not found"});
      }
  });
};
