angular.module('ggoModule')
.component('game',{
	templateUrl : 'app/ggoModule/game/game.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.games=[];
		
		vm.reload = function(){
			var result = [];
			ggoService.gameIndex().then(function(response){
				ggoService.userGames().then(function(res){
					 response.data.forEach(function(team, index, array){
						 var match = false;
						 res.data.forEach(function(t,i,a){
							 if (t.id === team.id){
								 match = true;
							 }
						 })
						 if(!match){
							 result.push(team);
						 }
					 })
						
				})
				vm.games = result;
				
			})
		}
		vm.addGame = function(gameId){
			var getUserId = authService.getToken().id;
			ggoService.addGame(gameId, getUserId).then(function(res){
				vm.reload();
			})
			
		}
		vm.reload();
		
	},
	
	controllerAs : 'vm'

})	