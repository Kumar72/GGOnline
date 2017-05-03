package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Team;
@Transactional
public class TeamDAOImpl implements TeamDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public Team show(int teamId) {
		Team team = em.find(Team.class, teamId);	
		return team;
	}
	
	

	@Override
	public List<Team> indexOfPlayers(int teamId) {
		String q = "SELECT t FROM Team t WHERE t.id=:id";
		List<Team> team = em.createQuery(q, Team.class).setParameter("id", teamId).getResultList();
		return team;
	}

	@Override
	public Team create(Team team) {
		em.persist(team);
		em.flush();
		return team;
	}

//	@Override
//	public Team update(int teamId, Team team) {
//		Team managed = em.find(Team.class, teamId);
//		managed.setName(team.getName);
//		return null;
//	}

	@Override
	public boolean destroy(int teamId) {
		Team managed = em.find(Team.class, teamId);
		em.remove(managed);
		em.flush();
		
		if(em.find(Team.class, teamId)==null){
			return true;
		}
		
		else if(em.find(Team.class, teamId)!= null){
			return false;
		}
		
		return false;
	}


}
