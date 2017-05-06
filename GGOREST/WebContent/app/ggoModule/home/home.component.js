angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location) {
    	var vm = this;
    	
    	vm.player =[];
    	vm.games = [];
    	vm.teams = [];
    	
    	vm.reload = function(){
    		ggoService.showUser().then(function(res){
        		vm.player = res.data;
        	})
        	
       
        	ggoService.playerGames().then(function(res){
        		vm.games = res.data;
    	    })
    	    
    	    ggoService.playerTeams().then(function(res){
        		vm.teams = res.data;
    	    })
    	    
    	    vm.removeGame = function(game){
    			ggoService.removeGame(game)
    				.then(console.log)
    				.catch(console.error)
    			
    		}
    	}
    	
    	
    	vm.reload();
    	
    	
    	
    	
    	
    },
	controllerAs: 'vm'
    });