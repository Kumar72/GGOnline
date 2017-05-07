package data;

import java.util.List;

import entities.Player;
import entities.Team;

public interface TeamDAO {
	
	public List<Team> index();
	public Team show(int teamId);	
	public List<Player> indexOfPlayers(int teamId);
	public Team create(Team team);
	public Team update(int teamId, Team team);
	public boolean destroy(int teamId);
	
	public Player makeCaptain(int playerId, int teamId);
	public Player promoteToCaptain(int playerId);
	public Team createTeam(int playerId, String todoJson);
	

}
