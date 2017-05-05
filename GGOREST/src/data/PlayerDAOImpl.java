package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Game;
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
		System.out.println(player);
		return player;
	}

	@Override
	public List<Team> indexOfTeamsPlayerIsAMemberOf(int playerId) {
		String q = "SELECT p FROM Player p JOIN FETCH p.teams WHERE p.id=:id";
		return em.createQuery(q, Player.class).setParameter("id", playerId).getSingleResult().getTeams();
		
	}

	@Override
	public Player update(int playerId, Player player) {
		Player managed = em.find(Player.class,playerId);
		managed.setUsername(player.getUsername());
		managed.setEmail(player.getEmail());
		managed.setPassword(player.getPassword());
		managed.setFname(player.getFname());
		managed.setLname(player.getLname());
		managed.setActive(player.getActive());
		managed.setStatus(player.getStatus());
		return player;
	}

	@Override
	public List<Game> indexOfGamesPlayerHas(int playerId) {
		String q = "SELECT p FROM Player p JOIN FETCH p.games WHERE p.id=:id";

		return em.createQuery(q, Player.class).setParameter("id", playerId).getSingleResult().getGames();

        

	}

}
