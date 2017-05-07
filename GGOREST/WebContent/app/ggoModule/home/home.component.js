angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location, $scope) {
    	var vm = this;
    	
    	vm.player =[];
    	vm.games = [];
    	vm.teams = [];
    	vm.showTeamForm = true;
    	
    	
    	vm.reload = function(){
    		ggoService.showUser().then(function(res){
        		vm.player = res.data;
        	})
       
        	ggoService.playerGames().then(function(res){
        		vm.games = res.data;
    	    })
    	    
    	    vm.removeGame = function(game){
    			ggoService.removeGame(game)
    				.then(console.log)
    				.catch(console.error)
    		}
    	    
    	    ggoService.playerTeams().then(function(res){
        		vm.teams = res.data;
    	    })
    	}
    	
    	
    	
    	vm.reload();
    	
    	vm.displayForm = function() {
    		vm.showTeamForm = false;
    	}
    	vm.cancelButton = function() {
    		vm.showTeamForm = true;
    	}
    	
    	vm.modalShown = false;
    	  vm.toggleModal = function() {
    		  console.log("in toggleModal function")
    	    vm.modalShown = !vm.modalShown;
    	  };
    	
    	vm.displayGameInfo = function() {}
    	
    	
    	
    	
    	
    	
    	
    	
    },
	controllerAs: 'vm'
    });