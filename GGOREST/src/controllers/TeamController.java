package controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TeamDAO;
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
	
	@RequestMapping(value="teams/{id}", method = RequestMethod.GET)
	public Team show(@PathVariable int id){
		return teamDAO.show(id);
	}
}
