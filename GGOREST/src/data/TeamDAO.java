package data;

import java.util.List;

import entities.Team;

public interface TeamDAO {
	
	public Team show(int teamId);
	
	public List<Team> indexOfPlayers(int teamId);
	
	public Team create(Team team);
	
//	public Team update(int teamId, Team team);
	
	public boolean destroy(int teamId);
}
