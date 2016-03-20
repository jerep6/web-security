'use strict';
var productRepository = require('../repositories/product.repository');
var Q = require('q');

exports.getProduct = function (productId) {
  var promises = [
    productRepository.getProduct(productId),
    productRepository.getCommentsFromProduct(productId)
  ];

  return Q.all(promises).spread(function(product, comments){
    product.comments = comments;
    return product;
  })
};

exports.listProductsHome = function () {
  return productRepository.listProducts();
};

exports.listProductsByCategory = function () {
  //TODO : call repository with categ parameter
  return Q.resolve([]);
};

exports.addComment = function (productId, comment, userId) {
  return productRepository.addComment(productId, comment, userId);
};
