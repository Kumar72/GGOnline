angular.module("authModule").component("login", {
    templateUrl : 'app/authModule/login/login.component.html',
    controller: function(authService, $location) {
    	var vm = this;
    	
    	vm.login = function(user) {
//    		console.log("clicked")
//    		console.log(user.image)
    		authService.login(user).then(function(res){
    			$location.path('/home')
    		})
    	}
    	vm.create = function() {
    		$location.path('/register')
    	}
    	vm.learn = function() {
    		$location.url('/about')
    	}
    	
    	
    },
	controllerAs: 'vm'
    });
