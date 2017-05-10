angular.module('ggoModule').controller('gameModal',
		function($scope, $uibModal, $log, ggoService) {

			
			$scope.animationsEnabled = true;

			$scope.open = function(game) {
				var modalInstance = $uibModal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'app/ggoModule/modal/modal.component.html',
					controller : 'ModalInstanceCtrl',
					size : "large",
					resolve : {
						game : function() {
							return game;
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
		function($scope, $uibModalInstance, game, ggoService) {
			
			$scope.game = game;
//			$scope.game = items;
//			$scope.selected = {
//				item : $scope.items[0]
//			};
//
//			$scope.ok = function() {
//				$uibModalInstance.close($scope.selected.item);
//			};
			
//			$scope.removeGame = function(game){
//				ggoService.removeGame(game)
//	    			.then(function(res){
////	    			vm.reload();
//	    				
//	    		})
//				
//			}
//
			$scope.cancel = function() {
				$uibModalInstance.dismiss('cancel');
			};
		});