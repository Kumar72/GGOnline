package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.GameDAO;
import entities.Game;
import entities.Player;
import entities.Team;
@RestController
public class GameController {
	
	@Autowired
	GameDAO gameDAO;

	@RequestMapping(value="games/ping", method=RequestMethod.GET)
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
	
	
//	@RequestMapping(value="games/{gameId}/teams", method=RequestMethod.PUT)
//	public Team create(HttpServletRequest req, HttpServletResponse res, @PathVariable int gameId, @RequestBody String teamJson) {
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@ IN CREATE TEAM METHOD @@@@@@@@@@@@@@@@@@@@@");
//		ObjectMapper om = new ObjectMapper();
//		Team MappedTeam = null;
//		try {			
//			MappedTeam = om.readValue(teamJson, Team.class);
//			System.out.println(MappedTeam);
//		} catch (JsonParseException e) {
//			System.out.println("$$$$$$$$$$$$$$$$$$ ERRROR 1 $$$$$$$$$$$$$$$$$$$$$$$$$");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			System.out.println("$$$$$$$$$$$$$$$$$$ ERRROR 2 $$$$$$$$$$$$$$$$$$$$$$$$$");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("$$$$$$$$$$$$$$$$$$ ERRROR 3 $$$$$$$$$$$$$$$$$$$$$$$$$");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
