angular.module('ggoModule')
.filter('gameSearch', function() {
  return function(Game, text) {
	  gameSearch={}
	  console.log("in Filter JS")
	  console.log("Game: "+Game.name)
	  console.log("Text: "+text)
    if (!text) return Game;
    var results = [];
    games.forEach(function(g) {
      if(g.name.toLowerCase().includes(text.toLowerCase())) {
        results.push(g);
      }
    }) // end forEach
    return results;

  }
  // end function
})