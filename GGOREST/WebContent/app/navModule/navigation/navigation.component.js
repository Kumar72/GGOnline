angular.module("navModule").component("navComponent",{
	templateUrl : 'app/navModule/navigation/navigation.component.html',
	controller : function(authService, $location) {
		var vm = this;
		
		vm.homeNav = true;
		vm.gameNav = true;
		vm.teamNav = true;
		vm.socialNav = true;

		vm.openNav = function() {
			document.getElementById("mySidenav").style.width = "250px";
			document.getElementById("main").style.marginLeft = "250px";
			document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
		}

		vm.closeNav = function() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
			document.body.style.backgroundColor = "white";
		}

		vm.loggedIn = function() {
			if (authService.getToken().id) {
				vm.name = authService.getToken().fname;
				document.body.style.backgroundImage = "url('http://wallpaper-gallery.net/images/desktop-wallpaper-gaming/desktop-wallpaper-gaming-6.jpg')";
				return true

			}
			return false;
		}
		
		/* vm.messageNotification = function() {
    		return vm.message.length; 
    	} */

		vm.logout = function() {
			console.log("in navigation component / log out method")
			vm.closeNav();
			authService.logout().then(function(res) {
				$location.path('/');
			})
		}
	},
	controllerAs : 'vm'
});
