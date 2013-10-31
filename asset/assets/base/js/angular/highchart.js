angular.module('highchart', []).directive('highChart', function() {
    return {
        restrict: 'EA',
        template: '<div></div>',
        scope: {
            options: "="
        },
        transclude: true,
        replace: true,

        link: function(scope, element, attrs) {
            var chartsDefaults = {
                chart: {
                    renderTo: element[0],
                    type: attrs.type || null,
                    height: attrs.height || null,
                    width: attrs.width || null
                }
            };

            //Update when charts data changes
            scope.$watch('options', function(value) {
                if (!value) {
                    return;
                }
                var deepCopy = true;
                var newSettings = {};
                $.extend(deepCopy, newSettings, chartsDefaults, value);
                var chart = new Highcharts.Chart(newSettings);

            });
        }
    };

});