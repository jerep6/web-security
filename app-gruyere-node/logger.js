'use strict';

var winston = require('winston');

var logger = new winston.Logger({
  levels: {
    error: 0,
    warn: 1,
    info: 2,
    debug: 4
  },
  transports: [],
  exitOnError: false
});

logger.add(winston.transports.Console, {
    handleExceptions: true,
    humanReadableUnhandledException: true,
    level: 'debug',
    timestamp: function () {
      return new Date().toISOString();
    },
    colorize: true,
    json: true
  }
);
logger.debug('Debug mode is activated');
module.exports = logger;
