angular.module("navModule").component("navComponent", {
    templateUrl : 'app/navModule/navigation/navigation.component.html',
    controller: function(authService, $location) {
    	var vm = this;
    	
    	vm.loggedIn = function() {
    		if(authService.getToken().id){
    			vm.name = authService.getToken().fname;
    			return true
    			
    		}
    		return false;	
    	}
    	
    	vm.logout = function() {
    		console.log("test logout");
    		authService.logout().then(function(res) {
    			$location.path('/');
    		})
    	}
    },
	controllerAs: 'vm'
    });
