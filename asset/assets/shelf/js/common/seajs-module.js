angular.module('common').config(['$controllerProvider', '$compileProvider', '$filterProvider', '$provide',
    function($controllerProvider, $compileProvider, $filterProvider, $provide) {

        var register = {
            controller: $controllerProvider.register,
            directive: $compileProvider.directive,
            filter: $filterProvider.register,
            factory: $provide.factory,
            service: $provide.service,
            decorator: $provide.decorator
        };

        $provide.factory('$SeajsModule', ['$rootScope', '$q', function($rootScope, $q) {
            var SeajsModule = function(moduleUrl) {
                this.moduleUrl = moduleUrl;
            };

            SeajsModule.prototype = {
                constructor: SeajsModule,

                routeFor: function(controllerName) {
                    var _this = this;
                    return {
                        controller: controllerName,
                        resolve: {
                            $template: ['$q', '$rootScope', function($q, $rootScope) {
                                return _this.getTemplate($q, $rootScope);
                            }],
                            loadModule: ['$q', '$rootScope', function($q, $rootScope) {
                                return _this.loadModule($q, $rootScope, controllerName);
                            }]
                        }
                    };
                },

                getTemplate: function($q, $rootScope) {
                    this.tplDefer = $q.defer();
                    return this.tplDefer.promise;
                },

                loadModule: function($q, $rootScope, controllerName) {
                    this.moduleDefer = $q.defer();

                    if (this.module) {
                        this.resolveRoute(controllerName);
                    }
                    else {
                        var _this = this;
                        seajs.use(this.moduleUrl, function(module) {
                            _this.registerModule(module);
                            _this.resolveRoute(controllerName);
                        });
                    }

                    return this.moduleDefer.promise;
                },

                registerModule: function(module) {
                    this.module = module;

                    register.controller(module.controllers);
                    angular.forEach(module.factories, function(factory, name) {
                        register.factory(name, module.factories[name]);
                    });
                },

                resolveRoute: function(controllerName) {
                    this.tplDefer.resolve(this.module.controllers[controllerName].template);
                    this.moduleDefer.resolve();
                }

            };

            return function(moduleUrl) {
                return new SeajsModule(moduleUrl);
            };
        }]);
    }
]);