package data;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Player;

@Transactional
@Repository
public class AuthDAOImpl implements AuthDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Player register(Player p) {
		if(p.getImage() == null)
		p.setImage("http://lastpage.in/blogAsset/img/avatar-na.png");
		String passwordSha = encoder.encode(p.getPassword());
		p.setPassword(passwordSha);
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public Player login(Player p) throws NoResultException{
		String query = "SELECT p FROM Player p WHERE p.username = :uname";
		Player managedPlayer = em.createQuery(query, Player.class).setParameter("uname", p.getUsername()).getSingleResult();
		if (encoder.matches(p.getPassword(), managedPlayer.getPassword())) {
			return managedPlayer;
		}
		return null;
	}

}
