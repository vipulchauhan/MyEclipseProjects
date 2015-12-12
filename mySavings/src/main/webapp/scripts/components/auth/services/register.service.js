'use strict';

angular.module('mySavingsApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


