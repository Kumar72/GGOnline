package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Message;

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
	public Message show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message create(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
