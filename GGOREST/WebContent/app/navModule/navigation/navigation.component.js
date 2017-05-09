angular.module("navModule").component("navComponent",{
	templateUrl : 'app/navModule/navigation/navigation.component.html',
	controller : function(authService, $location, social) {
		var vm = this;
		
		vm.homeNav = function() {
			if($location.path() == '/home' ||$location.path()== '/notification' ||$location.path() == '/setting'){
			return true;
			}
			return false;
			
		};
		
		vm.gameNav = function() {
			if($location.path() == '/game' || $location.path()== '/search'){
				return true;
			}
				return false;
				
		}
		vm.teamNav = function() {
			if($location.path() == '/team' || $location.path() == '/search'){
				return true;
			}
				return false;		
		}
		vm.socialNav = function() {
			if($location.path() == '/social' || $location.path()== '/chat' || $location.path() == '/player'){
				return true;
			}
				return false;		
		}
		
		

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
