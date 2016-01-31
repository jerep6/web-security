var mysql = require('../app/utils/mysql.utils'),
  fs = require("fs"),
  path = require('path');

var databaseFile = path.join(__dirname, '../scripts/database.sql');
var dabaseScriptContent = fs.readFileSync(databaseFile, "utf8")


mysql.query(dabaseScriptContent, function (err, rows, fields) {
  if (err) {
    throw err;
  }
  console.log('Database update');
  process.exit(0);
});