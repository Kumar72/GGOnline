package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Message;
import entities.Player;

@Transactional
public class MessageDAOImpl implements MessageDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public List<Message> index() {
		String q = "SELECT m FROM Message m";
		List <Message> message = em.createQuery(q, Message.class).getResultList();
		return message;
	}

	@Override
	public Message show(int messageId) {
		Message message = em.find(Message.class, messageId);
		return message;
	}

	@Override
	public Message createMessage(Message message) {
		em.persist(message);
		em.flush();
		return message;
	}
	
	@Override
	public boolean destroy(int messageId) {
		Message managed = em.find(Message.class, messageId);
//		Player managedPlayer = em.find(Player.class, managed.getUserId());
//		for(Message m : managedPlayer.getMessages()){
//			if(m.getId() == messageId){
//				managedPlayer.getMessages().remove(m);
//			}
//		}
//		em.persist(managedPlayer);
		
		em.remove(managed);
		
		em.flush();
		
		if(em.find(Message.class, messageId)==null){
			return true;
		}
		
		else if(em.find(Message.class, messageId)!= null){
			return false;
		}
		
		return false;
	}

}
