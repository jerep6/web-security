'use strict';

var productService = require("../services/product.service");


exports.homePage = function(req, res) {
  res.locals.session = req.session;
  console.log('--->', req.session);

  var product = productService.listProducts();
  product.then(function(data) {
    res.render('home-page', {
      'title': product.name,
      'products': data
    });
  }).catch(function(e) {
    console.log('Error', e);
  });
};

exports.productDetails = function(req, res) {
  var product = productService.getProduct(req.params.productId);
  res.render('product-details-page', {
      'product': product,
      'title': product.name
  });
};

exports.productsByCategory = function(req, res) {
  var product = productService.listProducts(req.query.c);

  product.then(function(data) {
    console.log('data', data);
    res.render('product-details-page', {
        'title': product.name,
        'product': data
    });
  }).catch(function(e) {
      console.log(e);
  });
};
