var mysql      = require('mysql');

var connection = mysql.createConnection({
  host     : 'vm',
  port     : '3307',
  user     : 'secu',
  password : 'secu',
  database : 'secu',
  multipleStatements: true
});

connection.connect();
module.exports = connection;