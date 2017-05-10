angular.module('ggoModule')
.controller('teamModal',
		function($scope, $uibModal, $log, ggoService) {
	

	
	$scope.animationsEnabled = true; 
	
	$scope.open = function(team) {
		
		console.log(team);
		var modalInstance = $uibModal.open({
			animation : $scope.animationsEnabled,
			templateUrl : 'app/ggoModule/modal/team.modal.component.html',
			controller : 'TeamModalInstanceCtrl',
			size : "large",
			resolve : {
				team : function() {
					return team;
				},
				members : function() {
					return ggoService.getTeamMembers(team).then(function(res){
						return res.data
					});
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

angular.module('ggoModule').controller('TeamModalInstanceCtrl',
		function($scope, $uibModalInstance, team, members, ggoService, $location) {
	
		$scope.routeToUserProfile = function(teamId, playerId){
			$location.path('/teams/'+ teamId +'/players/'+ playerId)
			$scope.cancel();
		}
	
			$scope.team = team;
			$scope.members = members;
//			$scope.selected = {
//				item : $scope.items[0]
//			};
//
//			$scope.ok = function() {
//				$uibModalInstance.close($scope.selected.item);
//			};
	
			
	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	};
});