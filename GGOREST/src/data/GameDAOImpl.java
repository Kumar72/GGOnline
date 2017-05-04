package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Game;
import entities.Player;
@Transactional

public class GameDAOImpl implements GameDAO{
	
	@PersistenceContext
	private EntityManager em;

	
	
	@Override
	public List<Game> index() {
		String q = "SELECT g FROM Game g";
		List<Game> game = em.createQuery(q, Game.class).getResultList();
		
		return game;
		
	}

	@Override
	public Game show(int gameId) {
		Game game = em.find(Game.class, gameId);
		return game;
	}

	@Override
	public List<Player> indexOfPlayersFollowingGame(int gameId) {
		String q = "SELECT g from Game g JOIN FETCH g.players where g.id=:id";
		return em.createQuery(q, Game.class).setParameter("id", gameId).getSingleResult().getPlayers();
	}
}
