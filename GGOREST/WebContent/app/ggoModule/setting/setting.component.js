angular.module("ggoModule").component("setting", {
	templateUrl : 'app/ggoModule/setting/setting.component.html',
	controller : function(ggoService, $location, $scope) {
		var vm = this;

		vm.setting = true;

		vm.settings = function() {
			vm.setting = false;
			console.log("in setting function")
			$location.path('/setting')

		}
	}
});