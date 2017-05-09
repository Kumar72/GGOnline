angular.module('ggoModule')
.component('player',{
	templateUrl : 'app/ggoModule/player/player.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.players=[];
		
		vm.reload = function(){
			ggoService.playerIndex().then(function(res){
				vm.players = res.data;
				console.log(vm.players)
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