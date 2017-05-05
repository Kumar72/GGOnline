angular.module("authModule").component("register", {
    templateUrl : 'app/authModule/register/register.component.html',
    controller: function(authService, $location) {
    	var vm = this;
    	
    	vm.register = function(newuser) {
    		authService.register(newuser).then(function(res){
    			$location.path('/')
    		})
    	}
    	
    	vm.cancel = function() {   		
    			$location.path('/')
 	
    	}
    },
	controllerAs: 'vm'
    });
