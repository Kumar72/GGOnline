package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TeamDAO;
import entities.Game;
import entities.Player;
import entities.Team;

@RestController
public class TeamController {
	@Autowired
	TeamDAO teamDAO;
	
	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value="teams/ping", method = RequestMethod.GET)
	public String ping(){
		return "PONG FROM TEAM CONTROLLER";
	}
	
	@RequestMapping(value="teams", method=RequestMethod.GET)
	public List<Team> index(){
		return teamDAO.index();
	}
	
	@RequestMapping(value="teams/{id}", method = RequestMethod.GET)
	public Team show(@PathVariable int id){
		return teamDAO.show(id);
	}
	
	
	@RequestMapping(value="teams/{teamId}/players", method = RequestMethod.GET)
		public List<Player> indexOfPlayersFollowingGame(@PathVariable int teamId){
			return teamDAO.indexOfPlayers(teamId);
				
	}
	
	@RequestMapping(value="teams/{teamId}", method = RequestMethod.PUT)
	public Team update(@PathVariable int teamId, Team team){
		
		return teamDAO.update(teamId, team);
	}
}
