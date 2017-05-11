angular.module('ggoModule').controller('friendModal',
		function($scope, $uibModal, $log, ggoService, authService, $location) {

			
			$scope.animationsEnabled = true;

			$scope.open = function(friend) {
				var modalInstance = $uibModal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'app/ggoModule/modal/friend.modal.component.html',
					controller : 'friendModalInstanceCtrl',
					size : "large",
					resolve : {
						friend : function() {
							return friend;
						},
						removeFriend: function() {
							return $scope.removeFriend;
						},
						selectedUser: function() {
							return $scope.selectedUser;
						}
						
					}
				});

				modalInstance.result.then(function(selectedItem) {
					$scope.selected = selectedItem;
				}, function() {
					$log.info('Modal dismissed at: ' + new Date());
				});
			};
			
			$scope.toggleAnimation = function() {
				$scope.animationsEnabled = !$scope.animationsEnabled;
			};
			
		});

// Please note that $uibModalInstance represents a modal window (instance)
// dependency.
// It is not the same as the $uibModal service used above.

angular.module('ggoModule').controller('friendModalInstanceCtrl',
		function($scope, $uibModalInstance, friend, ggoService, $route,
				selectedUser, authService, $routeParams, $location) {
			
		$scope.selectedUser = function() {
			if(authService.getToken().id === $routeParams.playerId || $location.path().includes('/home')){
				return false;
			}
			return true;				
		};
		
		$scope.friend = friend;
		$scope.reloadRoute = function() {
			$route.reload();
		}
			
		$scope.removeFriend = function() {
			ggoService.removeFriend($scope.friend).then(function(res){
				$scope.cancel();
				$scope.reloadRoute();
			})
		}
			
		$scope.cancel = function() {
			$uibModalInstance.dismiss('cancel');
		};
			
		});