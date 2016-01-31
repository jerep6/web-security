'use strict';
var productRepository = require('../repositories/product.repository');

exports.getProduct = function (productId) {
  return {
    'name': "chaussure",
    'price': "30€",
    'comments': [{'id': "1", 'label': "super !"}]
  };
};

exports.productsByCategory = function (category) {
  return productRepository.productsByCategory(category)
};
