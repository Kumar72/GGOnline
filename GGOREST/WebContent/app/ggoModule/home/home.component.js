angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location, $scope) {
    	var vm = this;
    	
    	vm.player =[];
    	vm.games = [];
    	vm.teams = [];
    	vm.friends = [];
    	
    	vm.showTeamForm = true;
    	
    	
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
    	    ggoService.playerFriends().then(function(res){
    	    	vm.friends = res.data
    	    })
    	}
    	
    	vm.reload();
    	
    	
//		 vm.newTeam = function(team, gameId) {
//			ggoService.createTeam(team, gameId).then(function(res){
//				ggoService.playerTeams().then(function(res){
//	        		vm.teams = res.data;
//	    	    })
//			})
//		 }
    	 
    	vm.removeGame = function(game){
    		ggoService.removeGame(game)
    		.then(function(res){
    			vm.reload();
//    			console.log('In removeGame function')
    		})
    		.catch(function(error){
    			console.log("hit error");
    		})
    	}
    	
    	
    	vm.leaveTeam = function(team) {
    		ggoService.leaveTeam(team).then(function(res){
    			vm.reload();
    		})
    	}
    	
    	vm.unFriend = function(friend) {
    		console.log(friend)
    		console.log("In unfriend method in home.js")
    		ggoService.removeFriend(friend).then(function(res){
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
    	
    	
    	
    	vm.displayGameInfo = function() {}

    },
	controllerAs: 'vm'
    });