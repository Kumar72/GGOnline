angular.module("authModule").component("logout", {
    templateUrl : 'app/authModule/logout/logout.component.html',
    controller: function(authService, $location, $document) {
    	var vm = this;
    	var body = $document.find('body').eq(0);
        vm.error = false;
        
    	vm.logout = function() {
    		authService.logout().then(function(res) {
    			body.css("background-image", "url('http://cdn.wallpapersafari.com/63/79/pU4X9V.jpg')");
    			body.css("background-repeat", "repeat-y");
                body.css("background-attachment", "");
                body.css("background-position", "");
    			$location.path('/');
    		})
    		.catch(function(error){
				vm.error = true;
			})
    	}
    },
	controllerAs: 'vm'
    });