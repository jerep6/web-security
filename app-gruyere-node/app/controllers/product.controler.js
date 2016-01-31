'use strict';

var productService = require("../services/product.service");


exports.homePage = function(req, res) {
  res.render('home-page', { title: 'Express' });
};

exports.productDetails = function(req, res) {
  var product = productService.getProduct(req.params.productId);
  res.render('product-details-page', {
      'product': product,
      'title': product.name
  });
};

exports.productsByCategory = function(req, res) {
  var product = productService.productsByCategory(req.query.c || 'chaussure');

  product.then(function(data) {
    console.log('data', data);
    res.render('product-details-page', {
        'product': product,
        'title': product.name,
        'data': data
    });
  })
    .catch(function(e) {
      console.log(e);
    });
};
