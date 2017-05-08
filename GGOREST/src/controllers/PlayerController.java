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
import data.PlayerDAO;
import data.TeamDAO;
import entities.Game;
import entities.Player;
import entities.Team;

@RestController
public class PlayerController {
	@Autowired
	PlayerDAO playerDAO;
	TeamDAO teamDAO;
	GameDAO gameDAO;

	@RequestMapping(value = "players/ping", method = RequestMethod.GET)
	public String ping() {
		return "PONG FROM PLAYERS CONTROLLER";
	}

	@RequestMapping(value = "players/{id}", method = RequestMethod.GET)
	public Player show(@PathVariable int id) {
		return playerDAO.show(id);
	}

	@RequestMapping(value = "players", method = RequestMethod.POST)
	public Player create(@RequestBody String playerJson, HttpServletResponse res) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Player mappedPlayer = mapper.readValue(playerJson, Player.class);

			return playerDAO.create(mappedPlayer);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("YOU DON MESSED UP BROH!");
		}
		return null;

	}

	@RequestMapping(value = "players/{playerId}/teams", method = RequestMethod.GET)
	public List<Team> indexOfTeamsPlayerIsAMemberOf(@PathVariable int playerId) {
		return playerDAO.indexOfTeamsPlayerIsAMemberOf(playerId);

	}

	@RequestMapping(value = "players/{playerId}/games", method = RequestMethod.GET)
	public List<Game> indexOfGamesPlayerHas(@PathVariable int playerId) {
		return playerDAO.indexOfGamesPlayerHas(playerId);
	}

	@RequestMapping(value = "players/{playerId}/games/{gameId}", method = RequestMethod.POST)
	public Game addGameToPlayer(@PathVariable("playerId") int playerId, @PathVariable("gameId") int gameId) {
		return playerDAO.addGame(playerId, gameId);
	}
	
	@RequestMapping(value = "players/{playerId}/teams/{teamId}", method = RequestMethod.POST)
	public Team joinTeam(@PathVariable("playerId") int playerId, @PathVariable("teamId") int teamId) {
		return playerDAO.joinTeam(playerId, teamId);
	}
	
	@RequestMapping(value="players/{playerId}/games/{gameId}", method = RequestMethod.DELETE)
	public boolean removeGameFromPlayersList(@PathVariable("playerId") int playerId, @PathVariable("gameId")int gameId){
		return playerDAO.removeGameFromPlayer(playerId, gameId);
	}
	@RequestMapping(value="players/{playerId}/teams/{teamId}", method = RequestMethod.DELETE)
	public boolean leaveTeam(@PathVariable("playerId") int playerId, @PathVariable("teamId")int teamId){
		return playerDAO.leaveTeam(playerId, teamId);
	}
	
	@RequestMapping(value="players/{playerId}/teams", method=RequestMethod.POST)
	public Team create(HttpServletRequest req, HttpServletResponse res, @PathVariable int playerId, @RequestBody String teamJson) {
		ObjectMapper mapper = new ObjectMapper();
		Team team = null;
		System.out.println(teamJson);
		try {
			team = mapper.readValue(teamJson, Team.class);
			System.out.println(team);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(team);
		return teamDAO.createTeam(playerId, team);
	}
	
	
	@RequestMapping(value = "players/{playerId}", method = RequestMethod.PUT)
	public Player update(@PathVariable int playerId, @RequestBody String playerJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Player mappedPlayer = mapper.readValue(playerJson, Player.class);

			return playerDAO.update(playerId, mappedPlayer);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("YOU DON MESSED UP BROH!");
		}
		return null;
	}
}
