angular.module('ggoModule')
.filter('fuzzyGameSearch', function() {
  return function(Game, text) {
    if (!text) return games;
    var results = [];
    games.forEach(function(name) {
      if(game.name.toLowerCase().includes(text.toLowerCase())) {
        results.push(game);
      }
    }) // end forEach
    return results;
  }
  // end function
})