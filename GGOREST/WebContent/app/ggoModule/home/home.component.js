angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location, $scope, $document) {
    	var vm = this;
    	var body = $document.find('body').eq(0);
    		body.css("background-image","url('https://s-media-cache-ak0.pinimg.com/originals/92/4b/13/924b13926e7f5a5dc737947f1bd4026a.jpg')");
    		body.css("background-repeat", "repeat-y");
    	
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
    	
    	
    	 
    	vm.removeGame = function(game){
    		ggoService.removeGame(game)
    		.then(function(res){
    			vm.reload();
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