package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Game;
import entities.Player;
import entities.Team;
@Transactional
public class TeamDAOImpl implements TeamDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public Team show(int teamId) {
		Team team = em.find(Team.class, teamId);	
		return team;
	}
	
	

	@Override
	public List<Player> indexOfPlayers(int teamId) {
		String q = "SELECT t FROM Team t JOIN FETCH t.players WHERE t.id=:id";
		return em.createQuery(q, Team.class).setParameter("id", teamId).getSingleResult().getPlayers();
		
	}

	@Override
	public Team create(Team team) {
		em.persist(team);
		em.flush();
		return team;
	}

	@Override
	public Team update(int teamId, Team team) {
		Team managed = em.find(Team.class, teamId);
		managed.setName(team.getName());
		return null;
	}

	@Override
	public boolean destroy(int teamId) {
		Team managed = em.find(Team.class, teamId);
		em.remove(managed);
		em.flush();
		
		if(em.find(Team.class, teamId)==null){
			return true;
		}
		
		else if(em.find(Team.class, teamId)!= null){
			return false;
		}
		
		return false;
	}



	@Override
	public Player makeCaptain(int playerId, int teamId) {
		Player managed = em.find(Player.class,playerId);
		managed.setStatus(true);
		return managed;
	}



	@Override
	public Player promoteToCaptain(int playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> index() {
		String q = "SELECT t FROM Team t";
		List<Team> team = em.createQuery(q, Team.class).getResultList();
	
		return team;
	}

	
	@Override
	public Team createTeam(int playerId, int gameId, String teamJson) {
		System.out.println(teamJson);
		System.out.print(playerId);
		ObjectMapper om = new ObjectMapper();
		Team mappedTeam = null;
		Player player = em.find(Player.class, playerId);
		List<Player> p = new ArrayList<>();
		p.add(player);
		Game g = em.find(Game.class, gameId);
		System.out.println("BEFORE TRY");
		try {			
			mappedTeam = om.readValue(teamJson, Team.class);
			System.out.println("TEST 1: "+mappedTeam);
			mappedTeam.setPlayers(p);
			if(mappedTeam.getGame().equals(""))
			mappedTeam.setImage("http://us.battle.net/heroes/static/images/game/game-modes/Icon_team-league.png");
			mappedTeam.setGame(g);
			mappedTeam.setActive(true);
			System.out.println("TEST 2: "+mappedTeam);
		} catch (JsonParseException e) {
			System.out.println("!!!!!!!!!!!!!!  ERRROR 1");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("!!!!!!!!!!!!!!  ERRROR 2");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("!!!!!!!!!!!!!!  ERRROR 3");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(mappedTeam);
		em.flush();
		return mappedTeam;
	}
}
