'use strict';

var productService = require('../services/product.service'),
    safetyUtils = require('../utils/safety.utils'),
    entities = new (require('html-entities').XmlEntities)();

exports.homePage = function(req, res) {
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
    res.render('product-list-page', {
        title: product.name,
        product: data,
        category: req.query.category
        //category: safetyUtils.sanitizeString(req.query.category)
        //category: entities.encode(req.query.category)
    });
  }).catch(function(e) {
      console.log(e);
  });
};
