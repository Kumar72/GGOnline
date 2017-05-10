package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Game;
import entities.Player;
import entities.Team;

@Transactional
@Repository
public class PlayerDAOImpl implements PlayerDAO {
	
	@Autowired
	private PasswordEncoder encoder;

	@PersistenceContext
	private EntityManager em;
	
	
	//show player by id
	@Override
	public Player show(int playerId) {
		Player player = em.find(Player.class, playerId);
		return player;
	}
	
	//update player info
	@Override
	public Player update(int playerId, Player player) {
		System.out.println("###############"+player.getPassword());
		String passwordSha = encoder.encode(player.getPassword());
		Player managed = em.find(Player.class,playerId);
		managed.setUsername(player.getUsername());
		managed.setEmail(player.getEmail());
		managed.setPassword(passwordSha);
		System.out.println("###############"+managed.getPassword());
		managed.setFname(player.getFname());
		managed.setLname(player.getLname());
		
		return managed;
	}
	
	//list all the players
	@Override
	public List<Player> index() {
		String q = "SELECT p FROM Player p";
		List<Player> players = em.createQuery(q, Player.class).getResultList();
		return players;
	}

	//Get a list of friends via player id
	@Override
	public List<Player> friends(int playerId) {
		String q = "SELECT p FROM Player p JOIN FETCH p.friends WHERE p.id=:id";
		try {
			List<Player> players = em.createQuery(q, Player.class).setParameter("id", playerId).getSingleResult().getFriends(); 
			return players;
		} catch (Exception e) {
			List<Player> newTeamList = new ArrayList<>();
			return newTeamList;
		}
	}
	
	//Get a list of team a player is part off
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
	
	//Get a list of games a player likes
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

	//Add a friend
	@Override
	public Player addFriend(int playerId, int friendId) {
		System.err.println(playerId);
		Player player = em.find(Player.class, playerId);
		System.err.println(player.getFriends());
		System.err.println(player.getFriends().size());
		Player friend = em.find(Player.class, friendId);
		player.getFriends().add(friend);
		return friend;
	}
	
	//Add a game to player
	@Override
	public Game addGame(int playerId, int gameId) {
		Game game = em.find(Game.class, gameId);
		Player player = em.find(Player.class, playerId);
		
		player.getGames().add(game);
		
		return game;
	}
	
	//Join a team
	@Override
	public Team joinTeam(int playerId, int teamId) {
		Team team = em.find(Team.class, teamId);
		Player player = em.find(Player.class, playerId);
		
		player.getTeams().add(team);
		return team;
	}
	
	
	
	//Un-friend a player
	@Override
	public boolean unfriend(int playerId, int friendId) {
		System.out.println("In unfriend method in DAOImpl");
		Player player = em.find(Player.class, playerId);		//user id
		Player friend = em.find(Player.class, friendId);		//friend to be removed
		int id = player.getFriends().indexOf(friend);		//get the id of the friend
		List<Player> friends = player.getFriends();		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% Before "+friends.size());
		friends.remove(id);
		player.setFriends(friends);
		System.out.println("************************ After "+player.getFriends().size());
		if(em.find(Player.class, friendId)==null){
			return true;
		}
		else if(em.find(Player.class, friendId)!= null){
			return false;
		}
		return false;
	}
	
	//Remove a game a player likes
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

	//Leave a game
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
