package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Player;
import entities.Rating;
@Transactional
public class RatingDAOImpl implements RatingDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Rating> index(int playerId) {
		
		return null;
	}

	@Override
	public Rating show(int playerId, int ratingId) {
		Player player = em.find(Player.class, playerId);
		String q = "SELECT r FROM Rating r JOIN FETCH r.player WHERE r.rating.id = :id";
		em.createQuery(q, Rating.class);
		return null;
		
	}

	@Override
	public Rating create(int playerId, Rating rating) {
		Player player = em.find(Player.class, playerId);
		rating.setUserId(playerId);
		
		em.persist(rating);
		em.flush();
		return rating;
	}
// stretch goal
//	@Override
//	public Rating update(int playerId, Rating rating) {
//
//		
//		return null;
//	}

}
