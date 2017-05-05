package data;

import java.util.List;

import entities.Game;
import entities.Player;

public interface GameDAO {
	
	public List<Game>index();
	public Game show(int gameId);
	public List<Player>indexOfPlayersFollowingGame(int gameId);
	
	

}
