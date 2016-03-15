'use strict';

var productService = require('../services/product.service'),
    safetyUtils = require('../utils/safety.utils'),
    entities = new (require('html-entities').XmlEntities)();

exports.homePage = function(req, res, next) {
  productService.listProductsHome()
    .then(function(data) {
      res.render('home-page', {
        title: 'Vente en ligne',
        products: data
      });
  }).catch(next);
};

exports.productDetails = function(req, res, next) {
  var product = productService.getProduct(req.params.productId);

  product.then(function(data) {
    res.render('product-details-page', {
      'title': product.name,
      'product': data
    });
  }).catch(next);
};

exports.productsByCategory = function(req, res, next) {
  var product = productService.listProductsByCategory(req.query.category);

  product.then(function(data) {
    res.render('product-list-page', {
        title: product.name,
        products: data,
        category: req.query.category
        //category: safetyUtils.sanitizeString(req.query.category)
        //category: entities.encode(req.query.category)
    });
  }).catch(next);
};

exports.addComment = function(req, res, next) {
  req.session.user = {'USR_ID': '1'};

  // Check form data
  var error;
  if(!req.session['user'] || !req.session['user']['USR_ID']) {
    error = 'Veuillez vous connectez avant de poster un commentaire';
  }
  else if(!req.body['prd_id'] || !req.body['comment']) {
    error = 'Veuillez remplir tous les champs.';
  }

  if(error) {
    req.session['comment_error'] = error;
    res.redirect(302, req.headers['referer'] || '/');
  }
  else {
    productService.addComment(req.body['prd_id'], req.body['comment'], req.session['user']['USR_ID'])
      .then(function(data) {
        res.redirect(302, req.headers['referer'] || '/');
    }).catch(next);
  }

};
