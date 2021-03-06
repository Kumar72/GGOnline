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
	
	//shows a player
	service.showPlayer = function(playerId) {
		return $http({
			method: 'GET',
			url: "api/players/"+ playerId
		})	
	}
	
	//Update an active account
	service.updatePlayer = function(player){
		return $http({
			method : 'PUT',
			url : 'api/players/'+authService.getToken().id,
			headers : {
	            'Content-Type' : 'application/json'
	          },
	          data : player
	        })
	}

	
	
	//Get Players
	service.playerIndex = function(){
		return $http({
			method : 'GET',
			url : 'api/players'
		})	
	}
	//Friend Index
	service.playerFriends = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/players"
		})		
	}
	
	service.userFriends = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/players"
		})		
	}
	
	service.pFriends = function(playerId){
		return $http({
			method : 'GET',
			url : 'api/players/'+ playerId +"/players"
		})		
	}
	
	//Add Friend to Player List
	service.addFriend = function(friendId){
		return $http({
			method : 'POST',
			url : 'api/players/'+ authService.getToken().id +'/players/'+friendId,
			headers : {
				'Content_Type' : 'application/json'
			}
		})
	}
	//Remove a player from your friend list
	service.removeFriend = function(friend){
		return $http({
			url : 'api/players/'+authService.getToken().id+'/players/'+ friend.id,
			method : 'DELETE',
			headers : {
				'Content_Type' : 'application/json'
			}
		})
	}
	
	
	//Get user games
	service.userGames = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/games"
		})		
	}
	
	//Get Player Games
	service.playerGames = function(playerId){
		return $http({
			method : 'GET',
			url : 'api/players/'+ playerId +"/games"
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

	//Get user Teams
	service.userTeams = function(){
		return $http({
			method : 'GET',
			url : 'api/players/'+ authService.getToken().id +"/teams"
		})		
	}
	
	//Get Player Teams
	service.playerTeams = function(playerId){
		return $http({
			method : 'GET',
			url : 'api/players/'+ playerId +"/teams"
		})		
	}	
	//Team Index
	service.teamIndex = function(){
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
	//Create a new team using gameId
	service.createTeam = function(team, gameId) {
    	return $http({
    		method: 'POST',
    		url: "api/players/"+ authService.getToken().id +"/games/"
    		+ gameId +"/teams",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    	data: team
    	})
    }
	//get a list of players on a team
	service.getTeamMembers = function(team){
		return $http({
			url : 'api/teams/'+team.id + '/players',
			method : 'GET'
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
		
	

	
	//Message Index
	service.messageIndex = function(){
		return $http({
			method : 'GET',
			url : 'api/messages'
		})	
	}
	

	//Create Message
	service.createMessage = function(message) {
    	return $http({
    		method: 'POST',
    		url: "api/messages/"+ authService.getToken().id,
    		headers: {
    			'Content-Type': 'application/json'
    		},
    	data: message
    	})
    }
	//messaging, does not work. don't call this function
	service.newRecipient = function(friend){
		return $http({
			method : 'GET',
			url : 'api/players/' + authService.getToken().id + '/friends'		
		})
	}

	//view another users profile
	service.visitPlayersProfile = function(team, player){
		console.log("Team id: "+ team)
		console.log("Player id: "+ player)
		return $http({
			method : 'GET',
			url : 'api/teams/'+ team + '/players/' + player
		})
		
	}
	

	
	
	return service;
	});

