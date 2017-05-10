//game fuzzy search
angular.module('ggoModule')
.filter('gameSearch', function() {
  return function(games, text) {
    if (!text) return games;
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

//team fuzzy search
angular.module('ggoModule')
.filter('teamSearch', function() {
  return function(teams, text) {
    if (!text) return teams;
    var results = [];
    teams.forEach(function(t) {
      if(t.name.toLowerCase().includes(text.toLowerCase())) {
        results.push(t);
      }
    }) // end forEach
    return results;

  }
  // end function
})

//player fuzzy search
angular.module('ggoModule')
.filter('playerSearch', function() {
	return function(players, text) {
		if (!text) return players;
		var results = [];
		players.forEach(function(p) {
			if(p.name.toLowerCase().includes(text.toLowerCase())) {
				results.push(p);
			}
		}) // end forEach
		return results;
		
	}
	// end function
})
