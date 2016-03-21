var mysql = require('../utils/mysql.utils')
    Q     = require('q');

var REGEX_CATEGORY = new RegExp("^[a-z]*$");

exports.getProduct = function (productId){
  var defer = Q.defer();

  var request = 'SELECT * FROM PRODUCT WHERE PRD_ID = :prdId';

  mysql.query(request, {prdId: productId}, function(err, result, fields) {
    if (err) {defer.reject(err);}
    defer.resolve(result[0]);
  });

  return defer.promise;
};


exports.getCommentsFromProduct = function (productId){
  var defer = Q.defer();

  var request = 'SELECT * FROM COMMENTS comments ';
  request += 'INNER JOIN SECU_USERS users on comments.USR_ID=users.USR_ID ';
  request += 'WHERE PRD_ID = :prdId';
  mysql.query(request, {prdId: productId}, function(err, result, fields) {
    if (err) {
      console.error(err);
      defer.reject(err);
    }
    defer.resolve(result);
  });

  return defer.promise;
};


exports.listProducts = function (category) {
  var defer = Q.defer();

  var request = "SELECT PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE, PRD_IMAGE, PRD_CATEGORY FROM PRODUCT ";
  if(category) {
    request += " WHERE PRD_CATEGORY='" + category + "'";
  }

  console.log('SQL request = ', request);
  mysql.query(request, function(err, rows, fields) {
    if (err) { defer.reject(err);}
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