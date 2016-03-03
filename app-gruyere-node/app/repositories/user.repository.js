var mysql = require('../utils/mysql.utils')
    Q     = require('q');


exports.getUser = function (login, password) {
  var defer = Q.defer();

  var request = 'SELECT * FROM SECU_USERS WHERE USR_LOGIN="'+login+'" AND USR_PWD="'+ password+'"';
  mysql.query(request, function(err, rows, fields) {
    if (err) {
      defer.reject(err);
    }

    defer.resolve(rows[0]);
  });

  return defer.promise;
};