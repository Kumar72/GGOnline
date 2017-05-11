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
						},
						removeGame: function() {
							return $scope.removeGame;
							
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
		function($scope, $uibModalInstance, game, ggoService, removeGame, $route) {
			
			$scope.game = game;
			
			$scope.reloadRoute = function() {
				$route.reload();
			}
			
			$scope.removeGame = function(){
				ggoService.removeGame($scope.game)
	    			.then(function(res){	    				
	    			$scope.cancel();
	    			$scope.reloadRoute();
	    				
	    		})
//				
			}
//
			$scope.cancel = function() {
				$uibModalInstance.dismiss('cancel');
			};
		});