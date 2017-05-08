angular.module("authModule").component("logout", {
    templateUrl : 'app/authModule/logout/logout.component.html',
    controller: function(authService, $location) {
    	var vm = this;
    	console.log("IN LOG OUT COMPONENT JS")
    	vm.logout = function() {
    		authService.logout().then(function(res) {
    			$location.path('/');
    		})
    	}
    },
	controllerAs: 'vm'
    });