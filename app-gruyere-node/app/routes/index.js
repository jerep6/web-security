'use strict';
var logger = require('../../logger');

module.exports = function(app) {
  var productController = require('../controllers/product.controler');
  var userController = require('../controllers/user.controler');

  app.get('/', productController.homePage);
  app.get('/products/:productId', productController.productDetails);
  app.get('/products', productController.productsByCategory);


  app.get('/api/authent/', userController.authent);
  app.post('/api/comments/', productController.addComment);

};
