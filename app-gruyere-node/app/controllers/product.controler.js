'use strict';

exports.homePage = function(req, res) {
  res.render('home-page', { title: 'Express' });
};

exports.productDetails = function(req, res) {
  res.render('product-details-page', {
    title: 'Produit ' +req.params.productId,
    product: {
      name: "chaussures",
      price: "35€"
    }
  });
};
