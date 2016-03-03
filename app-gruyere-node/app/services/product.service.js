'use strict';
var productRepository = require('../repositories/product.repository');

exports.getProduct = function (productId) {
  return {
    'name': "chaussure",
    'price': "30€",
    'comments': [{'id': "1", 'label': "super !"}]
  };
};

exports.listProducts = function (category) {
  return productRepository.listProducts(category)
};
