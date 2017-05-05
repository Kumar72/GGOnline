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
	
	service.playerGames = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/games"
		})		
	}
	
	service.playerTeams = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/teams"
		})		
	}
	
	service.index = function(){
		return $http({
			method : 'GET',
			url : 'api/games'
		})	
	}
	

	service.updatePlayer = function(){
		return $http({
			method : 'PUT',
			url : 'api/players' + authService.getToken().id,
			headers : {
	            'Content-Type' : 'application/json'
	          },
	          data : todo
	        })
		
	}
	service.addGame = function(gameId, getUserId){
		return $http({
			method : 'POST',
			url : 'api/players/'+ getUserId +'/games/'+gameId,
			headers : {
				'Content_Type' : 'application/json'
			}
		})

	}
	
	
	return service;
	})

