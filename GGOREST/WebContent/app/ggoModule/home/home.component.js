angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location, $scope) {
    	var vm = this;
    	
    	vm.player =[];
    	vm.games = [];
    	vm.teams = [];
    	vm.showTeamForm = true;
    	vm.team = {
    			name: 'StarWars',
    			image: '',
    			game: {}
    	};
    	
    	
    	vm.reload = function(){
    		ggoService.showUser().then(function(res){
    			console.log("In show user");
        		vm.player = res.data;
        	})
       
        	ggoService.playerGames().then(function(res){
    			console.log("In player Games");

        		vm.games = res.data;
        		console.log(vm.games)
        		
    	    })
    	    .catch(function(error){
    	    	console.log(error)
    	    	console.log('In failed player games')
    	    
    	    })
    	    
    	    
    	    
    	    
    	    ggoService.playerTeams().then(function(res){
    			console.log("In player Teams");

        		vm.teams = res.data;
    	    })
    	}
    	
    	  vm.newTeam = function() {
//    		console.log(document.getElementById("game").value);
			vm.team.game = document.getElementById("game").value;
			console.log(vm.team);
    		ggoService.createTeam(vm.team, document.getElementById("game").value).then(function(res){
        		vm.teams = res.data;
        		//$location.path
        	})
    	}

    	vm.removeGame = function(game){
    		ggoService.removeGame(game)
    		.then(function(res){
    			vm.reload();
    			console.log('In removeGame function')
    		})
    		.catch(function(error){
    			console.log("hit error");
    		})
    		
    		
//    		vm.reload();
    	}
    	
    	vm.leaveTeam = function(team) {
    		ggoService.leaveTeam(team).then(function(res){
    			vm.reload();
    		})
    	}
    	
    	vm.updatePlayer = function(updateUser) {
    		ggoService.update().then(function(res){
        		vm.player = res.data;
        		
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