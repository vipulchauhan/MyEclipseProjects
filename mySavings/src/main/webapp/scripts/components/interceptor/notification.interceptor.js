 'use strict';

angular.module('mySavingsApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-mySavingsApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-mySavingsApp-params')});
                }
                return response;
            }
        };
    });
