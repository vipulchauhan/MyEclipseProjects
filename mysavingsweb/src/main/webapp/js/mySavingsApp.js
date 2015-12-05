angular.module('app.controllers', []);
angular.module('app.services', []);
var mySavingsApp = angular.module("mySavingsApp", [ 'ngRoute',
		'app.controllers', 'app.services' ]);

mySavingsApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'fdDashBoardCtrl',
		templateUrl : './views/FDDashBoard.html'
	}).otherwise({
		redirectTo : '/'
	});

})

mySavingsApp.controller("mySavingsAppCtrl", function($scope) {

});
