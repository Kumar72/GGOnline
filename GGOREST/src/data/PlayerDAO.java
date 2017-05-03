package data;

import java.util.List;

import entities.Player;

public interface PlayerDAO {
	
	public List<Player> index(int teamId);
	public Player show(int playerId);
	public Player create(Player player);
	
	
}
