angular.module('ggoModule')
.component('game',{
	templateUrl : 'app/ggoModule/game/game.component.html',
	controller : function(ggoService, $filter, $location){
		var vm = this;
		
		vm.games=[];
		
		vm.reload = function(){
			ggoService.index().then(function(res){
				console.log(res.data);
				vm.games = res.data;
				
			})
		}
		vm.reload();
		
	},
	
	controllerAs : 'vm'

})

