angular.module('ggoModule')
.component('gameList',{
	templateUrl : 'app/ggoModule/game/game.component.html',
	controller : function(ggoService, $filter){
		var vm = this;
		
		vm.Games[];
		
		vm.reload = function(){
			ggoService.index().then(function(res){
				vm.games = res.data;
			})
		}
		
		
	},
	
	controllerAs : 'vm';

})

