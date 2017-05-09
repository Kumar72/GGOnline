
angular.module("ggoModule")
.component("social", {
	templateUrl : 'app/ggoModule/social/social.component.html',
	controller : function(ggoService, $location, $scope, authService) {
		var vm = this;
		vm.messages - [];
		

		vm.reload = function(){
			ggoService.messageIndex().then(function(res){
				console.log(res.data);
				vm.messages = res.data;
				
			})
		}
	},
	controllerAs: 'vm'
});


