package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.PlayerDAO;
import entities.Player;
import entities.Team;

@RestController
public class PlayerController {
	@Autowired
	PlayerDAO playerDAO;
	
	@RequestMapping(value="players/ping",method=RequestMethod.GET)
	public String ping(){
		return "PONG FROM PLAYERS CONTROLLER";
	}
	
	@RequestMapping(value="players/{id}", method=RequestMethod.GET)
	public Player show(@PathVariable int id){
		return playerDAO.show(id);
	}
	
	@RequestMapping(value="players", method=RequestMethod.POST)
	public Player create(@RequestBody String playerJson, HttpServletResponse res){
		
		try{
			ObjectMapper mapper = new ObjectMapper();
			Player mappedPlayer = mapper.readValue(playerJson, Player.class);
			
			return playerDAO.create(mappedPlayer);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("YOU DON MESSED UP BROH!");
		}
		return null;
		
	}
	
	@RequestMapping(value="players/{id}/teams", method=RequestMethod.GET)
	public List<Team> indexOfTeamsPlayerIsAMemberOf(@PathVariable int id){
		
		return null;
	}
	

}
