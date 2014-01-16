define(function(require, exports, module) {
    var modal = require('./modal');
    var pagination = require('./pagination');
    var dropdownToggle = require('./dropdown-toggle');

    module.exports = angular.module('bootstrap', [modal.name, pagination.name, dropdownToggle.name]);

});