'use strict';
var productRepository = require('../repositories/product.repository');

exports.getProduct = function (productId) {
  return {
    'name': "chaussure",
    'price': "30€",
    'comments': [{'id': "1", 'label': "super !"},{'id': "2", 'label': "Quels sont les délais de livraison"}]
  };
};

exports.listProductsHome = function () {
  return productRepository.listProducts();
};

exports.listProductsByCategory = function (categ) {
  return productRepository.listProducts(categ);
};

exports.addComment = function (productId, comment, userId) {
  return productRepository.addComment(productId, comment, userId);
};
