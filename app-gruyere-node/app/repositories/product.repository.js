var mysql = require('../utils/mysql.utils')
    Q     = require('q');


exports.productsByCategory = function (category) {
  var defer = Q.defer();

  mysql.query('SELECT * FROM PRODUCT WHERE PRD_CATEGORY="'+category+'"', function(err, rows, fields) {
    if (err) {
      defer.reject(err);
    }

    console.log('---->', rows);
    defer.resolve(rows);
  });

  return defer.promise;
};