angular.module('ggoModule')
.component('team',{
	templateUrl : 'app/ggoModule/team/team.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.updatedList = function(team){
			return ggoService.playerTeams().then(function(res){
				var match = false;
				res.data.forEach(function(t, index, array){
					if(t.id === team.id){						
						 match = true;
					}										
				})
				return match;
			})
			
			

		};
		
		
		vm.teams=[];
		
		vm.reload = function(){
			ggoService.teamIndex().then(function(res){
				vm.teams = res.data;
				
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
