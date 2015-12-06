/*
 * 
 * 
 * 
 * 
 */

angular.module('app.controllers').controller(
		'fdDashBoardCtrl',
		function($scope, $http, $timeout) {

			$scope.baseURL = "http://localhost:8080";
			//$scope.baseURL = "http://localhost:8081";
			//$scope.appContextURL = $scope.baseURL + "/mySavings-service/mySavings";
			$scope.appContextURL = $scope.baseURL + "/mySavings";
			$scope.getVixedDepositesURL = $scope.appContextURL
					+ "/fixedDeposites";

			$scope.fixedDepositeArray = [];

			// load engine series from server
			$scope.loadFixedDeposites = function() {
				console.log('loading Fixed Deposites');
				$http.get($scope.getVixedDepositesURL)
				.success(function(data) {
					console.log('Fiexd Deposite data from Server :-');
					console.log(JSON.stringify(data));
					$scope.fixedDepositeArray = data;
				})
				
			}

			$scope.tableDrawEnded = function() {
				$timeout(function() {
					$(document).ready(function() {
						$('#fixedDepositeTable').DataTable();
					});

					$('[data-toggle="popover"]').popover();

				}, 0);
			}
			$scope.opts = {
				lines : 13 // The number of lines to draw
				,
				length : 0 // The length of each line
				,
				width : 14 // The line thickness
				,
				radius : 42 // The radius of the inner circle
				,
				scale : 1 // Scales overall size of the spinner
				,
				corners : 1 // Corner roundness (0..1)
				,
				color : '#000' // #rgb or #rrggbb or array of colors
				,
				opacity : 0.25 // Opacity of the lines
				,
				rotate : 0 // The rotation offset
				,
				direction : 1 // 1: clockwise, -1: counterclockwise
				,
				speed : 1 // Rounds per second
				,
				trail : 60 // Afterglow percentage
				,
				fps : 20 // Frames per second when using setTimeout() as a
				// fallback for CSS
				,
				zIndex : 2e9 // The z-index (defaults to 2000000000)
				,
				className : 'spinner' // The CSS class to assign to the
				// spinner
				// , top: '50%' // Top position relative to parent
				// , left: '50%' // Left position relative to parent
				,
				shadow : false // Whether to render a shadow
				,
				hwaccel : false
			// Whether to use hardware acceleration
			// , position: 'absolute' // Element positioning
			}

		});
