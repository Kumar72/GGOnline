angular.module('ggoModule')
.component('team',{
	templateUrl : 'app/ggoModule/team/team.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		
		vm.teams=[];
		
		vm.reload = function(){
			var result = [];
			ggoService.teamIndex().then(function(response){
				 ggoService.playerTeams().then(function(res){				 
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
				vm.teams = result;		//input all team into vm.teams that the user doesn't have
				
				
			})
		}
		vm.joinTeam = function(teamId){
			var getUserId = authService.getToken().id;
			ggoService.joinTeam(teamId).then(function(res){
				vm.reload();
			})
			
		}
		
		 vm.newTeam = function(team, gameId) {
				ggoService.createTeam(team, gameId).then(function(res){
					ggoService.playerTeams().then(function(res){
		        		vm.teams = res.data;
		    	    })
				})
			 }
		vm.reload();
		
		
	},
	
	controllerAs : 'vm'

})
