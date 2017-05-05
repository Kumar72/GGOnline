angular.module("ggoModule").component("home", {
    templateUrl : 'app/ggoModule/home/home.component.html',
    controller: function(ggoService, $location) {
    	var vm = this;
    	
    	vm.player =[];
    	
    	vm.reload = function(){
    		ggoService.showUser().then(function(res){
        		vm.player = res.data;
        	})
    	}
    	
    	vm.reload();
    	
    	
    	
    },
	controllerAs: 'vm'
    });