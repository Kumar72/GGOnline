package data;

import entities.Player;

public interface AuthDAO {

	public Player register(Player p);
  	public Player login(Player p);
		
}
