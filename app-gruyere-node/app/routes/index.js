'use strict';

module.exports = function(app) {
  var controller = require('../controllers/product.controler');
  app.get('/', controller.homePage);
  app.get('/product/:productId', controller.productDetails);
  app.get('/product/', controller.productsByCategory);
};
