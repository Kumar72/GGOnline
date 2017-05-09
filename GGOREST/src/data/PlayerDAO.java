package data;

import java.util.List;

import entities.Game;
import entities.Player;
import entities.Team;

public interface PlayerDAO {
	
	
	public List<Player> index();
	public Player show(int playerId);
	public Player update(int playerId, Player player);

	
	public List<Player> friends(int playerId);
	public List<Game> indexOfGamesPlayerHas(int playerId);
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId);
	
	
	public Game addGame(int playerId, int gameId);
	public Team joinTeam(int playerId, int teamId);
	public Player addFriend(int playerId, int friendId);
	
	public boolean removeGameFromPlayer(int playerId, int gameId);
	public boolean leaveTeam(int playerId, int teamId);
	public boolean unfriend(int playerId, int friendId);
	
	
}
