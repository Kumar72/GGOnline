angular.module('ggoModule')
.factory('ggoService', function($http,$cookies,authService){
	var service = {};
	
	//get info on the currently logged in player
	//how do i used the logged in user
	service.showUser = function () {
		return $http({
			method: 'GET',
			url: "api/players/"+ authService.getToken().id
		})
	}
	
	service.index = function(){
		return $http({
			method : 'GET',
			url : 'api/games'
		})
		
	}
	
	
	return service;
})
