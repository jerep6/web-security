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
