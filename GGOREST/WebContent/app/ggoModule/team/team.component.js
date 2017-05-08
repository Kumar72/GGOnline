angular.module('ggoModule')
.component('team',{
	templateUrl : 'app/ggoModule/team/team.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.teams=[];
		
		vm.reload = function(){
			ggoService.teamIndex().then(function(res){
//				console.log(res.data);
				vm.teams = res.data;
				
			})
		}
		vm.joinTeam = function(teamId){
			var getUserId = authService.getToken().id;
//			console.log("clicked in joinTeam function" + teamId)
			ggoService.joinTeam(teamId).then(function(res){
				vm.reload();
			})
			
		}
		vm.reload();
		
		
	},
	
	controllerAs : 'vm'

})
