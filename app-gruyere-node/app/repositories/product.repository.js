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

exports.addComment = function (productId, comment, userId) {
  var defer = Q.defer();

  var request = 'INSERT INTO COMMENTS (COM_CONTENT, PRD_ID, USR_ID) VALUES (:comment, :prd, :usr)';
  mysql.query(request, {comment: comment, prd: productId, usr: userId}, function(err, result, fields) {
    if (err) {
      console.error(err);
      defer.reject(err);
    }

    console.log('mysql result ', result);
    defer.resolve(result);
  });

  return defer.promise;
};