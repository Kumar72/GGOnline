package data;

import java.util.List;

import entities.Player;
import entities.Team;

public interface TeamDAO {
	
	public Team show(int teamId);	
	public List<Player> indexOfPlayers(int teamId);
	public Team create(Team team);
	public Team update(int teamId, Team team);
	public boolean destroy(int teamId);
	
	//A method to make the player who created the team its captain
	//A method to promote another player to captain 
	//
}
