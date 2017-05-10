angular.module('ggoModule')
.component('player',{
	templateUrl : 'app/ggoModule/player/player.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.players=[];
		
		vm.reload = function(){
			var result = [];
			ggoService.playerIndex().then(function(response){
				ggoService.playerFriends().then(function(res){
					response.data.forEach(function(player, index, array){
						 var match = false;
						 res.data.forEach(function(p,i,a){					 
							 if (p.id === player.id){
								 match = true;
							 }
						 })
						 if(!match && player.id != authService.getToken().id){
							 result.push(player);
						 }
					 })
				})
				vm.players = result;
			})
		}
		vm.friendRequest = function(friendId){	
			ggoService.addFriend(friendId).then(function(res){
				vm.reload();
			})
			
		}
		vm.reload();
		
		
		
	},
	
	controllerAs : 'vm'

})	