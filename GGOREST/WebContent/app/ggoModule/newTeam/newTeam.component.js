angular.module('ggoModule')
.component('newTeam',{
	templateUrl : 'app/ggoModule/newTeam/newTeam.component.html',
	controller : function(ggoService, $location, $scope, authService){
		var vm = this;
		vm.games =[];
		vm.teams = [];
	  	vm.reload = function(){
	  		ggoService.playerGames().then(function(res){
        		vm.games = res.data;
	  		})	
        	}
		 vm.reload();

		
		 vm.newTeam = function(team, gameId) {
				ggoService.createTeam(team, gameId).then(function(res){
					ggoService.playerTeams().then(function(res){
		        		vm.teams = res.data
		    	    })
				})
				vm.reload();
			 }
		 vm.addTeam = function() {
			 var x = vm.teams[vm.teams.length-1];
			 console.log(x);
			 ggoService.joinTeam(x.id).then(function(response){
				 
			})
		 }
		 vm.redirect = function(){
			 console.log($location)
			 $location.url('/team')
		 }
		
		
	},
	controllerAs : 'vm'
})