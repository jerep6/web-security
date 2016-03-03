'use strict';
var userRepository = require('../repositories/user.repository');

exports.getUser = function (login, password) {
  return userRepository.getUser(login, password);
};
