angular.module('ggoModule')
.component('showPlayer',{
	templateUrl : 'app/ggoModule/showPlayer/playerRoute.component.html',
	controller : function($routeParams, $location, ggoService){
		var vm = this;

		vm.player =[];
		vm.games = [];
		vm.teams = [];
		vm.friends =[];
		
		ggoService.visitPlayersProfile(parseInt($routeParams.teamId), parseInt($routeParams.playerId))
		.then(function(res){
			vm.player = res.data;
			if(!vm.player) $location.path('/not-found')
			vm.reload(vm.player.id);
		});
		
    	
    	
    	vm.reload = function(playerId){
    		console.log(playerId)
    		
    		ggoService.showPlayer(playerId).then(function(res){
        		vm.player = res.data;
        	})
       
        	ggoService.playerGames(playerId).then(function(res){
        		vm.games = res.data;
    	    })  		
    	    ggoService.playerTeams(playerId).then(function(res){
        		vm.teams = res.data;
    	    })  	    
     	    ggoService.pFriends(playerId).then(function(res){
        		vm.friends = res.data;
    	    })
    	}
    	
    	vm.reload();
		
		
	},
	controllerAs : 'vm'
});