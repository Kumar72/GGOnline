package data;

import java.util.List;

import entities.Player;
import entities.Team;

public interface PlayerDAO {
	
	
	public Player show(int playerId);
	public Player create(Player player);	//we will never call this method from here
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId);

	//updating player profile
	/*	Change user password -- encrypt 
	 * 	Change other info associated with a user
	 * */
	
	//List of games a player has
	
	//
	
	
	
}
