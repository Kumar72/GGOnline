angular.module('ggoModule')
.component('newTeam',{
	templateUrl : 'app/ggoModule/newTeam/newTeam.component.html',
	controller : function(ggoService, $location, $scope, authService){
		var vm = this;
		vm.games =[];
		
	  	vm.reload = function(){
	  		ggoService.playerGames().then(function(res){
        		vm.games = res.data;
        		console.log(vm.games)
	  		})	
        	}
		 vm.reload();

		
		 vm.newTeam = function(team, gameId) {
				ggoService.createTeam(team, gameId).then(function(res){
					ggoService.playerTeams().then(function(res){
		        		vm.teams = res.data	
		    	    })
				})
			 }
		
		
	},
	controllerAs : 'vm'
})