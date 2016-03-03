var mysql = require('../utils/mysql.utils')
    Q     = require('q');


exports.listProducts = function (category) {
  var defer = Q.defer();

  var request = 'SELECT * FROM PRODUCT';

  if(category) {
    request += 'WHERE PRD_CATEGORY="'+category+'"';
  }

  mysql.query(request, function(err, rows, fields) {
    if (err) {
      defer.reject(err);
    }

    defer.resolve(rows);
  });

  return defer.promise;
};