package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Game;
import entities.Player;
import entities.Team;

@Transactional
public class PlayerDAOImpl implements PlayerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Player show(int playerId) {
		Player player = em.find(Player.class, playerId);
		return player;
	}

	@Override
	public Player create(Player player) {
		em.persist(player);
		em.flush();
		System.out.println(player);
		return player;
	}

	@Override
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId) {
		String q = "SELECT p FROM Player p JOIN FETCH p.teams WHERE p.id=:id";
		try {
			List<Team> players = em.createQuery(q, Player.class).setParameter("id", playerId).getSingleResult().getTeams(); 
			return players;
		} catch (Exception e) {
			List<Team> newTeamList = new ArrayList<>();
			return newTeamList;
		}
		
	}

	@Override
	public Player update(int playerId, Player player) {
		Player managed = em.find(Player.class,playerId);
		managed.setUsername(player.getUsername());
		managed.setEmail(player.getEmail());
		managed.setPassword(player.getPassword());
		managed.setFname(player.getFname());
		managed.setLname(player.getLname());
		
		return player;
	}

	@Override
	public List<Game> indexOfGamesPlayerHas(int playerId) {
		String q = "SELECT p FROM Player p JOIN FETCH p.games WHERE p.id=:id";
		try{
		List <Game> games = em.createQuery(q, Player.class).setParameter("id", playerId).getSingleResult().getGames();
		return games;
		
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		 
			List<Game> newGamesList = new ArrayList<>();
			return newGamesList;
		}
		
	}

	@Override
	public Game addGame(int playerId, int gameId) {
		Game game = em.find(Game.class, gameId);
		Player player = em.find(Player.class, playerId);
		
		player.getGames().add(game);
		
		return game;
	}

	@Override
	public boolean removeGameFromPlayer(int playerId, int gameId) {
		Player player = em.find(Player.class, playerId);
		Game game = em.find(Game.class, gameId);
		
		int id = player.getGames().indexOf(game);
		List<Game> playerGames = player.getGames();
		System.out.println(playerGames.size());
		playerGames.remove(id);
		player.setGames(playerGames);
		System.out.println(player.getGames().size());
		
		if(em.find(Game.class, gameId)==null){
			return true;
		}
		else if(em.find(Game.class, gameId)!= null){
			return false;
		}
		
		return false;
	}

	@Override
	public Team joinTeam(int playerId, int teamId) {
		Team team = em.find(Team.class, teamId);
		Player player = em.find(Player.class, playerId);
		
		player.getTeams().add(team);
		return team;
	}

	@Override
	public boolean leaveTeam(int playerId, int teamId) {
		Player player = em.find(Player.class, playerId);
		Team team = em.find(Team.class, teamId);
		
		int id = player.getTeams().indexOf(team);
		List<Team> Team = player.getTeams();
		System.out.println(Team.size());
		Team.remove(id);
		player.setTeams(Team);
		System.out.println(player.getGames().size());
		
		if(em.find(Game.class, teamId)==null){
			return true;
		}
		else if(em.find(Game.class, teamId)!= null){
			return false;
		}
		
		return false;
	}

}
