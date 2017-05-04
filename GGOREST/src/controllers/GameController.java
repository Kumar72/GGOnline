package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.GameDAO;
import entities.Game;
import entities.Player;
@RestController
public class GameController {
	
	@Autowired
	GameDAO gameDAO;

	@RequestMapping(value="ping", method=RequestMethod.GET)
	public String ping(){
		return "PONG FROM GAME CONTROLLER";
	}
	
	@RequestMapping(value="games", method=RequestMethod.GET)
	public List<Game> index(){
		return gameDAO.index();
		
	}
	
	@RequestMapping(value="games/{id}", method=RequestMethod.GET)
	public Game show(@PathVariable int id){
		
		return gameDAO.show(id);
	}
	
	@RequestMapping(value="games/{gameId}/players", method=RequestMethod.GET)
	public List<Player> indexOfPlayersFollowingGame(@PathVariable int gameId){
	return gameDAO.indexOfPlayersFollowingGame(gameId);
	
	}
}
