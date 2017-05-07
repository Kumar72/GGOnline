angular.module("ggoModule").component("setting", {
	templateUrl : 'app/ggoModule/setting/setting.component.html',
	controller : function(ggoService, $location, $scope) {
		var vm = this;
		
		vm.updatePlayer = function(updateuser) {
			console.log(updateuser);
    		ggoService.updatePlayer(updateuser).then(function(res){
        		vm.player = res.data;
        		
        	})
    	}
	},
	controllerAs: 'vm'
});