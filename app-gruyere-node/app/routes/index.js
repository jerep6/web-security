'use strict';

module.exports = function(app) {
  var productController = require('../controllers/product.controler');
  var userController = require('../controllers/user.controler');
  app.post('/api/comments/', productController.addComment);

  app.get('/', productController.homePage);
  app.get('/product/:productId', productController.productDetails);
  app.get('/product/', productController.productsByCategory);


  app.get('/api/authent/', userController.authent);

};
