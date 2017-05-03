package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Player;
import entities.Team;

@Transactional
public class PlayerDAOImpl implements PlayerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Player show(int playerId) {
		Player player = em.find(Player.class, playerId);
		return player;
	}

	@Override
	public Player create(Player player) {
		em.persist(player);
		em.flush();
		return player;
	}

	@Override
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId) {
		String q="SELECT p FROM Player p JOIN FETCH p.team WHERE p.player.id= :id";
		return (List<Team>) em.createQuery(q, Team.class);
		
	}

}
