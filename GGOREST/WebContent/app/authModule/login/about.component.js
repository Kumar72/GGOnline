angular.module('authModule')
.component('about',{
	templateUrl : 'app/authModule/login/about.component.html',
	controller : function(authService, $location){
		var vm = this;
		
		vm.rerouteToLogin = function(){
    		$location.url('/')
    	}		
	},
	controllerAs : 'vm'
})