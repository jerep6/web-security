'use strict';
//var productRepository = require('../repositories/product.repository');

exports.getAllProducts = function (){
  return [
    {
      'name': "chaussure",
      'price': "30€",
      'comments': [{'id': "1", 'label': "super !"}]
    },
    {
      'name': "sac",
      'price': "10€",
      'comments': [{'id': "1", 'label': "beau"}]
    }
  ];
}

exports.getProduct = function (productId) {
  return {
    'name': "chaussure",
    'price': "30€",
    'comments': [{'id': "1", 'label': "super !"},{'id': "2", 'label': "Quels sont les délais de livraison"}]
  };
};

exports.productsByCategory = function (category) {
  return null;
  // return productRepository.productsByCategory(category)
};
