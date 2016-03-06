'use strict';
var productRepository = require('../repositories/product.repository');

exports.getProduct = function (productId) {
  return {
    'name': "chaussure",
    'price': "30€",
    'comments': [{'id': "1", 'label': "super !"},{'id': "2", 'label': "Quels sont les délais de livraison"}]
  };
};

exports.listProducts = function (category) {
  return productRepository.listProducts(category)
};

exports.addComment = function (productId, comment, userId) {
  return productRepository.addComment(productId, comment, userId);
};
