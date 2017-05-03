package data;

import java.util.List;

import entities.Player;
import entities.Team;

public interface PlayerDAO {
	
	public List<Player> index(int teamId);
	public Player show(int playerId);
	public Player create(Player player);
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId);
	
	
}
