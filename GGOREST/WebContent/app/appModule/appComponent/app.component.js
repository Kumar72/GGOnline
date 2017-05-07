angular.module("appModule").component("appComponent", {
    templateUrl : 'app/appModule/appComponent/app.component.html',
    controller: function(authService, $location) {
    	var vm = this;
//    	vm.logIn = function() {
//    		if(authService.getToken().id){
//    			vm.name = authService.getToken().fname;	
//    			document.body.style.backgroundImage = "url('http://wallpaper-gallery.net/images/desktop-wallpaper-gaming/desktop-wallpaper-gaming-6.jpg')";
//    			return true
//    			
//    		}
//    		else{
//    		return false;
//    		}
//    	}
    },
    controllerAs: 'vm'
    });
