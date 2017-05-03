package data;

import java.util.List;

import entities.Game;

public interface GameDAO {
	
	public List<Game>index();
	public Game show(int gameId);
	

}
