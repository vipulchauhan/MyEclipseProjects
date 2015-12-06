
angular.module('app.services').factory('fdCRUDService',['$http',function($http){
	return {
		list : function(getFixedDepositesURL) {
			console.log('loading Fixed Deposites ' + getFixedDepositesURL);
			$http.get(getFixedDepositesURL)
			.success(function(data) {
				console.log('Fiexd Deposite data from Server :-');
				console.log(JSON.stringify(data));
				
			})
		}
	}
}]);

/*
 * var fdCRUDservice = angular.module("fdCRUDservice", ["ngResource"])
 * .factory("fdCRUDservice", function ($resource) { // Construct a resource
 * object that can // interact with the RESTful API of the server. var resource =
 * $resource("people/:operation/:id", { id: 0 }, { // A custom method to update
 * the picture of the person updatePicture: { method: "PUT", isArray: false } } ); //
 * Custom function to retrieve a person by ID resource.retrievePerson = function
 * (personId) { return this.get( { operation: "retrieve", id: personId }); }; //
 * Custom function to retrieve some people by IDs resource.retrievePeople =
 * function (peopleIdsArray) { return this.query( { operation: "retrievearray",
 * "idsArray[]": peopleIdsArray }); }; // Custom function to save a person
 * object resource.storePerson = function (person, picture) { return this.save( {
 * operation: "store", firstName: person.firstName, lastName: person.lastName },
 * picture ); }; // Custom function to delete a person object by ID
 * resource.erasePerson = function (personId) { return this.delete( { operation:
 * "erase", id: personId }); }; // Custom function to update the picture of a
 * person resource.updatePersonPicture = function (personId, picture) { return
 * this.updatePicture( { operation: "updatepicture", id: personId }, picture ); };
 * 
 * return resource; })
 */