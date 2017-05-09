package data;

import java.util.List;

import entities.Game;
import entities.Player;
import entities.Team;

public interface PlayerDAO {
	
	
	public Player show(int playerId);
	public Player create(Player player);	//we will never call this method from here
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId);
	public List<Player> index();

	public Player update(int playerId, Player player);
	
	public List<Game> indexOfGamesPlayerHas(int playerId);
	
	public Game addGame(int playerId, int gameId);
	
	public boolean removeGameFromPlayer(int playerId, int gameId);
	public Team joinTeam(int playerId, int teamId);
	public boolean leaveTeam(int playerId, int teamId);
	
}
