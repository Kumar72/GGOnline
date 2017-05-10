angular.module('ggoModule').controller('friendModal',
		function($scope, $uibModal, $log, ggoService) {

			
			$scope.animationsEnabled = true;

			$scope.open = function(friend) {
				console.log(friend)
				var modalInstance = $uibModal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'app/ggoModule/modal/friend.modal.component.html',
					controller : 'ModalInstanceCtrl',
					size : "large",
					resolve : {
						friend : function() {
							return friend;
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

angular.module('ggoModule').controller('ModalInstanceCtrl',
		function($scope, $uibModalInstance, friend, ggoService) {
			
			$scope.friend = friend;
			$scope.cancel = function() {
				$uibModalInstance.dismiss('cancel');
			};
		});