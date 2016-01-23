'use strict';

/**
 * Module dependencies.
 */
var _ = require('lodash'),
  glob = require('glob');


/**
 * Get files by glob patterns
 */
exports.getGlobbedFiles = function (globPatterns, replaceRoot) {
  // For context switching
  var _this = this;

  // URL paths regex
  var urlRegex = new RegExp('^(?:[a-z]+:)?//', 'i');

  // The output array
  var output = [];

  // If glob pattern is array so we use each pattern in a recursive way, otherwise we use glob
  if (_.isArray(globPatterns)) {
    globPatterns.forEach(function (globPattern) {
      output = _.union(output, _this.getGlobbedFiles(globPattern, replaceRoot));
    });
  } else if (_.isString(globPatterns)) {
    if (urlRegex.test(globPatterns)) {
      output.push(globPatterns);
    } else {
      var files = glob.sync(globPatterns, {follow: true});
      if (replaceRoot) {
        files = files.map(function (file) {
          if (_.isArray(replaceRoot)) {
            replaceRoot = _.filter(replaceRoot, function (root) {
              return file.indexOf(root.sourcePath) === 0;
            });
            replaceRoot = replaceRoot[0];
          }
          return file.replace(replaceRoot.sourcePath, replaceRoot.replacePath);
        });
      }

      output = _.union(output, files);
    }
  }

  return output;
};