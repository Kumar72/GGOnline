package data;

import java.util.List;

import entities.Game;
import entities.Player;
import entities.Team;

public interface PlayerDAO {
	
	
	public Player show(int playerId);
	public Player create(Player player);	//we will never call this method from here
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId);

	public Player update(Player player, int playerId);
	
	public List<Game> indexOfGamesPlayerHas(int gameId);
	
	//
	
	
	
}
