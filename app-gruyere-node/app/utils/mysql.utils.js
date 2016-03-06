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
// For custom parameters :param_name
connection.config.queryFormat = function (query, values) {
  if (!values) return query;
  return query.replace(/\:(\w+)/g, function (txt, key) {
    if (values.hasOwnProperty(key)) {
      return this.escape(values[key]);
    }
    return txt;
  }.bind(this));
};

module.exports = connection;