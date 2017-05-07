angular.module('ggoModule')
.factory('ggoService', function($http,$cookies,authService){
	var service = {};
	
	//Get User
	service.showUser = function () {
		return $http({
			method: 'GET',
			url: "api/players/"+ authService.getToken().id
		})
	}
	
	//Get Player Games
	service.playerGames = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/games"
		})		
	}
	
	//Get Player Teams
	service.playerTeams = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/teams"
		})		
	}
	//Create a new team
	service.createTeam = function(team) {
    	console.log(team)
    	return $http({
    		method: 'POST',
    		url: "api/players/"+ authService.getToken().id +"/teams",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    	data: team
    	})
    }
	
	//Game Index
	service.gameIndex = function(){
		return $http({
			method : 'GET',
			url : 'api/games'
		})	
	}
	//Add Game to Player List
	service.addGame = function(gameId, getUserId){
		return $http({
			method : 'POST',
			url : 'api/players/'+ getUserId +'/games/'+gameId,
			headers : {
				'Content_Type' : 'application/json'
			}
		})

	}

	
	//Team Index
	service.teamIndex = function(){
		console.log('In teamIndex -- ggoService')
		return $http({
			method : 'GET',
			url : 'api/teams'
		})	
	}
	
	//Join A team
	service.joinTeam = function(teamId){
		return $http({
			method : 'POST',
			url : 'api/players/'+ authService.getToken().id +'/teams/'+teamId,
			headers : {
				'Content_Type' : 'application/json'
			}
		})

	}
	

	//Update an active account
	service.updatePlayer = function(player){
		return $http({
			method : 'PUT',
			url : 'api/players/' + authService.getToken().id,
			headers : {
	            'Content-Type' : 'application/json'
	          },
	          data : player
	        })
		
	}
	
	//Remove a team from profile
	service.leaveTeam = function(team) {
		return $http ({
			url: 'api/players/'+authService.getToken().id+'/teams/'+ team.id,
			method: 'DELETE',
			headers : {
				'Content_Type' : 'application/json'
			}
		})
	}
	
	//Remove a game from your list of followed games
	service.removeGame = function(game){
		return $http({
			url : 'api/players/'+authService.getToken().id+'/games/'+ game.id,
			method : 'DELETE',
			headers : {
				'Content_Type' : 'application/json'
			}
		})
	}
	
	
	return service;
	})

