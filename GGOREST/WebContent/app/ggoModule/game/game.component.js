angular.module('ggoModule')
.component('game',{
	templateUrl : 'app/ggoModule/game/game.component.html',
	controller : function(ggoService, $filter, $location, authService){
		var vm = this;
		
		vm.games=[];
		
		vm.reload = function(){
			ggoService.gameIndex().then(function(res){
				console.log(res.data);
				vm.games = res.data;
				
			})
		}
		vm.addGame = function(gameId){
			var getUserId = authService.getToken().id;
			console.log("clicked in addGame function" + gameId)
			ggoService.addGame(gameId, getUserId).then(function(res){
				vm.reload();
			})
			
		}
		vm.reload();
		
		
	},
	
	controllerAs : 'vm'

})

//angular.module('ggoModule')
//.filter('fuzzySearch', function() {
//  return function(Game, text) {
//    if (!text) return games;
//    var results = [];
//    games.forEach(function(name) {
//      if(game.name.toLowerCase().includes(text.toLowerCase())) {
//        results.push(game);
//      }
//    }) // end forEach
//    return results;
//  }
//  // end function
//})

	