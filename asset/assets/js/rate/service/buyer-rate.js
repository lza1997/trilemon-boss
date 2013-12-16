/**
 * 中差评
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var BASE_URL = '/rate/buyer-rates';
        var URL = BASE_URL + '/:id';
        var AUTO_URL = BASE_URL + '/auto';
        var MANUAL_URL = URL + '/manual';

        var BuyerRate = $resource(URL, {id: '@id'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            },

            auto: {
                method: 'POST',
                url: AUTO_URL
            },

            manual: {
                method: 'POST',
                url: MANUAL_URL
            }
        });

        BuyerRate.refreshCurrPage = paginateResource.refreshCurrPage;

        return BuyerRate;
    }];
});