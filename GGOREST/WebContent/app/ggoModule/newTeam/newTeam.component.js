angular.module('ggoModule')
.component('newTeam',{
	templateUrl : 'app/ggoModule/newTeam/newTeam.component.html',
	controller : function(){
		var vm = this;
		
		 vm.newTeam = function(team, gameId) {
				ggoService.createTeam(team, gameId).then(function(res){
					ggoService.playerTeams().then(function(res){
		        		vm.teams = res.data;
		    	    })
				})
			 }
		
		
	},
	controllerAs : 'vm';
})