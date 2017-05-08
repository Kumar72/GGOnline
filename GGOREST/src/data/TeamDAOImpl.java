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
	public Team createTeam(int playerId, String teamJson) {
		Game game = em.find(Game.class, 1);
		System.out.println("Enter CREATE TEAM DAOImpl");
		ObjectMapper om = new ObjectMapper();
		Team MappedTeam = null;
		Player player = em.find(Player.class, playerId);
		player.setStatus(true);
		List<Player> players = new ArrayList<>();
		players.add(player);
		System.out.println(player);
		try {			
			MappedTeam = om.readValue(teamJson, Team.class);
			System.out.println(MappedTeam);
			MappedTeam.setPlayers(players);
			MappedTeam.setGame(game);
		} catch (JsonParseException e) {
			System.out.println("##################### 1 @@@@@@@@@@@@@@@@@@@@@");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("##################### 2 @@@@@@@@@@@@@@@@@@@@@");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("##################### 3 @@@@@@@@@@@@@@@@@@@@@");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(MappedTeam);
		em.flush();
		return MappedTeam;
	}
}
