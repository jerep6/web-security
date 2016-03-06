'use strict';

var productService = require("../services/product.service");


exports.homePage = function(req, res) {
  var products = productService.getAllProducts();
  res.render('home-page', {
      'title': 'App Gruyere Home',
      'products': products
  });
};

exports.productDetails = function(req, res) {
  var product = productService.getProduct(req.params.productId);
  res.render('product-details-page', {
      'title': product.name,
      'product': product
  });
};

exports.productsByCategory = function(req, res) {
  var product = productService.productsByCategory(req.query.c || 'chaussure');

  product.then(function(data) {
    console.log('data', data);
    res.render('product-details-page', {
        'title': product.name,
        'product': product,
        'data': data
    });
  })
    .catch(function(e) {
      console.log(e);
    });
};
