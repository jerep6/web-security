'use strict';

var _ = require('lodash');

exports.sanitizeString = function (unsafeString) {
  return (unsafeString || '').replace(/script/g, '');
};

exports.escape = function(val) {
  return val.replace(/[&"'<>]/g, function(ch) {
    return ({
      '&': '&amp;',
      '"': '&quot;',
      '\'': '&#39;',
      '<': '&lt;',
      '>': '&gt;'
    })[ch];
  });
};