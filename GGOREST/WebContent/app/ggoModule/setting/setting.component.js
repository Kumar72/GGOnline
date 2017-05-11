angular.module("ggoModule").component("setting", {
	templateUrl : 'app/ggoModule/setting/setting.component.html',
	controller : function(ggoService, $location, $scope, authService) {
		var vm = this;
		
		vm.updatePlayer = function(updateuser) {
			updateuser.id = authService.getToken().id;
			authService.updateToken(updateuser);
    		ggoService.updatePlayer(updateuser).then(function(res){
        		vm.player = res.data;
        	})
    	}
		vm.redirectHome = function(){
			console.log("In setting.component.js"+$location)
			$location.url('/home')
		}
	},
	controllerAs: 'vm'
});