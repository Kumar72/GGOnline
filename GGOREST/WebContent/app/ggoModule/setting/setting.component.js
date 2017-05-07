angular.module("ggoModule")
.component("setting", {
    templateUrl : 'app/ggoModule/setting/setting.component.html',
    controller: function(ggoService, $location) {
    	var vm = this;
    	vm.player =[];
    	vm.reload = function(){
    		ggoService.updateUSer().then(function(res){
        		vm.player = res.data;
        	})
    	}
    	
    	vm.reload();
    	vm.update = fun
    	
    	
    	
    	
    },
    controllerAs: 'vm'

})