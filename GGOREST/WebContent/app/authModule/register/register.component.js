angular.module("authModule").component("register", {
    templateUrl : 'app/authModule/register/register.component.html',
    controller: function(authService, $location) {
    	var vm = this;
    	
    	vm.register = function(newuser) {
    		authService.register(newuser).then(function(res){
    			$location.path('/')
    		})
    	}
    },
	controllerAs: 'vm'
    });
